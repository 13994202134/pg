package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门对象 ta_dpment
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaDpment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long dpid;

    /** 部门编号 */
    @Excel(name = "部门编号")
    private String dnumber;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String dname;

    public void setDpid(Long dpid) 
    {
        this.dpid = dpid;
    }

    public Long getDpid() 
    {
        return dpid;
    }
    public void setDnumber(String dnumber) 
    {
        this.dnumber = dnumber;
    }

    public String getDnumber() 
    {
        return dnumber;
    }
    public void setDname(String dname) 
    {
        this.dname = dname;
    }

    public String getDname() 
    {
        return dname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dpid", getDpid())
            .append("dnumber", getDnumber())
            .append("dname", getDname())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
