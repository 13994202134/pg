package com.ruoyi.pg.domain.InPara.scheme2.Details;

public class DetailTable {
    private String pgclass;

    private String tablename;

    private String projectlist;
    //该选项的分值
    private String value;
    //保存后的选项的分值，和value含义相同，和数据库名称匹配，原来的含义是实际得分，后来实际得分不需要，但是需要需要提取应得的分值
    private String asScore;
    //是否选中
    private String isSel;

    public String getPgclass() {
        return pgclass;
    }

    public void setPgclass(String pgclass) {
        this.pgclass = pgclass;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAsScore() {
        return asScore;
    }

    public void setAsScore(String asScore) {
        this.asScore = asScore;
    }

    public String getIsSel() {
        return isSel;
    }

    public void setIsSel(String isSel) {
        this.isSel = isSel;
    }


    @Override
    public String toString() {
        return "BaseTable{" +
                "pgclass='" + pgclass + '\'' +
                ", tablename='" + tablename + '\'' +
                ", projectlist='" + projectlist + '\'' +
                ", value='" + value + '\'' +
                ", asScore=" + asScore +
                ", isSel='" + isSel + '\'' +
                '}';
    }
}
