package com.data.web.quartz;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.data.biz.domain.BizCabin;
import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.domain.BizFanSpeed;
import com.data.biz.service.IBizFanService;
import com.data.biz.domain.BizFanSpeed;
import com.data.biz.service.IBizFanDatatotalDayService;
import com.data.biz.service.IBizPowerDataService;
import com.data.biz.service.IBizWindDataService;
import com.data.biz.service.IBizWindDatatotalService;
import com.data.biz.vo.FanSocketVo;
import com.data.common.biz.util.PropertiesUtil;
import com.data.common.utils.spring.SpringUtils;
import com.data.web.socket.WebSocketServer;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import TrendDB.API;
import TrendDB.DB_Exception;
import TrendDB.DB_Time;
import TrendDB.DB_Value;

public class BizQuartzJob {
	private static String connId = PropertiesUtil.getValue("connId");
	private IBizFanDatatotalDayService fanDatatotalDayService = SpringUtils.getBean(IBizFanDatatotalDayService.class);
	private IBizWindDataService windDataService = SpringUtils.getBean(IBizWindDataService.class);
	private IBizWindDatatotalService windDatatotalService = SpringUtils.getBean(IBizWindDatatotalService.class);
	private IBizPowerDataService powerDataService = SpringUtils.getBean(IBizPowerDataService.class);
	/**
	 * 对TrendDB进行查询的定时任务
	 * @param currentId
	 */
	public void BizQuartzJobSelect(String currentId) {
		// 获取WebSocketServer对象的映射
		ConcurrentHashMap<String,WebSocketServer> map = WebSocketServer.getWebSocketMap();
		if (map.size() != 0) {
			// 判断此时如果有websocket,我们就获取对应的session来进行推送数据
			for (Map.Entry<String, WebSocketServer> entry : map.entrySet()) {
				WebSocketServer webSocketServer = entry.getValue();
				// 并且这个websocket是有用户正在连接中的
				if (webSocketServer.getOnlineCount() > 0) {
					if (webSocketServer.getClientPort() != 0) {
						try {
							//							 /** 机舱温度 */
							//						    private Double cabinT;
							//
							//						    /** 齿轮箱油温度 */
							//						    private Double oilT;
							//
							//						    /** 齿轮箱低速轴温度 */
							//						    private Double lowShaftT;
							//
							//						    /** 齿轮箱高速轴温度 */
							//						    private Double highShaftT;

							int fanCode = webSocketServer.getClientPort();
							// 这个时候与websocket建立连接的是风机详情页面
							Map<String, Object> mapObject = Maps.newHashMap();
							DB_Value[] fanAcVoltage = API.GetLatestValueByName(connId, new String[] {"fan.acVoltage."+fanCode});// 交流电压
							DB_Value[] fanOutput = API.GetLatestValueByName(connId, new String[] {"fan.fanOutput."+fanCode});// 发电机输出
							DB_Value[] fanOutputFrequency = API.GetLatestValueByName(connId, new String[] {"fan.fanOutputFrequency."+fanCode});// 输出频率
							DB_Value[] fanFactor = API.GetLatestValueByName(connId, new String[] {"fan.fanFactor."+fanCode});// 功率因素
							DB_Value[] direction = API.GetLatestValueByName(connId, new String[] {"wind.direction"});// 当前风向角
							DB_Value[] cabinAngle = API.GetLatestValueByName(connId, new String[] {"fan.cabinAngle."+fanCode});// 机舱角度
							DB_Value[] oilPressure = API.GetLatestValueByName(connId, new String[] {"fan.oilPressure."+fanCode});// 齿轮油压力

							DB_Value[] cabinT = API.GetLatestValueByName(connId, new String[] {"fan.cabinT."+fanCode});// 机舱温度
							DB_Value[] oilT = API.GetLatestValueByName(connId, new String[] {"fan.oilT."+fanCode});// 齿轮箱油温度
							DB_Value[] lowShaftT = API.GetLatestValueByName(connId, new String[] {"fan.lowt."+fanCode});// 齿轮箱低速轴温度
							DB_Value[] highShaftT = API.GetLatestValueByName(connId, new String[] {"fan.hight."+fanCode});// 齿轮箱高速轴温度
							mapObject.put("fanAcVoltage", fanAcVoltage[0].value);
							mapObject.put("fanOutput", fanOutput[0].value);
							mapObject.put("fanOutputFrequency", fanOutputFrequency[0].value);
							mapObject.put("fanFactor", fanFactor[0].value);
							mapObject.put("windDirection", direction[0].value);
							mapObject.put("fanCabinAngle", cabinAngle[0].value);
							mapObject.put("fanOilPressure", oilPressure[0].value);
							mapObject.put("cabinT", cabinT[0].value);
							mapObject.put("oilT", oilT[0].value);
							mapObject.put("lowShaftT", lowShaftT[0].value);
							mapObject.put("highShaftT", highShaftT[0].value);
							webSocketServer.getSession().getBasicRemote().sendObject(mapObject);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							List<Integer> listFanCode = webSocketServer.getFanCodeList();
							DB_Value[] windSpeedValues = API.GetLatestValueByName(connId, new String[] {"wind.direction"});// 风速角
							DB_Value[] directionValues = API.GetLatestValueByName(connId, new String[] {"wind.speed"});// 风向
							BizFanSpeed bizFanSpeed = new BizFanSpeed();
							bizFanSpeed.setDirection(Double.valueOf(String.format("%.2f", windSpeedValues[0].value)));// 风向
							bizFanSpeed.setWindSpeed(Double.valueOf(String.format("%.2f", directionValues[0].value)));// 风速角
							Map<String, Object> mapObject = Maps.newHashMap();
							mapObject.put("bizFanSpeed", bizFanSpeed);

							for (Integer num : listFanCode) {
								DB_Value[] fanInstantaneousPower = API.GetLatestValueByName(connId, new String[] {"fan.instantaneousPower."+num});// 瞬时功率
								DB_Value[] fanRotateSpeed = API.GetLatestValueByName(connId, new String[] {"fan.rotateSpeed."+num});// 风轮转速
								FanSocketVo fanSocketVo =new FanSocketVo(num
										, Double.valueOf(String.format("%.2f", fanInstantaneousPower[0].value))// 瞬时功率
										, Double.valueOf(String.format("%.2f", fanRotateSpeed[0].value)));// 风轮转速
								mapObject.put(String.valueOf(num), fanSocketVo);
							}
							webSocketServer.getSession().getBasicRemote().sendObject(mapObject);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}else {
			System.out.println("Websocket还没有连接哦!");
		}
	}

	/**
	 * 对TrendDB插入最新的风机信息数据
	 * @param currentId
	 */
	public void BizQuartzJobInsert(String currentId) {
		// 获取WebSocketServer对象的映射
		List<Integer> listFanCode = Lists.newArrayList();
		Integer[] num = null;
		int onlineCount = 0;
		ConcurrentHashMap<String,WebSocketServer> map = WebSocketServer.getWebSocketMap();
		if (map.size() != 0) {
			// 遍历websocket进程
			for (Map.Entry<String, WebSocketServer> entry : map.entrySet()) {
				WebSocketServer webSocketServer = entry.getValue();
				onlineCount = webSocketServer.getOnlineCount();
				listFanCode = webSocketServer.getFanCodeList();
				num = new Integer[listFanCode.size()];
				num = listFanCode.toArray(num);
			}
			if (onlineCount > 0) {
				String[] sys_vars = { "cabinT","cabinAngle","oilT","lowt","hight","oilPressure","acVoltage","fanOutput","fanOutputFrequency","fanFactor","instantaneousPower","rotateSpeed" };
				String windSpeed = "wind.speed";
				String windDirection  = "wind.direction";
				String tmp = "fan.";
				int N = num.length;//风机个数
				String[] names = new String[sys_vars.length*N+2];
				DB_Value[] values = new DB_Value[names.length];
				DB_Time tNow = API.TimeNow();
				for (int i = 0; i < num.length; i++) {
					//风机在风机id数组中的位置
					for(int j = 0; j < sys_vars.length; j++) {
						int k = i*sys_vars.length+j;
						names[k]=tmp+sys_vars[j]+"."+num[i];
						values[k] = new DB_Value();
						values[k].time = new DB_Time();
						values[k].time.hours = tNow.hours;
						values[k].time.usecs = tNow.usecs;
						values[k].status = 3;
						values[k].value = (float) (10+Math.random()*(20-10+1));
					}
				}


				names[names.length-2] = windSpeed;
				values[names.length-2] = new DB_Value();
				values[names.length-2].time = new DB_Time();
				values[names.length-2].time.hours = tNow.hours;
				values[names.length-2].time.usecs = tNow.usecs;
				values[names.length-2].status = 3;
				values[names.length-2].value = (float) (10+Math.random()*(20-10+1));
				names[names.length-1] = windDirection;
				values[names.length-1] = new DB_Value();
				values[names.length-1].time = new DB_Time();
				values[names.length-1].time.hours = tNow.hours;
				values[names.length-1].time.usecs = tNow.usecs;
				values[names.length-1].status = 3;
				values[names.length-1].value = (float) (10+Math.random()*(20-10+1));

				long tBegin = System.currentTimeMillis();
				API.TimeAdd(tNow, 1, 0);


				try {
					API.UpdateValueByName(connId, names, values);
				} catch (DB_Exception ex) {
					System.out.println("UpdateValueByName failed due to:" + ex.GetErrMsg() + ", error: " + ex.errno);
				}
				try {
					API.FlushConnectionBuffer(connId);
				} catch (DB_Exception e) {
					e.printStackTrace();
				}
				long tDuration = System.currentTimeMillis() - tBegin;
				System.out.println("5 millions tags: " + tDuration + " ms");

			}	
		}
	}
	public void DataModelDay(String dateType) {
		System.out.println("********************************");
		//数据日表
		fanDatatotalDayService.insertBizFanDatatotal();
		//区间风速表 日
		windDataService.insertModelData(Integer.parseInt(dateType));
		//平均风速表 日
		windDatatotalService.insertModelWindData(Integer.parseInt(dateType));
		//区间功率表 日
		powerDataService.insertModeData(Integer.parseInt(dateType));
	}
	public void ceshi(String id) {
		System.out.println("测试我的定时任务!");
	}
}
