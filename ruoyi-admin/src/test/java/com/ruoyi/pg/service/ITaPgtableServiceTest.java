package com.ruoyi.pg.service;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.pg.domain.TaPgtable;
import com.ruoyi.pg.domain.view.TaPgtableForView;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class ITaPgtableServiceTest {
    @Autowired
    ITaPgtableService  taPgtableService;
    @Test
   public   void selectTaPgtableSmallList() {
        TaPgtable taPgtable=new TaPgtable();
        taPgtable.setTablename("wai");
        taPgtable.setPgclass("table1");
        List<TaPgtable> list = taPgtableService.selectTaPgtableSmallList(taPgtable);
        System.out.println("test评估表信息："+ list);
    }
}