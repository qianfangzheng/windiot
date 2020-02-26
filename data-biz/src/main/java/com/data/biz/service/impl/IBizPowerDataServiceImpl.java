package com.data.biz.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.data.biz.domain.BizPowerData;
import com.data.biz.dto.PowerDataDTO;
import com.data.biz.mapper.BizPowerDataMapper;
import com.data.biz.service.IBizPowerDataService;
import com.data.common.utils.DateUtils;
import com.data.common.utils.RandomUtil;

@Service
public class IBizPowerDataServiceImpl implements IBizPowerDataService {
	@Autowired
	BizPowerDataMapper bizPowerDataMapper;
	
	public List<Date> recentlyDayDate(int datatype,int size) {
		return bizPowerDataMapper.recentlyDay(datatype,size);
	}
	
	public List<PowerDataDTO> listPowerDataDTODay() {
		return bizPowerDataMapper.listPowerDataDTODay();
	}

	@Override
	public List<PowerDataDTO> listPowerDataDTOMonth() {
		return bizPowerDataMapper.listPowerDataDTOMonth();
	}

	@Override
	public List<PowerDataDTO> listPowerDataDTOYear() {
		return bizPowerDataMapper.listPowerDataDTOYear();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void insertModeData(int dateType) {
		
		//将100划为四份
		int[] a = new int[4];
		a[0] = RandomUtil.getRandom(0, 100);
		a[1] = RandomUtil.getRandom(0, 100-a[0]);
		a[2] = RandomUtil.getRandom(0, 100-a[0]-a[1]);
		a[3] = 100-(a[0]+a[1]+a[2]);
		for (int i = 1; i < 5; i++) {
			BizPowerData powerData = new BizPowerData();
			powerData.setCreateTime(DateUtils.parseDate(DateUtils.getDate()));
			powerData.setDateType(dateType);
			powerData.setPlantId(new Long(1));
			powerData.setRatio(new BigDecimal(a[i-1]));
			powerData.setSection(i);
		}
		
		
	}
}
