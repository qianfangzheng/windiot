package com.data.biz.service.impl;

import java.util.List;
import com.data.common.utils.DateUtils;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.data.biz.mapper.BizFanMapper;
import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanMatrix;
import com.data.biz.dto.FanDetailStatisticsDTO;
import com.data.biz.service.IBizFanService;
import com.data.biz.vo.FanListVo;
import com.data.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
public class BizFanServiceImpl implements IBizFanService 
{
	@Autowired
	private BizFanMapper bizFanMapper;

	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	@Override
	public BizFan selectBizFanById(Long id)
	{
		return bizFanMapper.selectBizFanById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizFan 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<BizFan> selectBizFanList(BizFan bizFan)
	{
		return bizFanMapper.selectBizFanList(bizFan);
	}

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizFan 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertBizFan(BizFan bizFan)
	{
		return bizFanMapper.insertBizFan(bizFan);
	}

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFan 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateBizFan(BizFan bizFan)
	{
		return bizFanMapper.updateBizFan(bizFan);
	}

	/**
	 * 删除【请填写功能名称】对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteBizFanByIds(String ids)
	{
		return bizFanMapper.deleteBizFanByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanById(Long id)
	{
		return bizFanMapper.deleteBizFanById(id);
	}
	/**
	 * 获取风机矩阵列表
	 * @param id 风机id
	 */
	@Override
	public List<BizFanMatrix> getFanMatrix(BizFanMatrix bizFanMatrix) {
		// TODO Auto-generated method stub
		return bizFanMapper.getFanMatrix(bizFanMatrix);
	}


	/**
	 * 查询指定电厂下的风机列表信息
	 * @param ppId
	 * @return
	 */
	public List<FanListVo> listFanListVos(long ppId){
		return bizFanMapper.listFanListVos(ppId);
	}

	/**
	 * 查询风机编号列表
	 * @param ppId
	 * @return
	 */
	public List<Integer> listFanCode(long ppId){
		return bizFanMapper.listFanCode(ppId);
	}

	/**
	 * 根据风机序号查询风机信息
	 * @param fanId
	 * @return
	 */
	public BizFan getFanById(long fanId) {
		return bizFanMapper.getFanById(fanId);
	}

	/**
	 * 根据风机序号查询风机详情页的统计信息
	 * @param fanId
	 * @return
	 */
	public FanDetailStatisticsDTO getFanDetailStatisticsDTO(long fanId) {
		return bizFanMapper.getFanDetailStatisticsDTO(fanId);
	}
}
