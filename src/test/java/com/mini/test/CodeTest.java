package com.mini.test;

import com.mini.Application;
import com.mini.sys.model.SysUserDO;
import com.mini.sys.query.SysUserQuery;
import com.mini.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author czk
 * @date 2018-01-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CodeTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void ListTest() {
        SysUserQuery query = new SysUserQuery();
        query.setName("么");
        List<SysUserDO> list = sysUserService.getList(query);
        System.out.println(list.size());
        list.forEach(f -> {
            System.out.println(f.toString());
        });
    }

}
