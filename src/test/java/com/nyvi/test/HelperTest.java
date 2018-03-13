package com.nyvi.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mini.Application;
import com.mini.sys.model.SysUserDO;
import com.mini.sys.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class HelperTest {

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void updateTest() throws Exception {
		SysUserDO user = new SysUserDO();
		user.setId(111L);
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		user.setPhone("123");
		int update = sysUserService.update(user);
		System.out.println(update);
	}
}
