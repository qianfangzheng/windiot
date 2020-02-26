  package com.data.biz.domain;

import java.util.Date;

import com.data.common.core.domain.BaseEntity;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public class BizCabin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public BizCabin(Long id, Long fanId) {
		super();
		this.id = id;
		this.fanId = fanId;
	}


	/** 序号 */
    private Long id;

    /** 风机序号 */
    private Long fanId;

    /** 机舱温度(摄氏度) */
    private Double cabinT;

    /** 机舱角度 */
    private Double cabinAngle;

    /** 齿轮箱油温度 */
    private Double oilT;

    /** 齿轮箱低速轴温度 */
    private Double lowShaftT;

    /** 齿轮箱高速轴温度 */
    private Double highShaftT;

    /** 齿轮油压力 */
    private Double oilPressure;

    /** 交流电压 */
    private Double acVoltage;

    /** 发电机输出 */
    private Double fanOutput;

    /** 发电机输出频率 */
    private Double fanOutputFrequency;

    /** 发电机功率因数 */
    private Double fanFactor;

    /** 瞬时功率 */
    private Double instantaneousPower;

    /** 状态0无效1有效 */
    private Integer status;
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFanId(Long fanId) 
    {
        this.fanId = fanId;
    }

    public Long getFanId() 
    {
        return fanId;
    }
    public void setCabinT(Double cabinT) 
    {
        this.cabinT = cabinT;
    }

    public Double getCabinT() 
    {
        return cabinT;
    }
    public void setCabinAngle(Double cabinAngle) 
    {
        this.cabinAngle = cabinAngle;
    }

    public Double getCabinAngle() 
    {
        return cabinAngle;
    }
    public void setOilT(Double oilT) 
    {
        this.oilT = oilT;
    }

    public Double getOilT() 
    {
        return oilT;
    }
    public void setLowShaftT(Double lowShaftT) 
    {
        this.lowShaftT = lowShaftT;
    }

    public Double getLowShaftT() 
    {
        return lowShaftT;
    }
    public void setHighShaftT(Double highShaftT) 
    {
        this.highShaftT = highShaftT;
    }

    public Double getHighShaftT() 
    {
        return highShaftT;
    }
    public void setOilPressure(Double oilPressure) 
    {
        this.oilPressure = oilPressure;
    }

    public Double getOilPressure() 
    {
        return oilPressure;
    }
    public void setAcVoltage(Double acVoltage) 
    {
        this.acVoltage = acVoltage;
    }

    public Double getAcVoltage() 
    {
        return acVoltage;
    }
    public void setFanOutput(Double fanOutput) 
    {
        this.fanOutput = fanOutput;
    }

    public Double getFanOutput() 
    {
        return fanOutput;
    }
    public void setFanOutputFrequency(Double fanOutputFrequency) 
    {
        this.fanOutputFrequency = fanOutputFrequency;
    }

    public Double getFanOutputFrequency() 
    {
        return fanOutputFrequency;
    }
    public void setFanFactor(Double fanFactor) 
    {
        this.fanFactor = fanFactor;
    }

    public Double getFanFactor() 
    {
        return fanFactor;
    }
    public void setInstantaneousPower(Double instantaneousPower) 
    {
        this.instantaneousPower = instantaneousPower;
    }

    public Double getInstantaneousPower() 
    {
        return instantaneousPower;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }


	@Override
	public String toString() {
		return "BizCabin [id=" + id + ", fanId=" + fanId + ", cabinT=" + cabinT + ", cabinAngle=" + cabinAngle
				+ ", oilT=" + oilT + ", lowShaftT=" + lowShaftT + ", highShaftT=" + highShaftT + ", oilPressure="
				+ oilPressure + ", acVoltage=" + acVoltage + ", fanOutput=" + fanOutput + ", fanOutputFrequency="
				+ fanOutputFrequency + ", fanFactor=" + fanFactor + ", instantaneousPower=" + instantaneousPower
				+ ", status=" + status + "]";
	}

}
