package com.data.biz.service;

import java.util.List;

import com.data.biz.domain.BizCabin;

/**
 * 【请填写功能名称】Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizCabinService 
{
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizCabin selectBizCabinById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizCabin> selectBizCabinList(BizCabin bizCabin);

	/**
	 * 按照风车id查询
	 * @param id
	 * @return
	 */
	BizCabin selectBizCabinByFanId(String fan_code);
	
	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 结果
	 */
	public int insertBizCabin(BizCabin bizCabin);

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 结果
	 */
	public int updateBizCabin(BizCabin bizCabin);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizCabinByIds(String ids);

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizCabinById(Long id);

}
