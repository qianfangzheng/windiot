package com.data.biz.service.impl;

import java.util.List;
import com.data.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.data.biz.mapper.BizFanDatatotalMonthMapper;
import com.data.biz.service.IBizFanDatatotalMonthService;
import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.dto.BatteryLeftDTO;
import com.data.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
public class BizFanDatatotalMonthServiceImpl implements IBizFanDatatotalMonthService 
{
    @Autowired
    private BizFanDatatotalMonthMapper bizFanDatatotalMonthMapper;

    /**
         * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public BizFanDatatotal selectBizFanDatatotalById(Long id)
    {
        return bizFanDatatotalMonthMapper.selectBizFanDatatotalMonthById(id);
    }

    /**
         * 查询【请填写功能名称】列表
     * 
     * @param bizFanDatatotalMonth 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BizFanDatatotal> selectBizFanDatatotalList(BizFanDatatotal bizFanDatatotalMonth)
    {
        return bizFanDatatotalMonthMapper.selectBizFanDatatotalMonthList(bizFanDatatotalMonth);
    }

    /**
         * 新增【请填写功能名称】
     * 
     * @param bizFanDatatotalMonth 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBizFanDatatotal(BizFanDatatotal bizFanDatatotalMonth)
    {
        return bizFanDatatotalMonthMapper.insertBizFanDatatotalMonth(bizFanDatatotalMonth);
    }

    /**
         * 修改【请填写功能名称】
     * 
     * @param bizFanDatatotalMonth 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBizFanDatatotal(BizFanDatatotal bizFanDatatotalMonth)
    {
        return bizFanDatatotalMonthMapper.updateBizFanDatatotalMonth(bizFanDatatotalMonth);
    }

    /**
         * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBizFanDatatotalByIds(String ids)
    {
        return bizFanDatatotalMonthMapper.deleteBizFanDatatotalMonthByIds(Convert.toStrArray(ids));
    }

    /**
         * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
	@Override
	public int deleteBizFanDatatotalById(Long id) {
		return bizFanDatatotalMonthMapper.deleteBizFanDatatotalMonthById(id);
	}
	
	/**
	 * 查询月表中的发电量统计
	 * @return
	 */
	public List<BatteryLeftDTO> listGeneratingCapacityDay(long ppId){
		return bizFanDatatotalMonthMapper.selectBatteryLeftBTO(ppId);
	}

	@Override
	public List<BatteryLeftDTO> selectBatteryLeftBTONotLimit(long ppId) {
		return bizFanDatatotalMonthMapper.selectBatteryLeftBTONotLimit(ppId);
	}
	
}
