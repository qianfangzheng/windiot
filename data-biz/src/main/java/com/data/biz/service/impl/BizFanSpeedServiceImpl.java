package com.data.biz.service.impl;

import java.util.List;
import com.data.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.data.biz.mapper.BizFanSpeedMapper;
import com.data.biz.domain.BizFanSpeed;
import com.data.biz.service.IBizFanSpeedService;
import com.data.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
public class BizFanSpeedServiceImpl implements IBizFanSpeedService 
{
	@Autowired
	private BizFanSpeedMapper bizFanSpeedMapper;

	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	@Override
	public BizFanSpeed selectBizFanSpeedById(Long id)
	{
		return bizFanSpeedMapper.selectBizFanSpeedById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizFanSpeed 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<BizFanSpeed> selectBizFanSpeedList(BizFanSpeed bizFanSpeed)
	{
		return bizFanSpeedMapper.selectBizFanSpeedList(bizFanSpeed);
	}

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizFanSpeed 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertBizFanSpeed(BizFanSpeed bizFanSpeed)
	{
		return bizFanSpeedMapper.insertBizFanSpeed(bizFanSpeed);
	}

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFanSpeed 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateBizFanSpeed(BizFanSpeed bizFanSpeed)
	{
		return bizFanSpeedMapper.updateBizFanSpeed(bizFanSpeed);
	}

	/**
	 * 删除【请填写功能名称】对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBizFanSpeedByIds(String ids)
	{
		return bizFanSpeedMapper.deleteBizFanSpeedByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanSpeedById(Long id)
	{
		return bizFanSpeedMapper.deleteBizFanSpeedById(id);
	}
}
