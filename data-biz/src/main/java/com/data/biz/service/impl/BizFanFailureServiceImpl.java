package com.data.biz.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.data.common.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.data.biz.mapper.BizFanFailureMapper;
import com.data.biz.mapper.BizFanMapper;
import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanFailure;
import com.data.biz.service.IBizFanFailureService;
import com.data.biz.vo.FanAlertManageVo;
import com.data.biz.vo.WindAlertSelectVo;
import com.data.common.core.domain.AjaxResult;
import com.data.common.core.text.Convert;

/**
 * 故障Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
@Primary
public class BizFanFailureServiceImpl implements IBizFanFailureService 
{
	@Autowired
	private BizFanFailureMapper bizFanFailureMapper;

	@Autowired
	private BizFanMapper bizFanMapper;

	@Autowired
	private IBizFanFailureService bizFanFailureService;
	/**
	 * 查询故障
	 * 
	 * @param id 故障ID
	 * @return 故障
	 */
	@Override
	public BizFanFailure selectBizFanFailureById(Long id)
	{
		return bizFanFailureMapper.selectBizFanFailureById(id);
	}
	

	/**
	 * 处理故障
	 * @param failure_Id
	 * @return
	 */
	public AjaxResult updateStatus(long failure_Id,String remark) {
		int resultCount = bizFanFailureMapper.updateStatus(failure_Id,remark);
		if (resultCount > 0) {
			return new AjaxResult(AjaxResult.Type.SUCCESS, "处理故障成功!");
		}
		return new AjaxResult(AjaxResult.Type.ERROR,"处理故障失败!");
	}
	
	

	/**
	 * 计算故障统计信息
	 * @return
	 */
	public List<WindAlertSelectVo> faultStatistics(){
		List<WindAlertSelectVo> list = new ArrayList<WindAlertSelectVo>();
		List<BizFanFailure> fanFailures = bizFanFailureService.selectBizFanFailureList(null);

		StringBuilder fanStatisticsBuilder = new StringBuilder();
		int count = 0;
		// 先查询出有多少个风机,以及获取其编号,排重!(这里查询的是)
		for (BizFanFailure bizFanFailure : fanFailures) {
			WindAlertSelectVo windAlertSelectVo = new WindAlertSelectVo();
			if (!fanStatisticsBuilder.toString().contains(bizFanFailure.getFanId().toString())) {
				count++;
				// 如果该风机还没有存在,就作为首次记录添加进来
				windAlertSelectVo.setCreate_time(bizFanFailure.getCreateTime());
				windAlertSelectVo.setDynamoCount(bizFanFailureMapper.selectDynamoCount(bizFanFailure.getFanId()));
				windAlertSelectVo.setElseCount(bizFanFailureMapper.selectElseCount(bizFanFailure.getFanId()));
				windAlertSelectVo.setTurnCount(bizFanFailureMapper.selectTurnCount(bizFanFailure.getFanId()));
				windAlertSelectVo.setVaneCount(bizFanFailureMapper.selectVaneCount(bizFanFailure.getFanId()));
				windAlertSelectVo.setFanId(bizFanFailure.getFanId());
				windAlertSelectVo.setId(count);
				list.add(windAlertSelectVo);
				// 用于判断编号排重(添加一个风机即记录一条风机编号)
				fanStatisticsBuilder.append(windAlertSelectVo.getFanId());
			}
		}
		return list;
	}

	/**
	 * 查询故障列表
	 * 
	 * @param bizFanFailure 故障
	 * @return 故障
	 */
	@Override
	public List<BizFanFailure> selectBizFanFailureList(BizFanFailure bizFanFailure)
	{
		return bizFanFailureMapper.selectBizFanFailureList(bizFanFailure);
	}


	/**
	 * 新增故障
	 * 
	 * @param bizFanFailure 故障
	 * @return 结果
	 */
	@Override
	public int insertBizFanFailure(BizFanFailure bizFanFailure)
	{
		return bizFanFailureMapper.insertBizFanFailure(bizFanFailure);
	}

	/**
	 * 修改故障
	 * 
	 * @param bizFanFailure 故障
	 * @return 结果
	 */
	@Override
	public int updateBizFanFailure(BizFanFailure bizFanFailure)
	{
		return bizFanFailureMapper.updateBizFanFailure(bizFanFailure);
	}

	/**
	 * 删除故障对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBizFanFailureByIds(String ids)
	{
		return bizFanFailureMapper.deleteBizFanFailureByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除故障信息
	 * 
	 * @param id 故障ID
	 * @return 结果
	 */
	public int deleteBizFanFailureById(Long id)
	{
		return bizFanFailureMapper.deleteBizFanFailureById(id);
	}

	/**
	 * FanAlertManageVo转vo对象
	 * @param bizFanFailure
	 * @return
	 */
	public FanAlertManageVo transitionFanAlertManageVo(BizFanFailure bizFanFailure) {
		FanAlertManageVo fanAlertManageVo = new FanAlertManageVo();
		BizFan bizFan = 	bizFanMapper.selectBizFanById(bizFanFailure.getFanId());
		fanAlertManageVo.setPower(bizFan.getPower());
		fanAlertManageVo.setFanId(bizFanFailure.getFanId());
		fanAlertManageVo.setCreateTime(bizFanFailure.getCreateTime());
		fanAlertManageVo.setId(bizFanFailure.getId());
		fanAlertManageVo.setPrincipal(bizFanFailure.getPrincipal());
		fanAlertManageVo.setProcessingTime(bizFanFailure.getProcessingTime());
		fanAlertManageVo.setRemark(bizFanFailure.getRemark());
		fanAlertManageVo.setStatus(bizFanFailure.getStatus());
		fanAlertManageVo.setType(bizFanFailure.getType());
		fanAlertManageVo.setBrand(bizFan.getBrand());
		return fanAlertManageVo;
	}

}
