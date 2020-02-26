package com.data.common.exception.user;

/**
 * 角色锁定异常类
 * 
 * 技术支持微信：17725354261
 */
public class RoleBlockedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public RoleBlockedException()
    {
        super("role.blocked", null);
    }
}
