package com.data.quartz.util;

import org.quartz.JobExecutionContext;

import com.data.quartz.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 * 
 * 技术支持微信：17725354261
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
