package com.data.biz.service;

import com.data.biz.domain.BizFanSpeed;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizFanSpeedService 
{
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizFanSpeed selectBizFanSpeedById(Long id);


	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizFanSpeed 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizFanSpeed> selectBizFanSpeedList(BizFanSpeed bizFanSpeed);

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizFanSpeed 【请填写功能名称】
	 * @return 结果
	 */
	public int insertBizFanSpeed(BizFanSpeed bizFanSpeed);

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFanSpeed 【请填写功能名称】
	 * @return 结果
	 */
	public int updateBizFanSpeed(BizFanSpeed bizFanSpeed);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanSpeedByIds(String ids);

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanSpeedById(Long id);
}
