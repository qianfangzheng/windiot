package com.data.biz.service.impl;

import java.util.List;
import com.data.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.data.biz.mapper.BizPowerPlantMapper;
import com.data.biz.domain.BizPlantDataTotal;
import com.data.biz.domain.BizPowerPlant;
import com.data.biz.service.IBizPowerPlantService;
import com.data.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
public class BizPowerPlantServiceImpl implements IBizPowerPlantService 
{
    @Autowired
    private BizPowerPlantMapper bizPowerPlantMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public BizPowerPlant selectBizPowerPlantById(Long id)
    {
        return bizPowerPlantMapper.selectBizPowerPlantById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bizPowerPlant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BizPowerPlant> selectBizPowerPlantList(BizPowerPlant bizPowerPlant)
    {
        return bizPowerPlantMapper.selectBizPowerPlantList(bizPowerPlant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param bizPowerPlant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBizPowerPlant(BizPowerPlant bizPowerPlant)
    {
        return bizPowerPlantMapper.insertBizPowerPlant(bizPowerPlant);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param bizPowerPlant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBizPowerPlant(BizPowerPlant bizPowerPlant)
    {
        return bizPowerPlantMapper.updateBizPowerPlant(bizPowerPlant);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBizPowerPlantByIds(String ids)
    {
        return bizPowerPlantMapper.deleteBizPowerPlantByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteBizPowerPlantById(Long id)
    {
        return bizPowerPlantMapper.deleteBizPowerPlantById(id);
    }

    /**
     * 电厂数据统计
     */
	@Override
	public BizPlantDataTotal getPlantDataById(Long id) {
		return bizPowerPlantMapper.getPlantDataById(id);
	}
}
