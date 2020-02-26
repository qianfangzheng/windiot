package com.data.biz.vo;

import java.util.Date;

//风机警报统计Vo对象
public class WindAlertSelectVo {
	/** 序号 */
	private long id;
	/** 统计时间 */
	private Date create_time;
	/** 风机编号 */
	private long fanId;
	/** 叶片故障(次数) */
	private int vaneCount;
	/** 转向故障(次数) */
	private int turnCount;
	/** 发电机故障(次数) */
	private int dynamoCount;
	/** 其他故障(次数) */
	private int elseCount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public long getFanId() {
		return fanId;
	}
	public void setFanId(long fanId) {
		this.fanId = fanId;
	}
	public int getVaneCount() {
		return vaneCount;
	}
	public void setVaneCount(int vaneCount) {
		this.vaneCount = vaneCount;
	}
	public int getTurnCount() {
		return turnCount;
	}
	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
	public int getDynamoCount() {
		return dynamoCount;
	}
	public void setDynamoCount(int dynamoCount) {
		this.dynamoCount = dynamoCount;
	}
	public int getElseCount() {
		return elseCount;
	}
	public void setElseCount(int elseCount) {
		this.elseCount = elseCount;
	}
	@Override
	public String toString() {
		return "WindAlertSelectVo [id=" + id + ", create_time=" + create_time + ", fanId=" + fanId + ", vaneCount="
				+ vaneCount + ", turnCount=" + turnCount + ", dynamoCount=" + dynamoCount + ", elseCount=" + elseCount
				+ "]";
	}
}
