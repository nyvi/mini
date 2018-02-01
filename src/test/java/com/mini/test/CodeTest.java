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

import java.util.ArrayList;
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
		SysUserQuery query = new SysUserQuery().setUsername("T");
		List<SysUserDO> list = sysUserService.getList(query);
		list.forEach(f -> {
			System.out.println(f.toString());
		});
	}

	@Test
	public void batchSvaeTest() throws Exception {
		SysUserDO user = null;
		long start = System.currentTimeMillis();
		Long phone = 18800011002L;
		List<SysUserDO> list = new ArrayList<>(10000);
		for (int i = 0; i < 10000; i++) {
			phone++;
			user = new SysUserDO();
			user.setUsername("水军" + (i + 11002) + "号");
			user.setPhone(phone.toString());
			user.setPassword(phone.toString());
			list.add(user);
		}
		int ret = sysUserService.batchSave(list);
		System.out.println(ret);
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));
	}
}
