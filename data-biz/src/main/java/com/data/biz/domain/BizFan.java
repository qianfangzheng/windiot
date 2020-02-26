package com.data.biz.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.data.common.core.domain.BaseEntity;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public class BizFan extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 序号 */
	private Long id;

	/** 风机编号 */
	private String fanCode;

	/** 风机品牌 */
	private String brand;

	/** 功率 */
	private BigDecimal power;

	/** 实际功率 */
	private BigDecimal realPower;

	/** 坐标 */
	private String coordinates;

	/** 所属电厂 */
	private Long powerPlantId;

	/** 启动时间 */
	private Date startTime;

	/** 安装时间 */
	private Date installTime;

	/** 状态0关闭1开启2异常 */
	private Integer status;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setFanCode(String fanCode) 
	{
		this.fanCode = fanCode;
	}

	public String getFanCode() 
	{
		return fanCode;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}

	public BigDecimal getPower() {
		return power;
	}

	public BigDecimal getRealPower() {
		return realPower;
	}

	public void setRealPower(BigDecimal realPower) {
		this.realPower = realPower;
	}

	public void setCoordinates(String coordinates) 
	{
		this.coordinates = coordinates;
	}

	public String getCoordinates() 
	{
		return coordinates;
	}
	public void setPowerPlantId(Long powerPlantId) 
	{
		this.powerPlantId = powerPlantId;
	}

	public Long getPowerPlantId() 
	{
		return powerPlantId;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setInstallTime(Date installTime) 
	{
		this.installTime = installTime;
	}

	public Date getInstallTime() 
	{
		return installTime;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}

	@Override
	public String toString() {
		return "BizFan [id=" + id + ", fanCode=" + fanCode + ", brand=" + brand + ", power=" + power + ", realPower="
				+ realPower + ", coordinates=" + coordinates + ", powerPlantId=" + powerPlantId + ", startTime="
				+ startTime + ", installTime=" + installTime + ", status=" + status + "]";
	}
}
