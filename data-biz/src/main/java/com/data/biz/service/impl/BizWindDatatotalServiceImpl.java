package com.data.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.data.biz.domain.BizWindDatatotal;
import com.data.biz.mapper.BizWindDatatotalMapper;
import com.data.biz.service.IBizWindDatatotalService;
import com.data.common.core.text.Convert;
import com.data.common.utils.DateUtils;
import com.data.common.utils.RandomUtil;

/**
 * 风速统计Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
@Service
public class BizWindDatatotalServiceImpl implements IBizWindDatatotalService 
{
    @Autowired
    private BizWindDatatotalMapper bizWindDatatotalMapper;

    /**
     * 查询风速统计
     * 
     * @param id 风速统计ID
     * @return 风速统计
     */
    @Override
    public BizWindDatatotal selectBizWindDatatotalById(Long id)
    {
        return bizWindDatatotalMapper.selectBizWindDatatotalById(id);
    }

    /**
     * 	查询最近的年月日记录
     * 
     * @return 风速统计
     */
    @Override
    public ModelMap recentlyList()
    {
    	ModelMap map = new ModelMap();
    	map.put("dayData", bizWindDatatotalMapper.selectRecentlyDay());
    	map.put("monthData", bizWindDatatotalMapper.selectRecentlyMonth());
    	map.put("yearData", bizWindDatatotalMapper.selectRecentlyYear());
        return map;
    }
    /**
     * 查询风速统计列表
     * 
     * @param bizWindDatatotal 风速统计
     * @return 风速统计
     */
    @Override
    public List<BizWindDatatotal> selectBizWindDatatotalList(BizWindDatatotal bizWindDatatotal)
    {
        return bizWindDatatotalMapper.selectBizWindDatatotalList(bizWindDatatotal);
    }

    /**
     * 新增风速统计
     * 
     * @param bizWindDatatotal 风速统计
     * @return 结果
     */
    @Override
    public int insertBizWindDatatotal(BizWindDatatotal bizWindDatatotal)
    {
        bizWindDatatotal.setCreateTime(DateUtils.getNowDate());
        return bizWindDatatotalMapper.insertBizWindDatatotal(bizWindDatatotal);
    }
    /**
     * 定时任务
     */
    @Override
    public void insertModelWindData(Integer dateType)
    {
    	BizWindDatatotal bizWindDatatotal = new BizWindDatatotal();
    	bizWindDatatotal.setStatus(1);
        bizWindDatatotal.setType(dateType);
        bizWindDatatotal.setCreateTime(DateUtils.parseDate(DateUtils.getDate()));
        bizWindDatatotal.setEastNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setEastSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setEneNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setEneSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setEseNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setEseSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setNneNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setNneSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setNnwNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setNnwSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setNortheastNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setNortheastSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setNorthNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setNorthSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setNorthwestNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setNorthwestSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setSoutheastNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setSouthwestSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setSseNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setSseSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setSswNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setSswSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setWestNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setWestSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setWnwNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setWnwSpeed(RandomUtil.getDecimal(0, 10));
        bizWindDatatotal.setWswNum(new Long(RandomUtil.getRandom(0, 5)));
        bizWindDatatotal.setWswSpeed(RandomUtil.getDecimal(0, 10));
        
        bizWindDatatotalMapper.insertBizWindDatatotal(bizWindDatatotal);
    }

    /**
     * 修改风速统计
     * 
     * @param bizWindDatatotal 风速统计
     * @return 结果
     */
    @Override
    public int updateBizWindDatatotal(BizWindDatatotal bizWindDatatotal)
    {
        bizWindDatatotal.setUpdateTime(DateUtils.getNowDate());
        return bizWindDatatotalMapper.updateBizWindDatatotal(bizWindDatatotal);
    }

    /**
     * 删除风速统计对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBizWindDatatotalByIds(String ids)
    {
        return bizWindDatatotalMapper.deleteBizWindDatatotalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除风速统计信息
     * 
     * @param id 风速统计ID
     * @return 结果
     */
    public int deleteBizWindDatatotalById(Long id)
    {
        return bizWindDatatotalMapper.deleteBizWindDatatotalById(id);
    }
}
