package com.data.biz.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizPowerPlant;
import com.data.biz.dto.AvgPowerDTO;
import com.data.biz.dto.RunDataDTO;
import com.data.biz.mapper.BizFanDatatotalDayMapper;
import com.data.biz.mapper.BizFanDatatotalMonthMapper;
import com.data.biz.mapper.BizFanDatatotalYearMapper;
import com.data.biz.mapper.BizFanMapper;
import com.data.biz.mapper.BizPowerPlantMapper;
import com.data.biz.service.IBizFanService;
import com.data.biz.service.IBizRunDataService;
import com.data.biz.vo.RunDataVo;

@Service
public class BizRunDataServiceImpl implements IBizRunDataService {

	@Autowired
	private BizFanMapper bizFanMapper;

	@Autowired
	private BizPowerPlantMapper bizPowerPlantMapper;

	@Autowired
	private BizFanDatatotalDayMapper bizFanDatatotalDayMapper;

	@Autowired
	private BizFanDatatotalMonthMapper bizFanDatatotalMonthMapper;

	@Autowired
	private BizFanDatatotalYearMapper bizFanDatatotalYearMapper;

	@Override
	public RunDataVo selectRunDataVo(long ppId) {
		RunDataVo runDataVo = new RunDataVo();
		RunDataDTO runDataDTOYear = bizFanDatatotalYearMapper.selectRunDataDTO(ppId);
		RunDataDTO runDataDTOMonth = bizFanDatatotalMonthMapper.selectRunDataDTO(ppId);
		RunDataDTO runDataDTODay = bizFanDatatotalDayMapper.selectRunDataDTO(ppId);
		AvgPowerDTO avgPowerDTO = bizFanDatatotalDayMapper.avgPowerCalculate(ppId);// 获取指定电厂下年月日的功率
		// 查出指定电厂对象
		BizPowerPlant bizPowerPlant = bizPowerPlantMapper.selectBizPowerPlantById(ppId);
		runDataVo.setFanCount(bizFanMapper.countBizFan(ppId));// 查询风机数量(查询指定电厂下的风机数量)
		runDataVo.setGeneratingHours(bizPowerPlantMapper.selectFanGeneratingHours());// 设置发电小时数(当前时间减电厂的创建时间)
		runDataVo.setGeneratingTotal(new BigDecimal(bizFanDatatotalDayMapper.sumGeneratingCapacity(ppId)));// 设置累计发电量(该电厂下的所有风机的年月日表的发电量数据总和)
		runDataVo.setCapacityTotal(Integer.valueOf(bizPowerPlant.getCapacity()));// 设置电厂装机容量
		// 年月日发电量查询:
		runDataVo.setGeneratingCapacityYear(runDataDTOYear.getGeneratingCapacity());// 年发电量
		runDataVo.setGeneratingCapacityMonth(runDataDTOMonth.getGeneratingCapacity());// 月发电量
		runDataVo.setGeneratingCapacityDay(runDataDTODay.getGeneratingCapacity());// 日发电量
		// 平均风速 年月日平均风速查询
		BigDecimal avgWindSpeedSum = runDataDTOYear.getAvgWindSpeed().add(runDataDTOMonth.getAvgWindSpeed()).add(runDataDTODay.getAvgWindSpeed());
		System.out.println("平均风速:"+avgWindSpeedSum);
		runDataVo.setAvgWindSpeed(avgWindSpeedSum.divide(new BigDecimal(3),2,BigDecimal.ROUND_DOWN));// 平均风速
		runDataVo.setAvgWindSpeedYear(runDataDTOYear.getAvgWindSpeed());// 年平均风速
		runDataVo.setAvgWindSpeedMonth(runDataDTOMonth.getAvgWindSpeed());// 月平均风速
		runDataVo.setAvgWindSpeedDay(runDataDTODay.getAvgWindSpeed());// 日平均风速
        // 平均风轮转速 年月日平均风轮转速
		BigDecimal avgRotateSpeedSum = runDataDTOYear.getAvgRotateSpeed().add(runDataDTOMonth.getAvgRotateSpeed()).add(runDataDTODay.getAvgRotateSpeed());
		runDataVo.setAvgRotateSpeed(avgRotateSpeedSum.divide(new BigDecimal(3),2,BigDecimal.ROUND_DOWN));// 平均转速
		runDataVo.setAvgRotateSpeedYear(runDataDTOYear.getAvgRotateSpeed());// 年平均转速
		runDataVo.setAvgRotateSpeedMonth(runDataDTOMonth.getAvgRotateSpeed());// 月平均转速
		runDataVo.setAvgRotateSpeedDay(runDataDTODay.getAvgRotateSpeed());// 日平均转速
		runDataVo.setAvgPowerDay(avgPowerDTO.getAvgPowerDay());// 日平均功率
		runDataVo.setAvgPowerMonth(avgPowerDTO.getAvgPowerMonth());// 月平均功率
		runDataVo.setAvgPowerYear(avgPowerDTO.getAvgPowerYear());// 年平均功率
//		runDataVo.setGeneratingCapacityDay(bizFanDatatotalDayMapper.selectGeneratingCapacity(""));
		return runDataVo;
	}

	/**
	 *  计算指定电厂下的风机发电量总和(性能低下,放弃使用)
	 * @return
	 */
//	public BigDecimal FanGeneratingCapacitySum(long ppId) {
//		BigDecimal GeneratingSum = new BigDecimal(0);// 初始化电量总和
//		BizFan bizFan = new BizFan();
//		bizFan.setPowerPlantId(ppId);
//		List<BizFan> fans = bizFanMapper.selectBizFanList(bizFan);// 查询指定电厂下的所有风机记录,封装成list集合
//		for (BizFan bizFan_Item : fans) {
//			// 每次循环计算指定风机的年月日的发电量总和
//			System.out.println(Long.valueOf(bizFan_Item.getFanCode()));
//			if (bizFanDatatotalDayMapper.selectGeneratingCapacity(Long.valueOf(bizFan_Item.getFanCode()))!=null) {
//				GeneratingSum = GeneratingSum.add(bizFanDatatotalDayMapper.selectGeneratingCapacity(Long.valueOf(bizFan_Item.getFanCode())));
//			}
//		}
//		return GeneratingSum;
//	}
}
