package com.ruoyi.pg.service;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.pg.domain.TaPgdetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class ITaPgdetailServiceTest {

    @Autowired
    ITaPgdetailService taPgdetailService;

    @Test
   public void insertTaPgdetail() throws ParseException {
        TaPgdetail taPgdetail = new TaPgdetail();
        taPgdetail.setAcscore(10L);
        taPgdetail.setIssel("1");
        taPgdetail.setPgname("评估内容名称");
        taPgdetailService.insertTaPgdetail(taPgdetail);


    }

    @Test
   public void batchInsertTaPgdetail() throws ParseException{
        List<TaPgdetail> taPgdetailList = new ArrayList();
        TaPgdetail taPgdetail = new TaPgdetail();
        taPgdetail.setAcscore(11L);
        taPgdetail.setIssel("1");
        taPgdetail.setPgname("评估内容名称");
        taPgdetailList.add(taPgdetail);

        TaPgdetail taPgdetail1 = new TaPgdetail();
        taPgdetail1.setAcscore(12L);
        taPgdetail1.setIssel("0");
        taPgdetail1.setPgname("评估内容名称1");
        taPgdetailList.add(taPgdetail1);

        System.out.println("单独测试"+taPgdetailList);
        Integer result =   taPgdetailService.batchInsertTaPgdetail(taPgdetailList);
        System.out.println("批量插入返回值："+ result);
    }
}