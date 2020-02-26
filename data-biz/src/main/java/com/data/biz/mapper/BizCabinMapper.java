package com.data.biz.mapper;
import java.util.List;

import com.data.biz.domain.BizCabin;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface BizCabinMapper 
{
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizCabin selectBizCabinById(Long id);


	/**
	 * 按照风机查询
	 * @param id
	 * @return
	 */
	public BizCabin selectBizCabinByFanId(String fan_code);
	
	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizCabin 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizCabin> selectBizCabinList(BizCabin bizCabin);

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
	 * 删除【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizCabinById(Long id);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizCabinByIds(String[] ids);
}
