package com.data.common.exception.user;

/**
 * 用户锁定异常类
 * 
 * 技术支持微信：17725354261
 */
public class UserBlockedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserBlockedException()
    {
        super("user.blocked", null);
    }
}
