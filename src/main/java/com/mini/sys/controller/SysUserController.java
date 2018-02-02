package com.mini.sys.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mini.common.annotations.Log;
import com.mini.common.dto.JsonResult;
import com.mini.common.dto.TableData;
import com.mini.common.util.ErrorUtil;
import com.mini.common.util.ListUtil;
import com.mini.sys.model.SysUserDO;
import com.mini.sys.query.SysUserQuery;
import com.mini.sys.service.SysUserService;

/**
 * sysUserController
 * @author czk
 * @date 2018-01-30
 */
@Controller
@RequestMapping("sys/user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 列表页面
	 * @return
	 */
	@GetMapping(value = "list.html")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("sys/user/list");
		return mv;
	}
	
	/**
	 * 列表页面
	 * @return
	 */
	@GetMapping(value = "create.html")
	public ModelAndView create(Long id) {
		ModelAndView mv = new ModelAndView("sys/user/create");
		if (Objects.nonNull(id)) {
			SysUserDO sysUser = sysUserService.getEntity(id);
			mv.addObject("data", sysUser);
		}
		return mv;
	}

	/**
	 * 列表数据
	 * @return
	 */
	@ResponseBody
	@PostMapping("getTableData")
	public TableData<SysUserDO> getTableData(SysUserQuery query) {
		return sysUserService.getTableData(query);
	}
	
	/**
	 * 获取所有用户列表
	 * @return
	 */
	@Log
	@ResponseBody
	@GetMapping(value = "getList")
	public List<SysUserDO> getList(SysUserQuery query){
		return sysUserService.getList(query);
	}
	
	/**
	 * 保存/更新
	 * @param sysUser
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@PostMapping("save")
	public JsonResult save(@Valid SysUserDO sysUser, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return ErrorUtil.getError(result);
		}
		if (Objects.isNull(sysUser.getId())) {
			sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPhone()).substring(8, 24));
		}
		SysUserQuery query = new SysUserQuery().setPhone(sysUser.getPhone()).setUsername("");
		List<SysUserDO> list = sysUserService.getList(query);
		if(!list.isEmpty() && !Objects.equals(list.get(0).getId(), sysUser.getId())){
			return JsonResult.error("该手机已有绑定账号!");
		}
		int ret = sysUserService.saveOrUpdate(sysUser);
		return ret > 0 ? JsonResult.success("保存成功!") : JsonResult.error("保存失败!");
	}

	/**
	 * 删除
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping(value = "delete")
	public JsonResult delete(HttpServletRequest request) throws Exception {
		String[] ids = request.getParameterValues("checkedid");
		List<Long> idList = ListUtil.convertFor(ids);
		if (idList.isEmpty()) {
			return JsonResult.error("请选择要删除的记录!");
		}
		int ret = sysUserService.batchDelete(idList);
		return ret > 0 ? JsonResult.success("删除成功") : JsonResult.error("删除失败");
	}
}
