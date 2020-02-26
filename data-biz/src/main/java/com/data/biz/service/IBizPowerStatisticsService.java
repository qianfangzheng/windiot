package com.data.biz.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.data.biz.domain.BizFanDatatotal;

public interface IBizPowerStatisticsService {
	public List<BizFanDatatotal> getPower();
	
	public List<BizFanDatatotal> getMonthPower();
	
	public List<BizFanDatatotal> getYearPower();
}
