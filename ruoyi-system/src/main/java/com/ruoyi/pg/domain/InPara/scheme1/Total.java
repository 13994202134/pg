package com.ruoyi.pg.domain.InPara.scheme1;

public class Total
{


    private long count;

    private String grade;

    public void setCount(Long count){
        this.count = count;
    }
    public Long getCount(){
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
