package com.data.biz.service;

import java.util.List;

import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.dto.BatteryLeftDTO;

/**
 * 【请填写功能名称】Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizFanDatatotalYearService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public BizFanDatatotal selectBizFanDatatotalById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param BizFanDatatotal 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BizFanDatatotal> selectBizFanDatatotalList(BizFanDatatotal BizFanDatatotal);

    /**
     * 新增【请填写功能名称】
     * 
     * @param BizFanDatatotal 【请填写功能名称】
     * @return 结果
     */
    public int insertBizFanDatatotal(BizFanDatatotal BizFanDatatotal);

    /**
     * 修改【请填写功能名称】
     * 
     * @param BizFanDatatotal 【请填写功能名称】
     * @return 结果
     */
    public int updateBizFanDatatotal(BizFanDatatotal BizFanDatatotal);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizFanDatatotalByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteBizFanDatatotalById(Long id);
    
    /**
	 * 查询指定电厂下的所有风机的年电量统计(包含日期)
	 * @param ppId
	 * @return
	 */
	List<BatteryLeftDTO> listGeneratingCapacityDay(long ppId);
	
	/**
	 * 根据电厂查询近期的年发电量和日期(不适用limit)
	 * @return
	 */
    public List<BatteryLeftDTO> selectBatteryLeftBTONotLimit(long ppId);
}
