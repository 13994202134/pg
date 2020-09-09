package com.ruoyi.system.service;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.pg.domain.TaDpment;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class ISysUserServiceTest {
    @Autowired
    ISysUserService sysUserService;
    @Test
   public void selectUserList() {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("wsy");
        List<SysUser> result = sysUserService.selectUserList(sysUser);
        for(int i = 0; i < result.size(); i++){
            System.out.println("用戶" + i);
            String loginName = result.get(i).getLoginName();
            System.out.println("登录名："+loginName);
            SysDept s = result.get(i).getDept();
            System.out.println("患者部門:"+s.getDeptName());
        }
    }

}