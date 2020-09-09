package com.ruoyi.pg.domain.InPara.scheme1;

public class Detail
{
    private String pgtable;

    private String pgName;

    private Long asScore;

    private String isSel;

    public void setPgtable(String pgtable){
        this.pgtable = pgtable;
    }
    public String getPgtable(){
        return this.pgtable;
    }
    public void setPgName(String pgName){
        this.pgName = pgName;
    }
    public String getPgName(){
        return this.pgName;
    }
    public void setAsScore(Long asScore){
        this.asScore = asScore;
    }
    public Long getAsScore(){
        return this.asScore;
    }
    public void setIsSel(String isSel){
        this.isSel = isSel;
    }
    public String getIsSel(){
        return this.isSel;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "pgtable='" + pgtable + '\'' +
                ", pgName='" + pgName + '\'' +
                ", asScore=" + asScore +
                ", isSel='" + isSel + '\'' +
                '}';
    }
}
