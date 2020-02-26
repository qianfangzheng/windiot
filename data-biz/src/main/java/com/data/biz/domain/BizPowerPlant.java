package com.data.biz.domain;

import com.data.common.core.domain.BaseEntity;

/**
 * 
 * @author xzp
 * @date 2019-12-09
 */
public class BizPowerPlant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 电厂编号 */
    private String plantCode;

    /** 风机总数 */
    private Long total;

    /** 总装机容量 */
    private String capacity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlantCode(String plantCode) 
    {
        this.plantCode = plantCode;
    }

    public String getPlantCode() 
    {
        return plantCode;
    }
    public void setTotal(Long total) 
    {
        this.total = total;
    }

    public Long getTotal() 
    {
        return total;
    }
    public void setCapacity(String capacity) 
    {
        this.capacity = capacity;
    }

    public String getCapacity() 
    {
        return capacity;
    }

    @Override
	public String toString() {
		return "BizPowerPlant [id=" + id + ", plantCode=" + plantCode + ", total=" + total + ", capacity=" + capacity
				+ "]";
	}
}
