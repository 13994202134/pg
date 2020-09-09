package com.ruoyi.pg.domain.InPara.scheme2.PgTotal;

public class SubtotalS
{
    private String pgtable;

    private String pgResult;

    public void setPgtable(String pgtable){
        this.pgtable = pgtable;
    }
    public String getPgtable(){
        return this.pgtable;
    }
    public void setPgResult(String pgResult){
        this.pgResult = pgResult;
    }
    public String getPgResult(){
        return this.pgResult;
    }

    @Override
    public String toString() {
        return "Subtotal{" +
                "pgtable='" + pgtable + '\'' +
                ", pgResult='" + pgResult + '\'' +
                '}';
    }
}
