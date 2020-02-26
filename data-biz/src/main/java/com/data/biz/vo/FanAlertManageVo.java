package com.data.biz.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FanAlertManageVo {
	/** 序号 */
	private Long id;

	/** 风机序号 */
	private Long fanId;

	/** 风机品牌 */
	private String brand;
	/** 1.叶片故障
        2.转向故障
        3.发电机故障
        4.其他故障
        2.转向故障
        3.发电机故障
        4.其他故障")*/
	private Integer type;

	/** 风机功率 */
	private BigDecimal power;

	/** 负责人 */
	private String principal;

	/** 1未处理2处理中3已处理 */
	private Integer status;

	/** 处理时间 */
	private Date processingTime;

	/** 创建时间 */
	private Date createTime;

	/** 处理描述 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFanId() {
		return fanId;
	}

	public void setFanId(Long fanId) {
		this.fanId = fanId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getPower() {
		return power;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(Date processingTime) {
		this.processingTime = processingTime;
	}

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "FanAlertManageVo [id=" + id + ", fanId=" + fanId + ", brand=" + brand + ", type=" + type + ", power="
				+ power + ", principal=" + principal + ", status=" + status + ", processingTime=" + processingTime
				+ ", createTime=" + createTime + ", remark=" + remark + "]";
	}
}
