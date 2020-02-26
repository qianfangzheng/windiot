package com.data.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.core.text.Convert;
import com.data.common.utils.DateUtils;
import com.data.system.domain.SysUsers;
import com.data.system.mapper.SysUsersMapper;
import com.data.system.service.ISysUsersService;

/**
 * 增删改查测试Service业务层处理
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-02
 */
@Service
public class SysUsersServiceImpl implements ISysUsersService 
{
    @Autowired
    private SysUsersMapper sysUsersMapper;

    /**
     * 查询增删改查测试
     * 
     * @param id 增删改查测试ID
     * @return 增删改查测试
     */
    @Override
    public SysUsers selectSysUsersById(Long id)
    {
        return sysUsersMapper.selectSysUsersById(id);
    }

    /**
     * 查询增删改查测试列表
     * 
     * @param sysUsers 增删改查测试
     * @return 增删改查测试
     */
    @Override
    public List<SysUsers> selectSysUsersList(SysUsers sysUsers)
    {
        return sysUsersMapper.selectSysUsersList(sysUsers);
    }

    /**
     * 新增增删改查测试
     * 
     * @param sysUsers 增删改查测试
     * @return 结果
     */
    @Override
    public int insertSysUsers(SysUsers sysUsers)
    {
        sysUsers.setCreateTime(DateUtils.getNowDate());
        return sysUsersMapper.insertSysUsers(sysUsers);
    }

    /**
     * 修改增删改查测试
     * 
     * @param sysUsers 增删改查测试
     * @return 结果
     */
    @Override
    public int updateSysUsers(SysUsers sysUsers)
    {
        sysUsers.setUpdateTime(DateUtils.getNowDate());
        return sysUsersMapper.updateSysUsers(sysUsers);
    }

    /**
     * 删除增删改查测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUsersByIds(String ids)
    {
        return sysUsersMapper.deleteSysUsersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除增删改查测试信息
     * 
     * @param id 增删改查测试ID
     * @return 结果
     */
    public int deleteSysUsersById(Long id)
    {
        return sysUsersMapper.deleteSysUsersById(id);
    }
}
