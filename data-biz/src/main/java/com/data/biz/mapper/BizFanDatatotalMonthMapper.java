package com.data.biz.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.dto.BatteryLeftDTO;
import com.data.biz.dto.RunDataDTO;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public interface BizFanDatatotalMonthMapper 
{
	/**
	 * 查询指定的风机的发电量月表总和
	 * @param fanId
	 * @return
	 */
	public BigDecimal selectGeneratingCapacity(long fanId);
	/**
	 * 查询【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 【请填写功能名称】
	 */
	public BizFanDatatotal selectBizFanDatatotalMonthById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizFanDatatotalMonth 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizFanDatatotal> selectBizFanDatatotalMonthList(BizFanDatatotal bizFanDatatotalMonth);

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizFanDatatotalMonth 【请填写功能名称】
	 * @return 结果
	 */
	public int insertBizFanDatatotalMonth(BizFanDatatotal bizFanDatatotalMonth);

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFanDatatotalMonth 【请填写功能名称】
	 * @return 结果
	 */
	public int updateBizFanDatatotalMonth(BizFanDatatotal bizFanDatatotalMonth);

	/**
	 * 删除【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanDatatotalMonthById(Long id);


	/**
	 * RunDataDTO对象封装好了
	 * 指定电厂下的所有风机的年发电量总和
	 * 指定电厂下的风机年平均风速
	 * 指定电厂下的风机年平均转速
	 * @param ppId
	 * @return
	 */
	public RunDataDTO selectRunDataDTO(long ppId);
	
    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizFanDatatotalMonthByIds(String[] ids);
    
    
    public List<BizFanDatatotal> getRecentlyPower();
    
    
    /**
	 * 根据电厂查询近期的日发电量和日期
	 * @return
	 */
	public List<BatteryLeftDTO> selectBatteryLeftBTO(long ppId);
	
	
	/**
	 * 不进行分页的根据电厂查询月发电量数据
	 * @param ppId
	 * @return
	 */
	public List<BatteryLeftDTO> selectBatteryLeftBTONotLimit(long ppId);
}
