package com.data.biz.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.data.biz.domain.BizPlantDataTotal;
import com.data.biz.domain.BizPowerPlant;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public interface BizPowerPlantMapper 
{

	/**
	 * 查询该电厂总共发电了多久
	 * @return
	 */
	public BigDecimal selectFanGeneratingHours();
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizPowerPlant selectBizPowerPlantById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizPowerPlant 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizPowerPlant> selectBizPowerPlantList(BizPowerPlant bizPowerPlant);

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizPowerPlant 【请填写功能名称】
	 * @return 结果
	 */
	public int insertBizPowerPlant(BizPowerPlant bizPowerPlant);

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizPowerPlant 【请填写功能名称】
	 * @return 结果
	 */
	public int updateBizPowerPlant(BizPowerPlant bizPowerPlant);

	/**
	 * 删除【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizPowerPlantById(Long id);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizPowerPlantByIds(String[] ids);
	
	public BizPlantDataTotal getPlantDataById(Long id);
}
