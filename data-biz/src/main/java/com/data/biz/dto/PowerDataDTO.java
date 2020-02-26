package com.data.biz.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PowerDataDTO {
	private BigDecimal ratio;
	private int section;
	private Date createTime;
	public BigDecimal getRatio() {
		return ratio;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "PowerDataDTO [ratio=" + ratio + ", section=" + section + ", createTime=" + createTime + "]";
	}
}