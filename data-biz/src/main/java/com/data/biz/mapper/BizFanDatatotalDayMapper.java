package com.data.biz.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.dto.AvgPowerDTO;
import com.data.biz.dto.BatteryLeftDTO;
import com.data.biz.dto.RunDataDTO;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public interface BizFanDatatotalDayMapper 
{
	/**
	 * 查询指定的风机的发电量日表总和
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
	public BizFanDatatotal selectBizFanDatatotalDayById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 * 
	 * @param bizFanDatatotalDay 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<BizFanDatatotal> selectBizFanDatatotalDayList(BizFanDatatotal bizFanDatatotalDay);

	/**
	 * 新增【请填写功能名称】
	 * 
	 * @param bizFanDatatotalDay 【请填写功能名称】
	 * @return 结果
	 */
	public int insertBizFanDatatotalDay(BizFanDatatotal bizFanDatatotalDay);

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFanDatatotalDay 【请填写功能名称】
	 * @return 结果
	 */
	public int updateBizFanDatatotalDay(BizFanDatatotal bizFanDatatotalDay);

	/**
	 * 删除【请填写功能名称】
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanDatatotalDayById(Long id);

	/**
	 * 批量删除【请填写功能名称】
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBizFanDatatotalDayByIds(String[] ids);

	/**
	 * RunDataDTO对象封装好了
	 * 指定电厂下的所有风机的年发电量总和
	 * 指定电厂下的风机年平均风速
	 * 指定电厂下的风机年平均转速
	 * @param ppId
	 * @return
	 */
	public RunDataDTO selectRunDataDTO(long ppId);


	public List<BizFanDatatotal> getRecentlyPower();

	/**
	 * 根据电厂查询近期的日发电量和日期
	 * @return
	 */
	public List<BatteryLeftDTO> selectBatteryLeftBTO(long ppId);

	/**
	 * 不进行分页的根据电厂查询日发电量数据
	 * @param ppId
	 * @return
	 */
	public List<BatteryLeftDTO> selectBatteryLeftBTONotLimit(long ppId);

	/**
	 * 查看指定电厂下的所有发电机发电量统计
	 * @param ppId
	 * @return
	 */
	public int sumGeneratingCapacity(long ppId);

	/**
	 * 年月日平均功率统计
	 * @return
	 */
	public AvgPowerDTO avgPowerCalculate(long ppid);

}
