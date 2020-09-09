package com.ruoyi.pg.service;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.pg.domain.TaDpment;
import com.ruoyi.pg.domain.TaPatInfor;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Action;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class ITaPatInforServiceTest
{
    @Autowired
    ITaPatInforService taPatInforService;


    @Test
    public void selectPdByPara() {
        TaPatInfor taPatInfor = new TaPatInfor();
        taPatInfor.setBed("03");
        List<TaPatInfor> result = taPatInforService.selectPdByPara(taPatInfor);


        for(int i = 0; i < result.size(); i++){
            System.out.println("患者" + i);
                String name = result.get(i).getPatname();
                System.out.println("患者姓名："+name);
                TaDpment s = result.get(i).getDepart();
                System.out.println("患者部門:"+s.getDname());
            }
        }



}