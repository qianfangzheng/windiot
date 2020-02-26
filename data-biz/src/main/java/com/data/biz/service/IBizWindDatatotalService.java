package com.data.biz.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.data.biz.domain.BizWindDatatotal;

/**
 * 风速统计Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public interface IBizWindDatatotalService 
{
    /**
     * 查询风速统计
     * 
     * @param id 风速统计ID
     * @return 风速统计
     */
    public BizWindDatatotal selectBizWindDatatotalById(Long id);

    /**
     * 查询风速统计列表
     * 
     * @param bizWindDatatotal 风速统计
     * @return 风速统计集合
     */
    public List<BizWindDatatotal> selectBizWindDatatotalList(BizWindDatatotal bizWindDatatotal);
    
    public void insertModelWindData(Integer dateType);
    /**
     * 	查询最近的年月日记录
     * 
     * @return 风速统计
     */
    public ModelMap recentlyList();

    /**
     * 新增风速统计
     * 
     * @param bizWindDatatotal 风速统计
     * @return 结果
     */
    public int insertBizWindDatatotal(BizWindDatatotal bizWindDatatotal);

    /**
     * 修改风速统计
     * 
     * @param bizWindDatatotal 风速统计
     * @return 结果
     */
    public int updateBizWindDatatotal(BizWindDatatotal bizWindDatatotal);

    /**
     * 批量删除风速统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizWindDatatotalByIds(String ids);

    /**
     * 删除风速统计信息
     * 
     * @param id 风速统计ID
     * @return 结果
     */
    public int deleteBizWindDatatotalById(Long id);
}
