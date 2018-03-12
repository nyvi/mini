package com.mini.sys.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mini.sys.model.SysUserDO;
import com.mini.sys.query.SysUserQuery;
import com.mini.sys.service.SysUserService;
import com.nyvi.support.base.service.impl.BaseServiceImpl;

/**
 * @author czk
 * @date 2018-01-14
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDO> implements SysUserService {

	@Override
	@Cacheable(value = "userList", unless = "#result.size() <= 10") // 返回结果大于10的才缓存
	public List<SysUserDO> getList(SysUserQuery query) {
		System.out.println("------------------执行了------------------");
		return super.getList(query);
	}

	@Override
	public int saveOrUpdate(SysUserDO sysUser) throws Exception {
		if (Objects.isNull(sysUser.getId())) {
			return this.save(sysUser);
		}
		return this.update(sysUser);
	}

}
