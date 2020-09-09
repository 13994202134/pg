package com.ruoyi.pg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评估项对象 ta_pgtable
 * 
 * @author ruoyi
 * @date 2020-08-30
 */
public class TaPgtable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 评估分类 */
    @Excel(name = "评估分类")
    private String pgclass;

    /** 表名 */
    @Excel(name = "表名")
    private String tablename;

    /** 检测项目 */
    @Excel(name = "检测项目")
    private String projectlist;

    /** 分值 */
    @Excel(name = "分值")
    private Long value;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setPgclass(String pgclass) 
    {
        this.pgclass = pgclass;
    }

    public String getPgclass() 
    {
        return pgclass;
    }
    public void setTablename(String tablename) 
    {
        this.tablename = tablename;
    }

    public String getTablename() 
    {
        return tablename;
    }
    public void setProjectlist(String projectlist) 
    {
        this.projectlist = projectlist;
    }

    public String getProjectlist() 
    {
        return projectlist;
    }
    public void setValue(Long value) 
    {
        this.value = value;
    }

    public Long getValue() 
    {
        return value;
    }


    @Override
    public String toString() {
        return "TaPgtable{" +
                "id=" + id +
                ", pgclass='" + pgclass + '\'' +
                ", tablename='" + tablename + '\'' +
                ", projectlist='" + projectlist + '\'' +
                ", value=" + value +
                '}';
    }
}
