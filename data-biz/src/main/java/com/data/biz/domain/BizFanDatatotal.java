package com.data.biz.domain;

import java.util.Date;

import com.data.common.annotation.Excel;
import com.data.common.core.domain.BaseEntity;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public class BizFanDatatotal extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 序号 */
	@Excel(name = "序号")
	private Long id;

	/** 风机序号 */
	@Excel(name = "风机序号")
	private Long fanId;

	/** 风速 */
	@Excel(name = "风速")
	private Double windSpeed;

	/** 转速 */
	@Excel(name = "转速")
	private Double rotateSpeed;

	/** 发电量 */
	@Excel(name = "发电量")
	private Double powerGeneration;

	/** 功率 */
	@Excel(name = "功率")
	private Double power;

	/** 左偏航次数 */
	@Excel(name = "左偏航次数")
	private Long leftDriftNum;

	/** 左偏航角度 */
	@Excel(name = "左偏航角度")
	private Double leftDriftAngle;

	/** 右偏航次数 */
	@Excel(name = "右偏航次数")
	private Long rightDriftNum;

	/** 右偏航角度 */
	@Excel(name = "右偏航角度")
	private Double rightDriftAngle;

	/** 状态0无效1有效 */
	@Excel(name = "状态")
	private Integer status;
	
	/** 风机品牌 */
    private String brand;
	
	/** 统计时间 */
    private Date createTime;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	public void setWindSpeed(Double windSpeed) 
	{
		this.windSpeed = windSpeed;
	}

	public Double getWindSpeed() 
	{
		return windSpeed;
	}
	public void setRotateSpeed(Double rotateSpeed) 
	{
		this.rotateSpeed = rotateSpeed;
	}

	public Double getRotateSpeed() 
	{
		return rotateSpeed;
	}
	public void setPowerGeneration(Double powerGeneration) 
	{
		this.powerGeneration = powerGeneration;
	}

	public Double getPowerGeneration() 
	{
		return powerGeneration;
	}
	public void setPower(Double power) 
	{
		this.power = power;
	}

	public Double getPower() 
	{
		return power;
	}
	public void setLeftDriftNum(Long leftDriftNum) 
	{
		this.leftDriftNum = leftDriftNum;
	}

	public Long getLeftDriftNum() 
	{
		return leftDriftNum;
	}
	public void setLeftDriftAngle(Double leftDriftAngle) 
	{
		this.leftDriftAngle = leftDriftAngle;
	}

	public Double getLeftDriftAngle() 
	{
		return leftDriftAngle;
	}
	public void setRightDriftNum(Long rightDriftNum) 
	{
		this.rightDriftNum = rightDriftNum;
	}

	public Long getRightDriftNum() 
	{
		return rightDriftNum;
	}
	public void setRightDriftAngle(Double rightDriftAngle) 
	{
		this.rightDriftAngle = rightDriftAngle;
	}

	public Double getRightDriftAngle() 
	{
		return rightDriftAngle;
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
		return "BizFanDatatotal [id=" + id + ", fanId=" + fanId + ", windSpeed=" + windSpeed + ", rotateSpeed="
				+ rotateSpeed + ", powerGeneration=" + powerGeneration + ", power=" + power + ", leftDriftNum="
				+ leftDriftNum + ", leftDriftAngle=" + leftDriftAngle + ", rightDriftNum=" + rightDriftNum
				+ ", rightDriftAngle=" + rightDriftAngle + ", status=" + status + "]";
	}
}
