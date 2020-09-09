package com.ruoyi.pg.domain.InPara.scheme2.PgTotal;

import com.ruoyi.pg.domain.InPara.scheme2.Details.Tabel1;
import com.ruoyi.pg.domain.InPara.scheme2.Details.Tabel3;
import com.ruoyi.pg.domain.InPara.scheme2.Details.Tabel4;
import com.ruoyi.pg.domain.InPara.scheme2.Details.Table2;

import java.util.List;

public class PgInparaSA {
    private String pgbatchid;
    private String pgclass;

    private String did;

    private String patid;

    private String inhossum;

    private String pathosid;

    private List<SubtotalS> subtotalS;

    private TotalS total;

    private List<Tabel1> tabel1;

    private List<Table2> table2;

    private List<Tabel3> tabel3;

    private List<Tabel4> table4;

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

    public List<Tabel1> getTabel1() {
        return tabel1;
    }

    public void setTabel1(List<Tabel1> tabel1) {
        this.tabel1 = tabel1;
    }

    public List<Table2> getTable2() {
        return table2;
    }

    public void setTable2(List<Table2> table2) {
        this.table2 = table2;
    }

    public List<Tabel3> getTabel3() {
        return tabel3;
    }

    public void setTabel3(List<Tabel3> tabel3) {
        this.tabel3 = tabel3;
    }

    public List<Tabel4> getTable4() {
        return table4;
    }

    public void setTable4(List<Tabel4> table4) {
        this.table4 = table4;
    }


    @Override
    public String toString() {
        return "PgInparaSA{" +
                "pgbatchid='" + pgbatchid + '\'' +
                ", pgclass='" + pgclass + '\'' +
                ", did='" + did + '\'' +
                ", patid='" + patid + '\'' +
                ", inhossum='" + inhossum + '\'' +
                ", pathosid='" + pathosid + '\'' +
                ", subtotalS=" + subtotalS +
                ", total=" + total +
                ", tabel1=" + tabel1 +
                ", table2=" + table2 +
                ", tabel3=" + tabel3 +
                ", table4=" + table4 +
                '}';
    }
}
