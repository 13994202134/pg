package com.ruoyi.pg.domain.InPara.scheme2.PgTotal;

import com.ruoyi.pg.domain.InPara.scheme1.Subtotal;

import java.util.List;

public class PgInParaS {
    private String pgbatchid;
    private String pgclass;

    private String did;

    private String patid;

    private String inhossum;

    private String pathosid;

    private List<SubtotalS> subtotalS;

    private TotalS total;

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


    @Override
    public String toString() {
        return "PgInParaS{" +
                "pgbatchid='" + pgbatchid + '\'' +
                ", pgclass='" + pgclass + '\'' +
                ", did='" + did + '\'' +
                ", patid='" + patid + '\'' +
                ", inhossum='" + inhossum + '\'' +
                ", pathosid='" + pathosid + '\'' +
                ", subtotalS=" + subtotalS +
                ", total=" + total +
                '}';
    }
}
