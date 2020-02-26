package com.data.common.exception.user;

import com.data.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * 技术支持微信：17725354261
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
