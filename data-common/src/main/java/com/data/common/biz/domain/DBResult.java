package com.data.common.biz.domain;

import java.math.BigDecimal;

public class DBResult {
	private String beginTime;
	private String endTime;
	private double duration;
	private double rate;
	private Integer num;
	private Integer tagsNum;
	
	public String getBeginTime() {
		return beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public double getDuration() {
		return duration;
	}
	public double getRate() {
		return rate;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public void setRate(double d) {
		this.rate = d;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getTagsNum() {
		return tagsNum;
	}
	public void setTagsNum(Integer tagsNum) {
		this.tagsNum = tagsNum;
	}
	
	
	
}
