package com.data.biz.service;

import java.util.Date;
import java.util.List;

import com.data.biz.dto.PowerDataDTO;

public interface IBizPowerDataService {
	/**
	 * 按照指定类型返回日数据最近七天的日期
	 * @return
	 */
	List<Date> recentlyDayDate(int datatype,int size);
	/**
	 * 返回日数据最近七天的数据
	 * @return
	 */
	List<PowerDataDTO> listPowerDataDTODay();
	/**
	 * 返回日数据最近七天的数据
	 * @return
	 */
	List<PowerDataDTO> listPowerDataDTOMonth();
	/**
	 * 返回日数据最近七天的数据
	 * @return
	 */
	List<PowerDataDTO> listPowerDataDTOYear();
	
	void insertModeData(int dateType);
}
