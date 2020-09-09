package com.ruoyi.pg.domain.InPara.scheme1;
import java.util.List;
public class PgInPara {
    private String pgbatchid;

    private String pgclass;

    private String did;

    private String patid;

    private String inhossum;

    private String pathosid;

    private List<Subtotal> subtotal;

    private Total total;

    private List<Detail> detail;


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





    public void setPgbatchid(String pgbatchid){
        this.pgbatchid = pgbatchid;
    }
    public String getPgbatchid(){
        return this.pgbatchid;
    }
    public void setPgclass(String pgclass){
        this.pgclass = pgclass;
    }
    public String getPgclass(){
        return this.pgclass;
    }
    public void setDid(String did){
        this.did = did;
    }
    public String getDid(){
        return this.did;
    }
    public void setPatid(String patid){
        this.patid = patid;
    }
    public String getPatid(){
        return this.patid;
    }
    public void setSubtotal(List<Subtotal> subtotal){
        this.subtotal = subtotal;
    }
    public List<Subtotal> getSubtotal(){
        return this.subtotal;
    }
    public void setTotal(Total total){
        this.total = total;
    }
    public Total getTotal(){
        return this.total;
    }
    public void setDetail(List<Detail> detail){
        this.detail = detail;
    }
    public List<Detail> getDetail(){
        return this.detail;
    }

    @Override
    public String toString() {
        return "PgInPara{" +
                "pgbatchid='" + pgbatchid + '\'' +
                ", pgclass='" + pgclass + '\'' +
                ", did='" + did + '\'' +
                ", patid='" + patid + '\'' +
                ", inhossum='" + inhossum + '\'' +
                ", pathosid='" + pathosid + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                ", detail=" + detail +
                '}';
    }
}