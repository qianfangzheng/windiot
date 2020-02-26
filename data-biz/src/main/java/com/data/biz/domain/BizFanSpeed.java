package com.data.biz.domain;

import java.util.Date;

import com.data.common.core.domain.BaseEntity;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public class BizFanSpeed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 风机序号 */
    private Long fanId;

    /** 风向 */
    private Double direction;

    /** 风速 */
    private Double windSpeed;

    /** 转速 */
    private Double rotateSpeed;

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
    
    public Double getDirection() {
		return direction;
	}

	public void setDirection(Double direction) {
		this.direction = direction;
	}

	public void setWindSpeed(Double windSpeed) 
    {
        this.windSpeed = windSpeed;
    }

    public Double getWindSpeed() 
    {
        return windSpeed;
    }
    public void setRotateSpeed(Double rotateSpeed) 
    {
        this.rotateSpeed = rotateSpeed;
    }

    public Double getRotateSpeed() 
    {
        return rotateSpeed;
    }

}
