package com.ruoyi.pg.domain.view;

import com.ruoyi.common.annotation.Excel;

public class TaPgtableForView {
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


    public String getPgclass() {
        return pgclass;
    }

    public void setPgclass(String pgclass) {
        this.pgclass = pgclass;
    }



    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(String projectlist) {
        this.projectlist = projectlist;
    }


    @Override
    public String toString() {
        return "TaPgtableForView{" +
                "pgclass='" + pgclass + '\'' +
                ", tablename='" + tablename + '\'' +
                ", projectlist='" + projectlist + '\'' +
                ", value=" + value +
                '}';
    }
}
