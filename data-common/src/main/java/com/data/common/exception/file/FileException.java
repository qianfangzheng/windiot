package com.data.common.exception.file;

import com.data.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * 技术支持微信：17725354261
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
