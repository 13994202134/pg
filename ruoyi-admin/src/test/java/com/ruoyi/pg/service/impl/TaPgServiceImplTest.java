package com.ruoyi.pg.service.impl;

import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.pg.domain.TaPg;
import com.ruoyi.pg.service.ITaPgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public  class TaPgServiceImplTest {
    @Autowired
    private ITaPgService taPgService;
    @Test
   public void selectPgByPara() {
        TaPg taPg =new TaPg();
        taPg.setDid("152");
        List<TaPg> list = taPgService.selectPgByPara(taPg);
        System.out.println(list);
    }


}