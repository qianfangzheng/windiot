package com.data.biz.dto;

import java.math.BigDecimal;

public class AvgPowerDTO {
	private BigDecimal avgPowerDay;// 日平均功率
	private BigDecimal avgPowerMonth;// 月平均功率
	private BigDecimal avgPowerYear;// 年平均功率
	public BigDecimal getAvgPowerDay() {
		return avgPowerDay;
	}
	public void setAvgPowerDay(BigDecimal avgPowerDay) {
		this.avgPowerDay = avgPowerDay;
	}
	public BigDecimal getAvgPowerMonth() {
		return avgPowerMonth;
	}
	public void setAvgPowerMonth(BigDecimal avgPowerMonth) {
		this.avgPowerMonth = avgPowerMonth;
	}
	public BigDecimal getAvgPowerYear() {
		return avgPowerYear;
	}
	public void setAvgPowerYear(BigDecimal avgPowerYear) {
		this.avgPowerYear = avgPowerYear;
	}
	@Override
	public String toString() {
		return "AvgPowerDTO [avgPowerDay=" + avgPowerDay + ", avgPowerMonth=" + avgPowerMonth + ", avgPowerYear="
				+ avgPowerYear + "]";
	}
}