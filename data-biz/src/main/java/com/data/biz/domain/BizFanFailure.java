package com.data.biz.domain;

import java.util.Date;

import com.data.common.annotation.Excel;
import com.data.common.core.domain.BaseEntity;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public class BizFanFailure extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 序号 */
	private Long id;

	/** 风机序号 */
	@Excel(name = "风机序号")
	private Long fanId;

	/** 1.叶片故障
        2.转向故障
        3.发电机故障
        4.其他故障
        2.转向故障
        3.发电机故障
        4.其他故障")*/
    @Excel(name = "故障类型")
	private Integer type;

	/** 负责人 */
    @Excel(name = "负责人")
	private String principal;

	/** 1未处理2处理中3已处理 */
    @Excel(name = "处理情况")
	private Integer status;

	/** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date processingTime;

	/** 处理描述 */
    @Excel(name = "处理描述")
	private String remark;
	
	
	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setFanId(Long fanId) 
	{
		this.fanId = fanId;
	}

	public Long getFanId() 
	{
		return fanId;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setPrincipal(String principal) 
	{
		this.principal = principal;
	}

	public String getPrincipal() 
	{
		return principal;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setProcessingTime(Date processingTime) 
	{
		this.processingTime = processingTime;
	}

	public Date getProcessingTime() 
	{
		return processingTime;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "BizFanFailure [id=" + id + ", fanId=" + fanId + ", type=" + type + ", principal=" + principal
				+ ", status=" + status + ", processingTime=" + processingTime + ", remark=" + remark + "]";
	}
}
