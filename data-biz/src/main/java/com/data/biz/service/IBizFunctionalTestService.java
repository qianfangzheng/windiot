package com.data.biz.service;

import java.util.List;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanMatrix;
import com.data.biz.vo.FanListVo;
import com.data.common.biz.domain.DBParam;
import com.data.common.biz.domain.DBResult;

/**
 * 【请填写功能名称】Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizFunctionalTestService
{

	/**
	 * 获取全部标签
	 * @return
	 */
	public String[] getAllTags();
	
	public DBResult insertMoreData(DBParam param);
	
	public DBResult insertDataMore(DBParam param);

	

}
