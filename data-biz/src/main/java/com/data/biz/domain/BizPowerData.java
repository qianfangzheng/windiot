package com.data.biz.domain;

import java.math.BigDecimal;

import com.data.common.core.domain.BaseEntity;

public class BizPowerData extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal ratio;
	private int section;
	private Long plantId;
	private int dateType;
	public BigDecimal getRatio() {
		return ratio;
	}
	public int getSection() {
		return section;
	}
	public Long getPlantId() {
		return plantId;
	}
	public int getDateType() {
		return dateType;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}
	public void setDateType(int dateType) {
		this.dateType = dateType;
	}
	
	
}
