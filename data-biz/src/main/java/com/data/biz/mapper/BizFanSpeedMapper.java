package com.data.biz.mapper;

import java.util.List;

import com.data.biz.domain.BizFanSpeed;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface BizFanSpeedMapper 
{
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizFanSpeed selectBizFanSpeedById(Long id);

	/**
	 * 按照风机id查询
	 * @param fan_code
	 * @return
	 */
	public BizFanSpeed selectBizFanSpeedByFanId(String fan_code);
	
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
	 * 删除【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanSpeedById(Long id);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanSpeedByIds(String[] ids);
}
