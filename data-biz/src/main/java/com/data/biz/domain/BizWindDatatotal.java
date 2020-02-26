package com.data.biz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.data.common.annotation.Excel;
import com.data.common.core.domain.BaseEntity;

/**
 * 风速统计对象 biz_wind_datatotal
 * 
 * 技术支持微信：17725354261
 * @date 2019-12-09
 */
public class BizWindDatatotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 东风次数 */
    @Excel(name = "东风次数")
    private Long eastNum;

    /** 东风均速 */
    @Excel(name = "东风均速")
    private Double eastSpeed;

    /** 西风次数 */
    @Excel(name = "西风次数")
    private Long westNum;

    /** 西风均速 */
    @Excel(name = "西风均速")
    private Double westSpeed;

    /** 南风次数 */
    @Excel(name = "南风次数")
    private Long southNum;

    /** 南风均速 */
    @Excel(name = "南风均速")
    private Double southSpeed;

    /** 北风次数 */
    @Excel(name = "北风次数")
    private Long northNum;

    /** 北风均速 */
    @Excel(name = "北风均速")
    private Double northSpeed;

    /** 东北风次数 */
    @Excel(name = "东北风次数")
    private Long northeastNum;

    /** 东北风均速 */
    @Excel(name = "东北风均速")
    private Double northeastSpeed;

    /** 西北风次数 */
    @Excel(name = "西北风次数")
    private Long northwestNum;

    /** 西北风均速 */
    @Excel(name = "西北风均速")
    private Double northwestSpeed;

    /** 东南风次数 */
    @Excel(name = "东南风次数")
    private Long southeastNum;

    /** 东南风均速 */
    @Excel(name = "东南风均速")
    private Double southeastSpeed;

    /** 西南风次数 */
    @Excel(name = "西南风次数")
    private Long southwestNum;

    /** 西南风均速 */
    @Excel(name = "西南风均速")
    private Double southwestSpeed;

    /** 北东北 */
    @Excel(name = "北东北")
    private Double nneSpeed;

    /** $column.columnComment */
    @Excel(name = "北东北")
    private Long nneNum;

    /** 东东北 */
    @Excel(name = "东东北")
    private Double eneSpeed;

    /** $column.columnComment */
    @Excel(name = "东东北")
    private Long eneNum;

    /** 南东南 */
    @Excel(name = "南东南")
    private Double sseSpeed;

    /** $column.columnComment */
    @Excel(name = "南东南")
    private Long sseNum;

    /** 东东南 */
    @Excel(name = "东东南")
    private Double eseSpeed;

    /** $column.columnComment */
    @Excel(name = "东东南")
    private Long eseNum;

    /** 南西南 */
    @Excel(name = "南西南")
    private Double sswSpeed;

    /** $column.columnComment */
    @Excel(name = "南西南")
    private Long sswNum;

    /** 西西南 */
    @Excel(name = "西西南")
    private Double wswSpeed;

    /** $column.columnComment */
    @Excel(name = "西西南")
    private Long wswNum;

    /** 北西北 */
    @Excel(name = "北西北")
    private Double nnwSpeed;

    /** $column.columnComment */
    @Excel(name = "北西北")
    private Long nnwNum;

    /** 西西北 */
    @Excel(name = "西西北")
    private Double wnwSpeed;

    /** $column.columnComment */
    @Excel(name = "西西北")
    private Long wnwNum;
    /** 类型 1日 2 月 3年 */
    @Excel(name = "类型 1日 2 月 3年")
    private Integer type;

    /** 状态 0无效 1有效 */
    @Excel(name = "状态 0无效 1有效")
    private Integer status;
    /** 状态 0无效 1有效 */
    @Excel(name = "统计时间")
    private Integer createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEastNum(Long eastNum) 
    {
        this.eastNum = eastNum;
    }

    public Long getEastNum() 
    {
        return eastNum;
    }
    public void setEastSpeed(Double eastSpeed) 
    {
        this.eastSpeed = eastSpeed;
    }

    public Double getEastSpeed() 
    {
        return eastSpeed;
    }
    public void setWestNum(Long westNum) 
    {
        this.westNum = westNum;
    }

    public Long getWestNum() 
    {
        return westNum;
    }
    public void setWestSpeed(Double westSpeed) 
    {
        this.westSpeed = westSpeed;
    }

    public Double getWestSpeed() 
    {
        return westSpeed;
    }
    public void setSouthNum(Long southNum) 
    {
        this.southNum = southNum;
    }

    public Long getSouthNum() 
    {
        return southNum;
    }
    public void setSouthSpeed(Double southSpeed) 
    {
        this.southSpeed = southSpeed;
    }

    public Double getSouthSpeed() 
    {
        return southSpeed;
    }
    public void setNorthNum(Long northNum) 
    {
        this.northNum = northNum;
    }

    public Long getNorthNum() 
    {
        return northNum;
    }
    public void setNorthSpeed(Double northSpeed) 
    {
        this.northSpeed = northSpeed;
    }

    public Double getNorthSpeed() 
    {
        return northSpeed;
    }
    public void setNortheastNum(Long northeastNum) 
    {
        this.northeastNum = northeastNum;
    }

    public Long getNortheastNum() 
    {
        return northeastNum;
    }
    public void setNortheastSpeed(Double northeastSpeed) 
    {
        this.northeastSpeed = northeastSpeed;
    }

    public Double getNortheastSpeed() 
    {
        return northeastSpeed;
    }
    public void setNorthwestNum(Long northwestNum) 
    {
        this.northwestNum = northwestNum;
    }

    public Long getNorthwestNum() 
    {
        return northwestNum;
    }
    public void setNorthwestSpeed(Double northwestSpeed) 
    {
        this.northwestSpeed = northwestSpeed;
    }

    public Double getNorthwestSpeed() 
    {
        return northwestSpeed;
    }
    public void setSoutheastNum(Long southeastNum) 
    {
        this.southeastNum = southeastNum;
    }

    public Long getSoutheastNum() 
    {
        return southeastNum;
    }
    public void setSoutheastSpeed(Double southeastSpeed) 
    {
        this.southeastSpeed = southeastSpeed;
    }

    public Double getSoutheastSpeed() 
    {
        return southeastSpeed;
    }
    public void setSouthwestNum(Long southwestNum) 
    {
        this.southwestNum = southwestNum;
    }

    public Long getSouthwestNum() 
    {
        return southwestNum;
    }
    public void setSouthwestSpeed(Double southwestSpeed) 
    {
        this.southwestSpeed = southwestSpeed;
    }

    public Double getSouthwestSpeed() 
    {
        return southwestSpeed;
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

	public Double getNneSpeed() {
		return nneSpeed;
	}

	public Long getNneNum() {
		return nneNum;
	}

	public Double getEneSpeed() {
		return eneSpeed;
	}

	public Long getEneNum() {
		return eneNum;
	}

	public Double getSseSpeed() {
		return sseSpeed;
	}

	public Long getSseNum() {
		return sseNum;
	}

	public Double getEseSpeed() {
		return eseSpeed;
	}

	public Long getEseNum() {
		return eseNum;
	}

	public Double getSswSpeed() {
		return sswSpeed;
	}

	public Long getSswNum() {
		return sswNum;
	}

	public Double getWswSpeed() {
		return wswSpeed;
	}

	public Long getWswNum() {
		return wswNum;
	}

	public Double getNnwSpeed() {
		return nnwSpeed;
	}

	public Long getNnwNum() {
		return nnwNum;
	}

	public Double getWnwSpeed() {
		return wnwSpeed;
	}

	public Long getWnwNum() {
		return wnwNum;
	}


	public void setNneSpeed(Double nneSpeed) {
		this.nneSpeed = nneSpeed;
	}

	public void setNneNum(Long nneNum) {
		this.nneNum = nneNum;
	}

	public void setEneSpeed(Double eneSpeed) {
		this.eneSpeed = eneSpeed;
	}

	public void setEneNum(Long eneNum) {
		this.eneNum = eneNum;
	}

	public void setSseSpeed(Double sseSpeed) {
		this.sseSpeed = sseSpeed;
	}

	public void setSseNum(Long sseNum) {
		this.sseNum = sseNum;
	}

	public void setEseSpeed(Double eseSpeed) {
		this.eseSpeed = eseSpeed;
	}

	public void setEseNum(Long eseNum) {
		this.eseNum = eseNum;
	}

	public void setSswSpeed(Double sswSpeed) {
		this.sswSpeed = sswSpeed;
	}

	public void setSswNum(Long sswNum) {
		this.sswNum = sswNum;
	}

	public void setWswSpeed(Double wswSpeed) {
		this.wswSpeed = wswSpeed;
	}

	public void setWswNum(Long wswNum) {
		this.wswNum = wswNum;
	}

	public void setNnwSpeed(Double nnwSpeed) {
		this.nnwSpeed = nnwSpeed;
	}

	public void setNnwNum(Long nnwNum) {
		this.nnwNum = nnwNum;
	}

	public void setWnwSpeed(Double wnwSpeed) {
		this.wnwSpeed = wnwSpeed;
	}

	public void setWnwNum(Long wnwNum) {
		this.wnwNum = wnwNum;
	}



    
}
