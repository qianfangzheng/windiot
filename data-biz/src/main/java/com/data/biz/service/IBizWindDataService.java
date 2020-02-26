package com.data.biz.service;

import java.util.List;
import java.util.Map;

import com.data.biz.domain.BizWindData;

/**
 * 风速统计Service接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-19
 */
public interface IBizWindDataService 
{
    /**
     * 查询风速统计
     * 
     * @param id 风速统计ID
     * @return 风速统计
     */
    public BizWindData selectBizWindDataById(Long id);

    /**
     * 查询风速统计列表
     * 
     * @param bizWindData 风速统计
     * @return 风速统计集合
     */
    public Map<String,List<BizWindData>> selectBizWindDataList();

    /**
     * 新增风速统计
     * 
     * @param bizWindData 风速统计
     * @return 结果
     */
    public int insertBizWindData(BizWindData bizWindData);
    
    public void insertModelData(Integer dateType);

    /**
     * 修改风速统计
     * 
     * @param bizWindData 风速统计
     * @return 结果
     */
    public int updateBizWindData(BizWindData bizWindData);

    /**
     * 批量删除风速统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizWindDataByIds(String ids);

    /**
     * 删除风速统计信息
     * 
     * @param id 风速统计ID
     * @return 结果
     */
    public int deleteBizWindDataById(Long id);
}
