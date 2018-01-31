package com.mini.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mini.sys.model.SysUserDO;
import com.mini.sys.query.SysUserQuery;
import com.mini.sys.service.SysUserService;

@Controller
public class ManageController {

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 主页
	 * @return
	 */
	@GetMapping(value = { "main.html", "/" })
	public ModelAndView mian() {
		ModelAndView mv = new ModelAndView("manage/main");
		SysUserQuery query = new SysUserQuery();
		query.setPageSize(1);
		List<SysUserDO> list = sysUserService.getList(query);
		if (!list.isEmpty()) {
			mv.addObject("user", list.get(0));
		}
		return mv;
	}
}
