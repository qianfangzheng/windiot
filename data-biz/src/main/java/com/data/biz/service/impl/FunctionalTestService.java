package com.data.biz.service.impl;

import org.springframework.stereotype.Service;

import com.data.biz.service.IBizFunctionalTestService;
import com.data.common.biz.domain.DBParam;
import com.data.common.biz.domain.DBResult;
import com.data.common.biz.util.TrendDBUtil;


/**
 * 性能测试 Service业务层处理
 * 
 * @author wangze
 * @date 2019-12-27
 */
@Service
public class FunctionalTestService implements IBizFunctionalTestService 
{

	/**
	 * 	获取全部标签
	 */
	@Override
	public String[] getAllTags() {
		TrendDBUtil.createConnection();
		String[] names = TrendDBUtil.getAllTags();
		TrendDBUtil.closeConnection();
		return names;
	}

	@Override
	public DBResult insertMoreData(DBParam param) {
		DBResult result = new DBResult();
		TrendDBUtil.createConnection();
		result = TrendDBUtil.insertMoreData(param);
		TrendDBUtil.closeConnection();
		return result;
	}

	@Override
	public DBResult insertDataMore(DBParam param) {
		DBResult result = new DBResult();
		TrendDBUtil.createConnection();
		result = TrendDBUtil.insertDataMore(param);
		TrendDBUtil.closeConnection();
		return result;
	}

	
}
