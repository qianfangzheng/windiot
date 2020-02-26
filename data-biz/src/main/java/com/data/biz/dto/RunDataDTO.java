package com.data.biz.dto;

import java.math.BigDecimal;

public class RunDataDTO {
	/** 指定电厂下的所有风机的发电量总和 */
	private BigDecimal GeneratingCapacity;

	/** 指定电厂下的风机平均风速 */
	private BigDecimal AvgWindSpeed;

	/** 指定电厂下的风机平均转速 */
	private BigDecimal AvgRotateSpeed;

	public BigDecimal getGeneratingCapacity() {
		return GeneratingCapacity;
	}

	public void setGeneratingCapacity(BigDecimal generatingCapacity) {
		GeneratingCapacity = generatingCapacity;
	}

	public BigDecimal getAvgWindSpeed() {
		return AvgWindSpeed;
	}

	public void setAvgWindSpeed(BigDecimal avgWindSpeed) {
		AvgWindSpeed = avgWindSpeed;
	}

	public BigDecimal getAvgRotateSpeed() {
		return AvgRotateSpeed;
	}

	public void setAvgRotateSpeed(BigDecimal avgRotateSpeed) {
		AvgRotateSpeed = avgRotateSpeed;
	}

	@Override
	public String toString() {
		return "RunDataDTO [GeneratingCapacity=" + GeneratingCapacity + ", AvgWindSpeed=" + AvgWindSpeed
				+ ", AvgRotateSpeed=" + AvgRotateSpeed + "]";
	}


}
