package com.data.common.exception.user;

/**
 * 用户账号已被删除
 * 
 * 技术支持微信：17725354261
 */
public class UserDeleteException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserDeleteException()
    {
        super("user.password.delete", null);
    }
}
