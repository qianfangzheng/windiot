package com.data.biz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.data.common.annotation.Excel;
import com.data.common.core.domain.BaseEntity;

/**
 * 风速统计对象 biz_wind_data
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-19
 */
public class BizWindData
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 东风频率 */
    @Excel(name = "东风频率")
    private Double eastTime;

    /** 西风频率 */
    @Excel(name = "西风频率")
    private Double westTime;

    /** 南风频率 */
    @Excel(name = "南风频率")
    private Double southTime;

    /** 北风频率 */
    @Excel(name = "北风频率")
    private Double northTime;

    /** 东北风频率 */
    @Excel(name = "东北风频率")
    private Double neTime;

    /** 北北东风频率 */
    @Excel(name = "北北东风频率")
    private Double nneTime;

    /** 北东北风频率 */
    @Excel(name = "北东北风频率")
    private Double eneTime;

    /** 西北风频率 */
    @Excel(name = "西北风频率")
    private Double nwTime;

    /** 北北西风频率 */
    @Excel(name = "北北西风频率")
    private Double nnwTime;

    /** 北西北风频率 */
    @Excel(name = "北西北风频率")
    private Double wnwTime;

    /** 东南风频率 */
    @Excel(name = "东南风频率")
    private Double seTime;

    /** 南南东风频率 */
    @Excel(name = "南南东风频率")
    private Double sseTime;

    /** 南东南风频率 */
    @Excel(name = "南东南风频率")
    private Double eseTime;

    /** 西南风频率 */
    @Excel(name = "西南风频率")
    private Double swTime;

    /** 南南西风频率 */
    @Excel(name = "南南西风频率")
    private Double sswTime;

    /** 南西南风频率 */
    @Excel(name = "南西南风频率")
    private Double wswTime;

    /** 区间 */
    @Excel(name = "区间")
    private Integer interval;

    /** 类型 1日 2 月 3年 */
    @Excel(name = "类型 1日 2 月 3年")
    private Integer type;

    /** 状态 0无效 1有效 */
    @Excel(name = "状态 0无效 1有效")
    private Integer status;
    
    private String createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEastTime(Double eastTime) 
    {
        this.eastTime = eastTime;
    }

    public Double getEastTime() 
    {
        return eastTime;
    }
    public void setWestTime(Double westTime) 
    {
        this.westTime = westTime;
    }

    public Double getWestTime() 
    {
        return westTime;
    }
    public void setSouthTime(Double southTime) 
    {
        this.southTime = southTime;
    }

    public Double getSouthTime() 
    {
        return southTime;
    }
    public void setNorthTime(Double northTime) 
    {
        this.northTime = northTime;
    }

    public Double getNorthTime() 
    {
        return northTime;
    }
    public void setNeTime(Double neTime) 
    {
        this.neTime = neTime;
    }

    public Double getNeTime() 
    {
        return neTime;
    }
    public void setNneTime(Double nneTime) 
    {
        this.nneTime = nneTime;
    }

    public Double getNneTime() 
    {
        return nneTime;
    }
    public void setEneTime(Double eneTime) 
    {
        this.eneTime = eneTime;
    }

    public Double getEneTime() 
    {
        return eneTime;
    }
    public void setNwTime(Double nwTime) 
    {
        this.nwTime = nwTime;
    }

    public Double getNwTime() 
    {
        return nwTime;
    }
    public void setNnwTime(Double nnwTime) 
    {
        this.nnwTime = nnwTime;
    }

    public Double getNnwTime() 
    {
        return nnwTime;
    }
    public void setWnwTime(Double wnwTime) 
    {
        this.wnwTime = wnwTime;
    }

    public Double getWnwTime() 
    {
        return wnwTime;
    }
    public void setSeTime(Double seTime) 
    {
        this.seTime = seTime;
    }

    public Double getSeTime() 
    {
        return seTime;
    }
    public void setSseTime(Double sseTime) 
    {
        this.sseTime = sseTime;
    }

    public Double getSseTime() 
    {
        return sseTime;
    }
    public void setEseTime(Double eseTime) 
    {
        this.eseTime = eseTime;
    }

    public Double getEseTime() 
    {
        return eseTime;
    }
    public void setSwTime(Double swTime) 
    {
        this.swTime = swTime;
    }

    public Double getSwTime() 
    {
        return swTime;
    }
    public void setSswTime(Double sswTime) 
    {
        this.sswTime = sswTime;
    }

    public Double getSswTime() 
    {
        return sswTime;
    }
    public void setWswTime(Double wswTime) 
    {
        this.wswTime = wswTime;
    }

    public Double getWswTime() 
    {
        return wswTime;
    }
    public void setInterval(Integer interval) 
    {
        this.interval = interval;
    }

    public Integer getInterval() 
    {
        return interval;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    

    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("eastTime", getEastTime())
            .append("westTime", getWestTime())
            .append("southTime", getSouthTime())
            .append("northTime", getNorthTime())
            .append("neTime", getNeTime())
            .append("nneTime", getNneTime())
            .append("eneTime", getEneTime())
            .append("nwTime", getNwTime())
            .append("nnwTime", getNnwTime())
            .append("wnwTime", getWnwTime())
            .append("seTime", getSeTime())
            .append("sseTime", getSseTime())
            .append("eseTime", getEseTime())
            .append("swTime", getSwTime())
            .append("sswTime", getSswTime())
            .append("wswTime", getWswTime())
            .append("interval", getInterval())
            .append("type", getType())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
