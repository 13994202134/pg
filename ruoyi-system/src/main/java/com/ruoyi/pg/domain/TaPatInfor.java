package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 病人基本信息对象 ta_patinfor
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaPatInfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 病人id */
    private Long patid;

    /** 住院次数 */
    private Long inhossum;

    /** 住院号 */
    @Excel(name = "住院号")
    private String pathosid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String patname;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 床位 */
    @Excel(name = "床位")
    private String bed;

    /** 入院科室ID */
    @Excel(name = "入院科室ID")
    private String patno;

    /** 入院科室*/
    @Excel(name = "入院科室")
    private TaDpment depart;

    public TaDpment getDepart() {
        if(depart == null)
        {
            depart = new TaDpment();
        }
        return depart;
    }

    public void setDepart(TaDpment depart) {
        this.depart = depart;
    }



    public void setPatid(Long patid) 
    {
        this.patid = patid;
    }

    public Long getPatid() 
    {
        return patid;
    }
    public void setInhossum(Long inhossum) 
    {
        this.inhossum = inhossum;
    }

    public Long getInhossum() 
    {
        return inhossum;
    }
    public void setPathosid(String pathosid) 
    {
        this.pathosid = pathosid;
    }

    public String getPathosid() 
    {
        return pathosid;
    }
    public void setPatname(String patname) 
    {
        this.patname = patname;
    }

    public String getPatname() 
    {
        return patname;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setBed(String bed) 
    {
        this.bed = bed;
    }

    public String getBed() 
    {
        return bed;
    }
    public void setPatno(String patno) 
    {
        this.patno = patno;
    }

    public String getPatno() 
    {
        return patno;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("patid", getPatid())
            .append("inhossum", getInhossum())
            .append("pathosid", getPathosid())
            .append("patname", getPatname())
            .append("sex", getSex())
            .append("age", getAge())
            .append("bed", getBed())
            .append("patno", getPatno())
            .append("depart",getDepart())
            .toString();
    }
}
