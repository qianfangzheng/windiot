package com.data.biz.vo;

// websocket往前端响应的风机实体类
public class FanSocketVo {
	private Integer fanCode;// 风机编号
	private Double instantaneousPower;// 瞬时功率
	private Double rotateSpeed;// 风轮转速
	
	public FanSocketVo() {
		
	}
	
	public FanSocketVo(Integer fanCode, Double instantaneousPower, Double rotateSpeed) {
		this.fanCode = fanCode;
		this.instantaneousPower = instantaneousPower;
		this.rotateSpeed = rotateSpeed;
	}
	public Integer getFanCode() {
		return fanCode;
	}
	public void setFanCode(Integer fanCode) {
		this.fanCode = fanCode;
	}
	public Double getInstantaneousPower() {
		return instantaneousPower;
	}
	public void setInstantaneousPower(Double instantaneousPower) {
		this.instantaneousPower = instantaneousPower;
	}
	public Double getRotateSpeed() {
		return rotateSpeed;
	}
	public void setRotateSpeed(Double rotateSpeed) {
		this.rotateSpeed = rotateSpeed;
	}
	@Override
	public String toString() {
		return "FanSocketVo [fanId=" + fanCode + ", instantaneousPower=" + instantaneousPower + ", rotateSpeed="
				+ rotateSpeed + "]";
	}
	
}
