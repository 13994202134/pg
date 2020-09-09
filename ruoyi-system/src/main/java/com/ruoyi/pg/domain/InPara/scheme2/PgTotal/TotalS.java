package com.ruoyi.pg.domain.InPara.scheme2.PgTotal;

public class TotalS
{


    private String count;

    private String grade;

    public void setCount(String count){
        this.count = count;
    }
    public String getCount(){
        return this.count;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getGrade(){
        return this.grade;
    }

    @Override
    public String toString() {
        return "Total{" +
                "count=" + count +
                ", grade='" + grade + '\'' +
                '}';
    }
}
