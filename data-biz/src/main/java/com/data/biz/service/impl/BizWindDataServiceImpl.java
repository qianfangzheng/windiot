package com.data.biz.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.data.biz.domain.BizWindData;
import com.data.biz.mapper.BizWindDataMapper;
import com.data.biz.mapper.BizWindDatatotalMapper;
import com.data.biz.service.IBizWindDataService;
import com.data.common.core.text.Convert;
import com.data.common.utils.DateUtils;
import com.data.common.utils.RandomUtil;

/**
 * 风速统计Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-19
 */
@Service
public class BizWindDataServiceImpl implements IBizWindDataService 
{
    @Autowired
    private BizWindDataMapper bizWindDataMapper;
    @Autowired
    private BizWindDatatotalMapper bizWindDatatotalMapper;
    /**
     * 查询风速统计
     * 
     * @param id 风速统计ID
     * @return 风速统计
     */
    @Override
    public BizWindData selectBizWindDataById(Long id)
    {
        return bizWindDataMapper.selectBizWindDataById(id);
    }

    /**
     * 查询风速统计列表
     * 
     * @param bizWindData 风速统计
     * @return 风速统计
     */
    @Override
    public Map<String,List<BizWindData>> selectBizWindDataList()
    {	
    	BizWindData bizWindDataDay = new BizWindData();
    	BizWindData bizWindDataMonth = new BizWindData();
    	BizWindData bizWindDataYear = new BizWindData();
    	//模拟数据
    	//当前时间
    	bizWindDataDay.setCreateTime(DateUtils.getDate());
    	bizWindDataMonth.setCreateTime("2019-11%");
    	bizWindDataYear.setCreateTime("2018%");
    	
    	/**
    	 * 正规参数
    	 */
    	SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    	SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
    	SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        //上年
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -12);
        Date dateYear = c.getTime();
        //上月
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.add(Calendar.MONTH, -1);
        Date dateMonth = c1.getTime();
        //昨日
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.add(Calendar.DATE, -1);
        Date dateDay = c2.getTime();
        //上年
        System.out.println(sdfYear.format(dateYear));
        //上月
        System.out.println(sdfMonth.format(dateMonth));
        //昨日
        System.out.println(sdfDay.format(dateDay));
        Map<String,List<BizWindData>> map = new HashMap<String,List<BizWindData>>();
        map.put("dayData", bizWindDataMapper.selectBizWindDataList(bizWindDataDay));
        map.put("monthData", bizWindDataMapper.selectBizWindDataListMonth(bizWindDataMonth));
        map.put("yearData", bizWindDataMapper.selectBizWindDataListYear(bizWindDataYear));
        
        
//    	bizWindDataMapper.selectBizWindDataList(bizWindDataDay);
//    	bizWindDataMapper.selectBizWindDataListMonth(bizWindDataMonth);
//    	bizWindDataMapper.selectBizWindDataListYear(bizWindDataYear);
        return map;
    }

    /**
     * 新增风速统计
     * 
     * @param bizWindData 风速统计
     * @return 结果
     */
    @Override
    public int insertBizWindData(BizWindData bizWindData)
    {
        return bizWindDataMapper.insertBizWindData(bizWindData);
    }
    /**
     * 定时任务
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void insertModelData(Integer dateType)
    {
    	for (int i = 1; i < 8; i++) {
    		BizWindData bizWindData = new BizWindData();
    		bizWindData.setInterval(i);
        	bizWindData.setStatus(1);
        	bizWindData.setType(dateType);
        	bizWindData.setCreateTime(DateUtils.getDate());
        	bizWindData.setEastTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setEneTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setEseTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setNeTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setNneTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setNnwTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setNorthTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setNwTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setSeTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setSouthTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setSseTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setSswTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setSwTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setWestTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setWnwTime(RandomUtil.getDecimal(0, 10));
        	bizWindData.setWswTime(RandomUtil.getDecimal(0, 10));
        	
        	bizWindDataMapper.insertBizWindData(bizWindData);
		}
    	
    }
    

    /**
     * 修改风速统计
     * 
     * @param bizWindData 风速统计
     * @return 结果
     */
    @Override
    public int updateBizWindData(BizWindData bizWindData)
    {
        return bizWindDataMapper.updateBizWindData(bizWindData);
    }

    /**
     * 删除风速统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBizWindDataByIds(String ids)
    {
        return bizWindDataMapper.deleteBizWindDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除风速统计信息
     * 
     * @param id 风速统计ID
     * @return 结果
     */
    public int deleteBizWindDataById(Long id)
    {
        return bizWindDataMapper.deleteBizWindDataById(id);
    }
}
