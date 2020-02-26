package com.data.common.exception.user;

/**
 * 用户不存在异常类
 * 
 * 技术支持微信：17725354261
 */
public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}
