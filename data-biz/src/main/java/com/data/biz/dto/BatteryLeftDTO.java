package com.data.biz.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


// 发电量和日期的BTO对象(电量统计)
public class BatteryLeftDTO implements Serializable{
    private BigDecimal power_generation;// 发电量
    private Date createTime;// 电量统计时间
	public BigDecimal getPower_generation() {
		return power_generation;
	}
	public void setPower_generation(BigDecimal power_generation) {
		this.power_generation = power_generation;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "batteryLeftBTO [power_generation=" + power_generation + ", createTime=" + createTime + "]";
	}
}
