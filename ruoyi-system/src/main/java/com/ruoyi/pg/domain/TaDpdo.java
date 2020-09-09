package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门人员对照对象 ta_dpdo
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaDpdo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long dpid;

    /** 人员id */
    private Long did;

    public void setDpid(Long dpid) 
    {
        this.dpid = dpid;
    }

    public Long getDpid() 
    {
        return dpid;
    }
    public void setDid(Long did) 
    {
        this.did = did;
    }

    public Long getDid() 
    {
        return did;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dpid", getDpid())
            .append("did", getDid())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
