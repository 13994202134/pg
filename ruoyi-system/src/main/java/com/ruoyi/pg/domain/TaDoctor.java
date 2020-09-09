package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员对象 ta_doctor
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaDoctor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医生id */
    private int did;

    /** 编号 */
    @Excel(name = "编号")
    private Long dnumber;

    /** 姓名 */
    @Excel(name = "姓名")
    private String doctorname;

    /** 简码 */
    @Excel(name = "简码")
    private String py;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    public void setDid(int did)
    {
        this.did = did;
    }

    public int getDid()
    {
        return did;
    }
    public void setDnumber(Long dnumber) 
    {
        this.dnumber = dnumber;
    }

    public Long getDnumber() 
    {
        return dnumber;
    }
    public void setDoctorname(String doctorname) 
    {
        this.doctorname = doctorname;
    }

    public String getDoctorname() 
    {
        return doctorname;
    }
    public void setPy(String py) 
    {
        this.py = py;
    }

    public String getPy() 
    {
        return py;
    }
    public void setIdnumber(String idnumber) 
    {
        this.idnumber = idnumber;
    }

    public String getIdnumber() 
    {
        return idnumber;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("did", getDid())
            .append("dnumber", getDnumber())
            .append("doctorname", getDoctorname())
            .append("py", getPy())
            .append("idnumber", getIdnumber())
            .append("sex", getSex())
            .append("nation", getNation())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
