package com.ruoyi.pg.domain.InPara.scheme2.Details;

import java.util.List;

public class DetailRoot
{
    private List<Tabel1> tabel1;

    private List<Table2> table2;

    private List<Tabel3> tabel3;

    private List<Tabel4> table4;

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
        return "DetailRoot{" +
                "tabel1=" + tabel1 +
                ", table2=" + table2 +
                ", tabel3=" + tabel3 +
                ", table4=" + table4 +
                '}';
    }
}