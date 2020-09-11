package com.ruoyi.pg.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class tools {
    /***
     * 获得当前系统时间（字符串格式精确到秒）
     * @return
     */
    public static String getStringTodayTime(){
        Date todat_date = new Date();
        //将日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //转换成字符串格式
        return simpleDateFormat.format(todat_date);
    }
}
