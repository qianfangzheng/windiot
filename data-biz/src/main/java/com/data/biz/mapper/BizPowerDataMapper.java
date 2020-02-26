package com.data.biz.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.data.biz.domain.BizPowerData;
import com.data.biz.dto.PowerDataDTO;

public interface BizPowerDataMapper {
	/**获取近七天日期*/
	public List<Date> recentlyDay(@Param("datatype")int datatype,@Param("size")int size);
	
	/**获取近七日数据*/
	public List<PowerDataDTO> listPowerDataDTODay();
	
	/**获取近一年数据(最近一年的12个月的数据)*/
	public List<PowerDataDTO> listPowerDataDTOMonth();
	
	/**获取近五年数据(最近五年的数据)*/
	public List<PowerDataDTO> listPowerDataDTOYear();
	
	public int insertModel(BizPowerData powerData);
}