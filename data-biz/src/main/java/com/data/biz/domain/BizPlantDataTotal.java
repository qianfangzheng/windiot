package com.data.biz.domain;

import java.math.BigDecimal;
/**
 * 电厂统计
 * @author wangze
 *
 */
public class BizPlantDataTotal {
	/**
	 * 风机总数
	 */
	private Integer fanNum;
	/**
	 * 装机总容量
	 */
	private BigDecimal capacity;
	/**
	 * 发电总量
	 */
	private BigDecimal powerGenerationNum;
	/**
	 * 发电总小时数
	 */
	private Integer hours;
	public Integer getFanNum() {
		return fanNum;
	}
	public void setFanNum(Integer fanNum) {
		this.fanNum = fanNum;
	}
	public BigDecimal getCapacity() {
		return capacity;
	}
	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}
	public BigDecimal getPowerGenerationNum() {
		return powerGenerationNum;
	}
	public void setPowerGenerationNum(BigDecimal powerGenerationNum) {
		this.powerGenerationNum = powerGenerationNum;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	
}
