package com.data.biz.service;

import java.util.List;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanMatrix;
import com.data.biz.dto.FanDetailStatisticsDTO;
import com.data.biz.vo.FanListVo;

/**
 * 【请填写功能名称】Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizFanService 
{
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizFan selectBizFanById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizFan 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizFan> selectBizFanList(BizFan bizFan);

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizFan 【请填写功能名称】
	 * @return 结果
	 */
	public int insertBizFan(BizFan bizFan);

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFan 【请填写功能名称】
	 * @return 结果
	 */
	public int updateBizFan(BizFan bizFan);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanByIds(String ids);

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanById(Long id);

	public List<BizFanMatrix> getFanMatrix(BizFanMatrix bizFanMatrix);

	/**
	 * 查询指定电厂下的风机列表信息
	 * @param ppId
	 * @return
	 */
	List<FanListVo> listFanListVos(long ppId);

	/**
	 * 查询风机编号列表
	 * @param ppId
	 * @return
	 */
	List<Integer> listFanCode(long ppId);
	
	/**
	 * 根据风机序号查询指定风机信息
	 * @param fanId
	 * @return
	 */
	BizFan getFanById(long fanId);
	
	/**
	 * 根据风机序号查询风机详情页的统计信息查询
	 * @param fanId
	 * @return
	 */
	FanDetailStatisticsDTO getFanDetailStatisticsDTO(long fanId);
}
