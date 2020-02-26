package com.data.common.biz.util;



import java.util.ArrayList;
import java.util.List;

import com.data.common.biz.domain.DBParam;
import com.data.common.biz.domain.DBResult;

import TrendDB.API;
import TrendDB.ConfigPosition;
import TrendDB.DB_Exception;
import TrendDB.DB_Time;
import TrendDB.DB_Value;
import TrendDB.TagConfig;

public class TrendDBUtil {
    private static String[] servers = null;
    static String connId = PropertiesUtil.getValue("connId");
    static String username = PropertiesUtil.getValue("username");
    static String password = PropertiesUtil.getValue("password");
    static {
    	String serversStr = PropertiesUtil.getValue("servers");
    	servers = serversStr.split(",");
    	try {
			API.InitNameServers(servers);
		} catch (DB_Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void createConnection() {
		try {
			// 测试连通性
			API.ListServers();
			System.out.println("服务地址无误!");
			int resultCount = API.CreateConnection(connId,false,true, username, password);
			API.TestServer(connId);
			System.out.println("连接测试无误!");
			
			
		} catch (Exception e) {
            e.printStackTrace();
		}
    }
    
    public static void closeConnection() {
		try {
			API.CloseConnection(connId);
			System.out.println("连接关闭完成!");
		} catch (DB_Exception e) {
			e.printStackTrace();
		}
	}
    /**
     * 获取fan全部标签
     */
    public static String[] getAllTags() { 
    	List<String> names = new ArrayList<String>();
		try {
			ConfigPosition pos = new ConfigPosition();
			API.SetTagFilter(0,"name", "fan");
			int count = API.TagCount(connId, pos);
			
			for (int i = 0; i < count; ++i) {
				try {
					TagConfig[] tags = API.ListTags(connId, pos);
					for (int j = 0; j < tags.length; ++j) {
						names.add(tags[j].name);
					}
				} catch (DB_Exception ex) {
					break;
				}
			}
			String[] tags = new String[names.size()];
			tags = names.toArray(tags);
			return tags;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
    
    /**
     * 单标签批量插入数据
     */
    public static DBResult insertMoreData(DBParam param) {
    	DBResult result = new DBResult();
    	String name = param.getName();
    	System.out.println(param.getData());
		try {
			
				DB_Time now = API.TimeNow();
				DB_Time begin = API.TimeNow();
				String beignTime = API.FormatTime(begin);
				System.out.println("BEGIN: " + 0 + ", " + beignTime);
				result.setBeginTime(beignTime);
				//次数
				Integer time = param.getNum()/100;
				Integer otherTime = param.getNum()-time*100;
				
				DB_Value[] values = new DB_Value[100];
				DB_Value[] values2 = new DB_Value[otherTime];
				if(param.getDataType()==2) {	//随机数
					for (int d = 0; d < 100; ++d) {
						API.TimeAdd(now, 1, 0);
						values[d] = new DB_Value();
						values[d].time = new DB_Time();
						values[d].time.hours = now.hours;
						values[d].time.usecs = now.usecs;
						values[d].status = 3;
						values[d].value = Float.parseFloat(param.getData());
					}
					for (int d = 0; d < otherTime; ++d) {
						API.TimeAdd(now, 1, 0);
						values2[d] = new DB_Value();
						values2[d].time = new DB_Time();
						values2[d].time.hours = now.hours;
						values2[d].time.usecs = now.usecs;
						values2[d].status = 3;
						values2[d].value = Float.parseFloat(param.getData());
					}
				}else {	//自定义数
					for (int d = 0; d < 100; ++d) {
						API.TimeAdd(now, 1, 0);
						values[d] = new DB_Value();
						values[d].time = new DB_Time();
						values[d].time.hours = now.hours;
						values[d].time.usecs = now.usecs;
						values[d].status = 3;
						values[d].value = (float) Math.random();
					}
					for (int d = 0; d < otherTime; ++d) {
						API.TimeAdd(now, 1, 0);
						values[d] = new DB_Value();
						values[d].time = new DB_Time();
						values[d].time.hours = now.hours;
						values[d].time.usecs = now.usecs;
						values[d].status = 3;
						values[d].value = (float) Math.random();
					}
				}
				for (int i = 1; i <= time; ++i) {
					try {
						API.InsertBlockValueByName(connId, name, values);
					} catch (DB_Exception ex) {
						System.out.println("internal exception: " + ex.GetErrMsg());
					}
				}
				if(otherTime != 0) {	//余数
					API.InsertBlockValueByName(connId, name, values2);
				}
				DB_Time end = API.TimeNow();
				String endTime = API.FormatTime(end);
				System.out.println("END: " + endTime);
				double duration = (end.hours - begin.hours) * 3600.0 + (end.usecs - begin.usecs) / 1000.0 / 1000.0;
				duration = (double) Math.round(duration * 1000) / 1000;
				result.setEndTime(endTime);
				result.setDuration(duration);
				result.setRate((double) Math.round((param.getNum()/duration) * 100) / 100);
				result.setNum(param.getNum());
				result.setTagsNum(1);
				System.out.println("Duration: " + duration + ", rate:" + param.getNum()/duration);
			API.FlushConnectionBuffer(connId);
		} catch (DB_Exception ex) {
			System.out.println(ex.GetErrMsg());
		}
		return result;
	}
    /**
     * 	多标签多数据
     */
    public static DBResult insertDataMore(DBParam param) {
    	DBResult result = new DBResult();
    	String[] names = param.getName1().split(",");
    	DB_Value[] values = new DB_Value[names.length];
    	DB_Time now = API.TimeNow();
    	DB_Time begin = API.TimeNow();
		String beignTime = API.FormatTime(now);
		System.out.println("BEGIN: " + 0 + ", " + beignTime);
		result.setBeginTime(beignTime);
    	if(param.getDataType1()==1) {	//随机数
    		for (int i = 0; i < names.length; i++) {
        		values[i] = new DB_Value();
    			values[i].time = new DB_Time();
    			values[i].time.hours = now.hours;
    			values[i].time.usecs = now.usecs;
    			values[i].status = 3;
    			values[i].value = (float) (10 + Math.random() * (20 - 10 + 1));
        	}
		}else {	//自定义数
			for (int i = 0; i < names.length; i++) {
	    		values[i] = new DB_Value();
				values[i].time = new DB_Time();
				values[i].time.hours = now.hours;
				values[i].time.usecs = now.usecs;
				values[i].status = 3;
				values[i].value = Float.parseFloat(param.getData1());
	    	}
		}
    	for (int i = 1; i <= param.getNum1(); ++i) {
			try {
				API.UpdateValueByName(connId, names, values);
			} catch (DB_Exception ex) {
				System.out.println("internal exception: " + ex.GetErrMsg());
			}
		}
    	DB_Time end = API.TimeNow();
		String endTime = API.FormatTime(end);
		System.out.println("END: " + endTime);
		double duration = (end.hours - begin.hours) * 3600.0 + (end.usecs - begin.usecs) / 1000.0 / 1000.0;
		duration = (double) Math.round(duration * 1000) / 1000;
		result.setEndTime(endTime);
		result.setDuration(duration);
		result.setRate((double) Math.round((param.getNum1()*names.length/duration ) * 100) / 100);
		result.setNum(param.getNum1()*names.length);
		result.setTagsNum(names.length);
		System.out.println("Duration: " + duration + ", rate:" + param.getNum1()/duration);

		try {
			API.FlushConnectionBuffer(connId);
		} catch (DB_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
    
    
}
