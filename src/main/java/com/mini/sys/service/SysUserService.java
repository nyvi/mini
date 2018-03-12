package com.mini.sys.service;

import java.util.List;

import com.mini.sys.model.SysUserDO;
import com.mini.sys.query.SysUserQuery;
import com.nyvi.support.base.service.BaseService;

/**
 * sysUser接口
 * @author czk
 * @date 2018-01-14
 */
public interface SysUserService extends BaseService<SysUserDO> {

	/**
	 * 获取所有
	 * @return
	 */
	List<SysUserDO> getList(SysUserQuery query);
	
	/**
	 * 修改/更新
	 * @param sysUser
	 * @return
	 */
	int saveOrUpdate(SysUserDO sysUser) throws Exception;
}
