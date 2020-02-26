package com.data.biz.service.impl;

import java.util.List;
import com.data.common.utils.DateUtils;
import com.data.common.utils.RandomUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.data.biz.domain.BizFan;
import com.data.biz.domain.BizFanDatatotal;
import com.data.biz.dto.BatteryLeftDTO;
import com.data.biz.mapper.BizFanDatatotalDayMapper;
import com.data.biz.mapper.BizFanMapper;
import com.data.biz.service.IBizFanDatatotalDayService;
import com.data.biz.vo.FanyawSelectVo;
import com.data.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
public class BizFanDatatotalDayServiceImpl implements IBizFanDatatotalDayService 
{
	@Autowired
	private BizFanDatatotalDayMapper bizFanDatatotalDayMapper;

	@Autowired
	private BizFanMapper bizFanMapper;


	/**
	 * 定时插入风机日数据统计
	 * 
	 * @param bizFanDatatotalDay
	 * @return 结果
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void insertBizFanDatatotal()
	{
		System.out.println("****1111111111111111111111***********");
		BizFanDatatotal bizFanDatatotalDay = new BizFanDatatotal();
		List<Integer> list = bizFanMapper.listFanCode(1);
		for (Integer id : list) {
			bizFanDatatotalDay.setFanId(new Long(id));
			bizFanDatatotalDay.setLeftDriftAngle(RandomUtil.getDecimal(0, 20));
			bizFanDatatotalDay.setLeftDriftNum(new Long(RandomUtil.getRandom(0, 3)));
			bizFanDatatotalDay.setRightDriftAngle(RandomUtil.getDecimal(0, 20));
			bizFanDatatotalDay.setRightDriftNum(new Long(RandomUtil.getRandom(0, 3)));
			bizFanDatatotalDay.setPower(RandomUtil.getDecimal(95, 105));
			bizFanDatatotalDay.setPowerGeneration(RandomUtil.getDecimal(90, 110));
			bizFanDatatotalDay.setRotateSpeed(RandomUtil.getDecimal(50, 65));
			bizFanDatatotalDay.setWindSpeed(RandomUtil.getDecimal(0, 10));
			bizFanDatatotalDay.setCreateTime(DateUtils.parseDate(DateUtils.getDate()));
			bizFanDatatotalDayMapper.insertBizFanDatatotalDay(bizFanDatatotalDay);
		}
		
		
	}

	/**
	 * 修改【请填写功能名称】
	 * 
	 * @param bizFanDatatotalDay 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateBizFanDatatotal(BizFanDatatotal bizFanDatatotalDay)
	{
		return bizFanDatatotalDayMapper.updateBizFanDatatotalDay(bizFanDatatotalDay);
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
		return bizFanDatatotalDayMapper.deleteBizFanDatatotalDayByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除【请填写功能名称】信息
	 * 
	 * @param id 【请填写功能名称】ID
	 * @return 结果
	 */
	public int deleteBizFanDatatotalById(Long id)
	{
		return bizFanDatatotalDayMapper.deleteBizFanDatatotalDayById(id);
	}

	@Override
	public BizFanDatatotal selectBizFanDatatotalById(Long id) {
		return bizFanDatatotalDayMapper.selectBizFanDatatotalDayById(id);
	}

	@Override
	public List<BizFanDatatotal> selectBizFanDatatotalList(BizFanDatatotal BizFanDatatotal) {
		return bizFanDatatotalDayMapper.selectBizFanDatatotalDayList(BizFanDatatotal);
	}

	/**
	 * Vo对象转换(渲染给前端)
	 * @param bizFanDatatotal
	 * @return
	 */
	public FanyawSelectVo transformFanyawSelectVo(BizFanDatatotal bizFanDatatotal) {
		FanyawSelectVo fanyawSelectVo = new FanyawSelectVo();
		BizFan bizFan = bizFanMapper.selectBizFanById(bizFanDatatotal.getFanId());
		fanyawSelectVo.setBrand(bizFan.getBrand());
		fanyawSelectVo.setCreate_time(bizFanDatatotal.getCreateTime());
		fanyawSelectVo.setFanId(bizFanDatatotal.getFanId());
		fanyawSelectVo.setId(bizFanDatatotal.getId());
		fanyawSelectVo.setLeftDriftAngle(bizFanDatatotal.getLeftDriftAngle());
		fanyawSelectVo.setLeftDriftNum(bizFanDatatotal.getLeftDriftNum());
		fanyawSelectVo.setRightDriftAngle(bizFanDatatotal.getRightDriftAngle());
		fanyawSelectVo.setRightDriftNum(bizFanDatatotal.getRightDriftNum());
		fanyawSelectVo.setPower(bizFan.getPower());
		return fanyawSelectVo;
	}

	/**
	 * 查询日表中的发电量统计
	 * @return
	 */
	public List<BatteryLeftDTO> listGeneratingCapacityDay(long ppId){
		return bizFanDatatotalDayMapper.selectBatteryLeftBTO(ppId);
	}

	@Override
	public List<BatteryLeftDTO> selectBatteryLeftBTONotLimit(long ppId) {
		return bizFanDatatotalDayMapper.selectBatteryLeftBTONotLimit(ppId);
	}

	@Override
	public double sumCalculate(long ppId) {
		return bizFanMapper.countBizFan(ppId);
	}

	@Override
	public List<BatteryLeftDTO> listGeneratingCapacityDay() {
		// TODO Auto-generated method stub
		return null;
	}

}
