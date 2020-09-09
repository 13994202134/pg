package com.ruoyi.pg.domain.view;

import com.ruoyi.common.annotation.Excel;

public class TaPgDetailView {
    private static final long serialVersionUID = 1L;
    /** 评估批次Id */
    private String pgbatchid;

    /** 表名 */
    private String pgtable;

    /** 检测项目 */
    private String projectlist;

    /** 分值 */
    private Long value;

    /** 是否选中 */
    private String issel;


    public String getPgbatchid() {
        return pgbatchid;
    }

    public void setPgbatchid(String pgbatchid) {
        this.pgbatchid = pgbatchid;
    }

    public String getPgtable() {
        return pgtable;
    }

    public void setPgtable(String pgtable) {
        this.pgtable = pgtable;
    }

    public String getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(String projectlist) {
        this.projectlist = projectlist;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getIssel() {
        return issel;
    }

    public void setIssel(String issel) {
        this.issel = issel;
    }



}
