package com.data.biz.mapper;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanMatrix;
import com.data.biz.dto.FanDetailStatisticsDTO;
import com.data.biz.vo.FanListVo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface BizFanMapper 
{
	
	/**
	 * 计算指定风机发电小时数
	 * @param fanId
	 * @return
	 */
	public BigDecimal selectFanGeneratingHours(long fanId);
	/**
	 *  统计风机数量(根据电厂查询)
	 * @return
	 */
	public int countBizFan(long ppId);
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
	 * 删除【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanById(Long id);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanByIds(String[] ids);
	
	
	public List<BizFanMatrix> getFanMatrix(BizFanMatrix bizFanMatrix);
	
	/**
	 * 查询指定电厂下的风机列表信息(返回封装好的Vo对象)
	 * @param ppId
	 * @return
	 */
	List<FanListVo> listFanListVos(@Param("ppId")long ppId);
	
	/**
	 * 查询指定电厂下的所有风机编号
	 * @return
	 */
	List<Integer> listFanCode(@Param("ppId")long ppId);
	
	/**
	 * 根据风机序号查询指定风机信息
	 * @param fanId
	 * @return
	 */
	BizFan getFanById(@Param("fanId")long fanId);
	
	/**
	 * 根据风机序号查询指定风机详情中的统计信息
	 * @return
	 */
	FanDetailStatisticsDTO getFanDetailStatisticsDTO(@Param("fanId")long fanId);
	
}
