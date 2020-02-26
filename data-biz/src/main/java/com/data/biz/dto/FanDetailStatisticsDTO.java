package com.data.biz.dto;

import java.math.BigDecimal;

public class FanDetailStatisticsDTO {
	private BigDecimal sumelectric;// 总发电量
	private Integer faultCount;// 风机故障次数
	private Integer yawCount;// 风机偏航次数
	public BigDecimal getSumelectric() {
		return sumelectric;
	}
	public void setSumelectric(BigDecimal sumelectric) {
		this.sumelectric = sumelectric;
	}
	public Integer getFaultCount() {
		return faultCount;
	}
	public void setFaultCount(Integer faultCount) {
		this.faultCount = faultCount;
	}
	public Integer getYawCount() {
		return yawCount;
	}
	public void setYawCount(Integer yawCount) {
		this.yawCount = yawCount;
	}
	@Override
	public String toString() {
		return "FanDetailStatisticsDTO [sumelectric=" + sumelectric + ", faultCount=" + faultCount + ", yawCount="
				+ yawCount + "]";
	}
}