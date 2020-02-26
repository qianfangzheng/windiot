package com.data.biz.vo;

import java.io.Serializable;
import java.math.BigDecimal;

// 运行时数据Vo对象
public class RunDataVo implements Serializable{
	private int fanCount;// 风机总台数
	private BigDecimal generatingHours;// 发电小时数
	private BigDecimal generatingTotal;// 累计发电量
	private int capacityTotal; // 总装机容量
	private BigDecimal generatingCapacityYear;// 年发电量
	private BigDecimal generatingCapacityMonth;// 月发电量
	private BigDecimal generatingCapacityDay;// 日发电量

	private BigDecimal avgWindSpeed;//平均风速
	private BigDecimal avgWindSpeedYear;// 年平均风速
	private BigDecimal avgWindSpeedMonth;// 月平均风速
	private BigDecimal avgWindSpeedDay;// 日平均风速


	private BigDecimal avgRotateSpeed;// 平均风轮转速
	private BigDecimal avgRotateSpeedYear;// 年平均风轮转速
	private BigDecimal avgRotateSpeedMonth;// 月平均风轮转速
	private BigDecimal avgRotateSpeedDay;// 日平均风轮转速
	
	private BigDecimal avgPowerDay;// 日平均功率
	private BigDecimal avgPowerMonth;// 月平均功率
	private BigDecimal avgPowerYear;// 年平均功率
	
	public int getFanCount() {
		return fanCount;
	}
	public void setFanCount(int fanCount) {
		this.fanCount = fanCount;
	}

	public BigDecimal getGeneratingHours() {
		return generatingHours;
	}
	public void setGeneratingHours(BigDecimal generatingHours) {
		this.generatingHours = generatingHours;
	}
	public BigDecimal getGeneratingTotal() {
		return generatingTotal;
	}
	public void setGeneratingTotal(BigDecimal generatingTotal) {
		this.generatingTotal = generatingTotal;
	}
	public int getCapacityTotal() {
		return capacityTotal;
	}
	public void setCapacityTotal(int capacityTotal) {
		this.capacityTotal = capacityTotal;
	}

	public BigDecimal getGeneratingCapacityYear() {
		return generatingCapacityYear;
	}
	public void setGeneratingCapacityYear(BigDecimal generatingCapacityYear) {
		this.generatingCapacityYear = generatingCapacityYear;
	}
	public BigDecimal getGeneratingCapacityMonth() {
		return generatingCapacityMonth;
	}
	public void setGeneratingCapacityMonth(BigDecimal generatingCapacityMonth) {
		this.generatingCapacityMonth = generatingCapacityMonth;
	}
	public BigDecimal getGeneratingCapacityDay() {
		return generatingCapacityDay;
	}
	public void setGeneratingCapacityDay(BigDecimal generatingCapacityDay) {
		this.generatingCapacityDay = generatingCapacityDay;
	}

	public BigDecimal getAvgWindSpeed() {
		return avgWindSpeed;
	}
	public void setAvgWindSpeed(BigDecimal avgWindSpeed) {
		this.avgWindSpeed = avgWindSpeed;
	}
	public BigDecimal getAvgWindSpeedYear() {
		return avgWindSpeedYear;
	}
	public void setAvgWindSpeedYear(BigDecimal avgWindSpeedYear) {
		this.avgWindSpeedYear = avgWindSpeedYear;
	}
	public BigDecimal getAvgWindSpeedMonth() {
		return avgWindSpeedMonth;
	}
	public void setAvgWindSpeedMonth(BigDecimal avgWindSpeedMonth) {
		this.avgWindSpeedMonth = avgWindSpeedMonth;
	}
	public BigDecimal getAvgWindSpeedDay() {
		return avgWindSpeedDay;
	}
	public void setAvgWindSpeedDay(BigDecimal avgWindSpeedDay) {
		this.avgWindSpeedDay = avgWindSpeedDay;
	}
	public BigDecimal getAvgRotateSpeed() {
		return avgRotateSpeed;
	}
	public void setAvgRotateSpeed(BigDecimal avgRotateSpeed) {
		this.avgRotateSpeed = avgRotateSpeed;
	}
	public BigDecimal getAvgRotateSpeedYear() {
		return avgRotateSpeedYear;
	}
	public void setAvgRotateSpeedYear(BigDecimal avgRotateSpeedYear) {
		this.avgRotateSpeedYear = avgRotateSpeedYear;
	}
	public BigDecimal getAvgRotateSpeedMonth() {
		return avgRotateSpeedMonth;
	}
	public void setAvgRotateSpeedMonth(BigDecimal avgRotateSpeedMonth) {
		this.avgRotateSpeedMonth = avgRotateSpeedMonth;
	}
	public BigDecimal getAvgRotateSpeedDay() {
		return avgRotateSpeedDay;
	}
	public void setAvgRotateSpeedDay(BigDecimal avgRotateSpeedDay) {
		this.avgRotateSpeedDay = avgRotateSpeedDay;
	}
	
	
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
		return "RunDataVo [fanCount=" + fanCount + ", generatingHours=" + generatingHours + ", generatingTotal="
				+ generatingTotal + ", capacityTotal=" + capacityTotal + ", generatingCapacityYear="
				+ generatingCapacityYear + ", generatingCapacityMonth=" + generatingCapacityMonth
				+ ", generatingCapacityDay=" + generatingCapacityDay + ", avgWindSpeed=" + avgWindSpeed
				+ ", avgWindSpeedYear=" + avgWindSpeedYear + ", avgWindSpeedMonth=" + avgWindSpeedMonth
				+ ", avgWindSpeedDay=" + avgWindSpeedDay + ", avgRotateSpeed=" + avgRotateSpeed + ", avgRotateSpeedYear="
				+ avgRotateSpeedYear + ", avgRotateSpeedMonth=" + avgRotateSpeedMonth + ", avgRotateSpeedDay="
				+ avgRotateSpeedDay + "]";
	}


}
