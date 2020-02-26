package com.data.biz.mapper;

import java.util.List;

import com.data.biz.domain.BizWindData;

/**
 * 风速统计Mapper接口
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-19
 */
public interface BizWindDataMapper 
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
    public List<BizWindData> selectBizWindDataList(BizWindData bizWindData);
    public List<BizWindData> selectBizWindDataListMonth(BizWindData bizWindData);
    public List<BizWindData> selectBizWindDataListYear(BizWindData bizWindData);

    /**
     * 新增风速统计
     * 
     * @param bizWindData 风速统计
     * @return 结果
     */
    public int insertBizWindData(BizWindData bizWindData);

    /**
     * 修改风速统计
     * 
     * @param bizWindData 风速统计
     * @return 结果
     */
    public int updateBizWindData(BizWindData bizWindData);

    /**
     * 删除风速统计
     * 
     * @param id 风速统计ID
     * @return 结果
     */
    public int deleteBizWindDataById(Long id);

    /**
     * 批量删除风速统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBizWindDataByIds(String[] ids);
}
