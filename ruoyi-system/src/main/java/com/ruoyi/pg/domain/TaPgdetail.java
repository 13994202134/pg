package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评估明细对象 ta_pgdetail
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaPgdetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评估批次ID */
    private Long detailid;

    /** 评估批次Id */
    @Excel(name = "评估批次Id")
    private String pgbatchid;

    /** 表名 */
    @Excel(name = "表名")
    private String pgtable;

    /** 评估项 */
    @Excel(name = "评估项")
    private String pgname;

    /** 实际得分 */
    @Excel(name = "实际得分")
    private Long acscore;

    /** 是否选中 */
    @Excel(name = "是否选中")
    private String issel;

    public void setDetailid(Long detailid) 
    {
        this.detailid = detailid;
    }

    public Long getDetailid() 
    {
        return detailid;
    }
    public void setPgbatchid(String pgbatchid) 
    {
        this.pgbatchid = pgbatchid;
    }

    public String getPgbatchid() 
    {
        return pgbatchid;
    }
    public void setPgtable(String pgtable) 
    {
        this.pgtable = pgtable;
    }

    public String getPgtable() 
    {
        return pgtable;
    }
    public void setPgname(String pgname) 
    {
        this.pgname = pgname;
    }

    public String getPgname() 
    {
        return pgname;
    }
    public void setAcscore(Long acscore) 
    {
        this.acscore = acscore;
    }

    public Long getAcscore() 
    {
        return acscore;
    }
    public void setIssel(String issel) 
    {
        this.issel = issel;
    }

    public String getIssel() 
    {
        return issel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailid", getDetailid())
            .append("pgbatchid", getPgbatchid())
            .append("pgtable", getPgtable())
            .append("pgname", getPgname())
            .append("acscore", getAcscore())
            .append("issel", getIssel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
