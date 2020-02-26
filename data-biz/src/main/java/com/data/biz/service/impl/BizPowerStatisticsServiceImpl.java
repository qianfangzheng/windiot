package com.data.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.mapper.BizFanDatatotalDayMapper;
import com.data.biz.mapper.BizFanDatatotalMonthMapper;
import com.data.biz.mapper.BizFanDatatotalYearMapper;
import com.data.biz.service.IBizPowerStatisticsService;
@Service
public class BizPowerStatisticsServiceImpl implements IBizPowerStatisticsService {

	@Autowired
	private BizFanDatatotalDayMapper fanDatatotalDayMapper;
	@Autowired
	private BizFanDatatotalMonthMapper fanDatatotalMonthMapper;
	@Autowired
	private BizFanDatatotalYearMapper fanDatatotalYearOMapper;
	
	@Override
	public List<BizFanDatatotal> getPower() {
		return fanDatatotalDayMapper.getRecentlyPower();
	}

	@Override
	public List<BizFanDatatotal> getMonthPower() {
		return fanDatatotalMonthMapper.getRecentlyPower();
	}

	@Override
	public List<BizFanDatatotal> getYearPower() {
		return fanDatatotalYearOMapper.getRecentlyPower();
	}

}
