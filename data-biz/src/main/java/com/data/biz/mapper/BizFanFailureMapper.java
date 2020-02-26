package com.data.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.data.biz.domain.BizFanFailure;

/**
 * 故障Mapper接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface BizFanFailureMapper 
{
	/**
	 * 查询故障
	 * 
	 * @param id 故障ID
	 * @return 故障
	 */
	public BizFanFailure selectBizFanFailureById(Long id);

	/**
	 * 查询故障列表
	 * 
	 * @param bizFanFailure 故障
	 * @return 故障集合
	 */
	public List<BizFanFailure> selectBizFanFailureList(BizFanFailure bizFanFailure);

	/**
	 * 新增故障
	 * 
	 * @param bizFanFailure 故障
	 * @return 结果
	 */
	public int insertBizFanFailure(BizFanFailure bizFanFailure);

	/**
	 * 修改故障
	 * 
	 * @param bizFanFailure 故障
	 * @return 结果
	 */
	public int updateBizFanFailure(BizFanFailure bizFanFailure);

	/**
	 * 删除故障
	 * 
	 * @param id 故障ID
	 * @return 结果
	 */
	public int deleteBizFanFailureById(Long id);

	/**
	 * 批量删除故障
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanFailureByIds(String[] ids);


	/**
	 * 统计叶片故障(次数)
	 * @param id
	 * @return
	 */
	public int selectVaneCount(Long id);


	/**
	 * 转向故障(次数)
	 * @param id
	 * @return
	 */
	public int selectTurnCount(Long id);


	/**
	 * 统计发电机故障(次数)
	 * @param id
	 * @return
	 */
	public int selectDynamoCount(Long id);


	/**
	 * 统计其他故障(次数)
	 * @param id
	 * @return
	 */
	public int selectElseCount(Long id);


	/**
	 * 报警风机维修(修改警报状态)
	 * @param failureId
	 * @return
	 */
	public int updateStatus(@Param("failureId")long failureId,@Param("remark")String remark);

}
