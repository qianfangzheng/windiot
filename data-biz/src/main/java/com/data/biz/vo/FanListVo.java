package com.data.biz.vo;

import java.math.BigDecimal;
import java.util.Date;

//风机列表Vo对象
public class FanListVo {
	/** 序号 */
	private Long id;

	/** 风机编号 */
	private String fanCode;

	/** 功率 */
	private BigDecimal power;

	/** 实际功率 */
	private BigDecimal realPower;

	/** 瞬时发电功率 */
	private double instantaneous_power;
	
	/** 风轮转速 */
	private double rotate_speed;
	
	/** 风向角 */
	private long direction;
	
	/** 创建时间 */
	private Date create_time;

	/** 状态0关闭1开启2异常 */
	private Integer status;

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

	public double getInstantaneous_power() {
		return instantaneous_power;
	}

	public void setInstantaneous_power(double instantaneous_power) {
		this.instantaneous_power = instantaneous_power;
	}

	public double getRotate_speed() {
		return rotate_speed;
	}

	public void setRotate_speed(double rotate_speed) {
		this.rotate_speed = rotate_speed;
	}

	public long getDirection() {
		return direction;
	}

	public void setDirection(long direction) {
		this.direction = direction;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FanListVo [id=" + id + ", fanCode=" + fanCode + ", power=" + power + ", realPower=" + realPower
				+ ", instantaneous_power=" + instantaneous_power + ", rotate_speed=" + rotate_speed + ", direction="
				+ direction + ", create_time=" + create_time + ", status=" + status + "]";
	}


}
