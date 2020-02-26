package com.data.biz.domain;

import java.math.BigDecimal;

import com.data.common.core.domain.BaseEntity;

/**
 * 风机矩阵
 * @author wangze
 *
 */
public class BizFanMatrix  extends BaseEntity{
	private static final long serialVersionUID = 1L;

	private Long plantId;
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

	/** 状态0关闭1开启2异常 */
	private Integer status;
	/**
	 * 风向
	 */
	private BigDecimal direction;
	/**
	 * 风速
	 */
	private BigDecimal windSpeed;
	/**
	 * 转速
	 */
	private BigDecimal rotateSpeed;
	/**
	 * 瞬时功率
	 */
	private BigDecimal instantaneousPower;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFanCode() {
		return fanCode;
	}
	public void setFanCode(String fanCode) {
		this.fanCode = fanCode;
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
	public BigDecimal getRealPower() {
		return realPower;
	}
	public void setRealPower(BigDecimal realPower) {
		this.realPower = realPower;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigDecimal getDirection() {
		return direction;
	}
	public void setDirection(BigDecimal direction) {
		this.direction = direction;
	}
	public BigDecimal getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}
	public BigDecimal getRotateSpeed() {
		return rotateSpeed;
	}
	public void setRotateSpeed(BigDecimal rotateSpeed) {
		this.rotateSpeed = rotateSpeed;
	}
	public BigDecimal getInstantaneousPower() {
		return instantaneousPower;
	}
	public void setInstantaneousPower(BigDecimal instantaneousPower) {
		this.instantaneousPower = instantaneousPower;
	}
	public Long getPlantId() {
		return plantId;
	}
	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}
	
	
	
	
}
