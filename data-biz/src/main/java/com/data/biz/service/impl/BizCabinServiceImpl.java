package com.data.biz.service.impl;

import java.util.List;
import com.data.common.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.biz.domain.BizCabin;
import com.data.biz.mapper.BizCabinMapper;
import com.data.biz.service.IBizCabinService;
import com.data.common.core.text.Convert;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
@Service
public class BizCabinServiceImpl implements IBizCabinService 
{
	@Autowired
	private BizCabinMapper bizCabinMapper;

	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	@Override
	public BizCabin selectBizCabinById(Long id)
	{
		return bizCabinMapper.selectBizCabinById(id);
	}
	
	
	@Override
	public BizCabin selectBizCabinByFanId(String fan_code)
	{
		return bizCabinMapper.selectBizCabinByFanId(fan_code);
	}

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<BizCabin> selectBizCabinList(BizCabin bizCabin)
	{
		return bizCabinMapper.selectBizCabinList(bizCabin);
	}

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertBizCabin(BizCabin bizCabin)
	{
		return bizCabinMapper.insertBizCabin(bizCabin);
	}

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateBizCabin(BizCabin bizCabin)
	{
		return bizCabinMapper.updateBizCabin(bizCabin);
	}

	/**
	 * 删除【请填写功能名称】对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBizCabinByIds(String ids)
	{
		return bizCabinMapper.deleteBizCabinByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizCabinById(Long id)
	{
		return bizCabinMapper.deleteBizCabinById(id);
	}
}
