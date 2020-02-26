package com.data.biz.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.data.common.core.domain.BaseEntity;

public class FanyawSelectVo extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	/** 序号 */
    private Long id;

    /** 统计时间 */
    private Date create_time;
    
    /** 风机序号 */
    private Long fanId;

    /** 风机品牌 */
    private String brand;
    
    /** 风机功率 */
	private BigDecimal power;
    
    /** 左偏航次数 */
    private Long leftDriftNum;

    /** 左偏航角度 */
    private Double leftDriftAngle;

    /** 右偏航次数 */
    private Long rightDriftNum;

    /** 右偏航角度 */
    private Double rightDriftAngle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Long getFanId() {
		return fanId;
	}

	public void setFanId(Long fanId) {
		this.fanId = fanId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPower() {
		return power;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}

	public Long getLeftDriftNum() {
		return leftDriftNum;
	}

	public void setLeftDriftNum(Long leftDriftNum) {
		this.leftDriftNum = leftDriftNum;
	}

	public Double getLeftDriftAngle() {
		return leftDriftAngle;
	}

	public void setLeftDriftAngle(Double leftDriftAngle) {
		this.leftDriftAngle = leftDriftAngle;
	}

	public Long getRightDriftNum() {
		return rightDriftNum;
	}

	public void setRightDriftNum(Long rightDriftNum) {
		this.rightDriftNum = rightDriftNum;
	}

	public Double getRightDriftAngle() {
		return rightDriftAngle;
	}

	public void setRightDriftAngle(Double rightDriftAngle) {
		this.rightDriftAngle = rightDriftAngle;
	}

	@Override
	public String toString() {
		return "FanyawSelectVo [id=" + id + ", create_time=" + create_time + ", fanId=" + fanId + ", brand=" + brand
				+ ", power=" + power + ", leftDriftNum=" + leftDriftNum + ", leftDriftAngle=" + leftDriftAngle
				+ ", rightDriftNum=" + rightDriftNum + ", rightDriftAngle=" + rightDriftAngle + "]";
	}

    
}
