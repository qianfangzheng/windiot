package com.data.biz.service;

import java.util.List;

import com.data.biz.domain.BizFanFailure;
import com.data.biz.vo.FanAlertManageVo;
import com.data.biz.vo.WindAlertSelectVo;
import com.data.common.core.domain.AjaxResult;

/**
 * 故障Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizFanFailureService 
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
	 * 批量删除故障
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanFailureByIds(String ids);

	/**
	 * 删除故障信息
	 * 
	 * @param id 故障ID
	 * @return 结果
	 */
	public int deleteBizFanFailureById(Long id);

	/**
	 * 将对象转换为Vo对象
	 * @param bizFanFailure
	 * @return
	 */
	FanAlertManageVo transitionFanAlertManageVo(BizFanFailure bizFanFailure);
	
	/**
	  * 故障记录统计方法
	 * @return
	 */
	List<WindAlertSelectVo> faultStatistics();
	
	/**
	 * 风机故障处理(修改状态)
	 * @param failure_Id
	 * @return
	 */
	AjaxResult updateStatus(long failure_Id,String remark);
}
