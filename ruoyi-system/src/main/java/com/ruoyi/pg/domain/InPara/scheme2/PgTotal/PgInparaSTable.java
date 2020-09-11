package com.ruoyi.pg.domain.InPara.scheme2.PgTotal;

import com.ruoyi.pg.domain.InPara.scheme2.Details.*;

import java.util.List;

public class PgInparaSTable {
    private String pgbatchid;
    private String pgclass;

    private String did;

    private String patid;

    private String inhossum;

    private String pathosid;

    private List<SubtotalS> subtotalS;

    private TotalS total;

    private List<DetailTable> detailTableList;

    public String getPgbatchid() {
        return pgbatchid;
    }

    public void setPgbatchid(String pgbatchid) {
        this.pgbatchid = pgbatchid;
    }

    public String getPgclass() {
        return pgclass;
    }

    public void setPgclass(String pgclass) {
        this.pgclass = pgclass;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
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

    public List<SubtotalS> getSubtotalS() {
        return subtotalS;
    }

    public void setSubtotalS(List<SubtotalS> subtotalS) {
        this.subtotalS = subtotalS;
    }

    public TotalS getTotal() {
        return total;
    }

    public void setTotal(TotalS total) {
        this.total = total;
    }

    public List<DetailTable> getDetailTableList() {
        return detailTableList;
    }

    public void setDetailTableList(List<DetailTable> detailTableList) {
        this.detailTableList = detailTableList;
    }


    @Override
    public String toString() {
        return "PgInparaSTable{" +
                "pgbatchid='" + pgbatchid + '\'' +
                ", pgclass='" + pgclass + '\'' +
                ", did='" + did + '\'' +
                ", patid='" + patid + '\'' +
                ", inhossum='" + inhossum + '\'' +
                ", pathosid='" + pathosid + '\'' +
                ", subtotalS=" + subtotalS +
                ", total=" + total +
                ", detailTableList=" + detailTableList +
                '}';
    }
}
