package com.data.common.exception.file;

/**
 * 文件名称超长限制异常类
 * 
 * 技术支持微信：17725354261
 */
public class FileNameLengthLimitExceededException extends FileException
{
    private static final long serialVersionUID = 1L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength)
    {
        super("upload.filename.exceed.length", new Object[] { defaultFileNameLength });
    }
}
