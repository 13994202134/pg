package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 评估总对象 ta_pg
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaPg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评估ID */
    private Long pgid;

    /** 评估批次ID */
    @Excel(name = "评估批次ID")
    private String pgbatchid;

    /** 评估表名称 */
    @Excel(name = "评估表名称")
    private String pgtable;

    /** 医生姓Id */
    @Excel(name = "医生姓Id")
    private String did;

    /** 患者id */
    @Excel(name = "患者id")
    private String patid;

    /** 住院次数 */
    @Excel(name = "患者住院次数")
    private String inhossum;



    /** 患者住院号 */
    @Excel(name = "患者住院号")
    private String pathosid;


    /** 评估类别 */
    @Excel(name = "评估类别")
    private String pgclass;

    /** 总分 */
    @Excel(name = "总分")
    private Long count;

    /** 评估情况 */
    @Excel(name = "评估情况")
    private String pgresult;

    /** 评估等级 */
    @Excel(name = "评估等级")
    private String grade;

    private Date  createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private TaPatInfor taPatInfor;

    private TaDoctor taDoctor;

    public TaPatInfor getTaPatInfor() {
        return taPatInfor;
    }

    public void setTaPatInfor(TaPatInfor taPatInfor) {
        this.taPatInfor = taPatInfor;
    }

    public TaDoctor getTaDoctor() {
        return taDoctor;
    }

    public void setTaDoctor(TaDoctor taDoctor) {
        this.taDoctor = taDoctor;
    }



    public void setPgid(Long pgid) 
    {
        this.pgid = pgid;
    }

    public Long getPgid() 
    {
        return pgid;
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
    public void setDid(String did) 
    {
        this.did = did;
    }

    public String getDid() 
    {
        return did;
    }
    public void setPatid(String patid) 
    {
        this.patid = patid;
    }

    public String getPatid() 
    {
        return patid;
    }
    public void setPgclass(String pgclass) 
    {
        this.pgclass = pgclass;
    }

    public String getPgclass() 
    {
        return pgclass;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setPgresult(String pgresult) 
    {
        this.pgresult = pgresult;
    }

    public String getPgresult() 
    {
        return pgresult;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }

    public String getInhossum() {
        return inhossum;
    }

    public void setInhossum(String inhossum) {
        this.inhossum = inhossum;
    }

    public String getPathosid() {
        return pathosid;
    }

    public void setPathosid(String pathosid) {
        this.pathosid = pathosid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pgid", getPgid())
            .append("pgbatchid", getPgbatchid())
            .append("pgtable", getPgtable())
            .append("did", getDid())
            .append("patid", getPatid())
            .append("inhossum", getInhossum())
            .append("pathosid", getPatid())
            .append("pgclass", getPgclass())
            .append("count", getCount())
            .append("pgresult", getPgresult())
            .append("grade", getGrade())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("taDoctor", getTaDoctor())
            .append("taPatInfor", getTaPatInfor())
            .toString();
    }
}
