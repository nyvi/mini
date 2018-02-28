package com.mini.sys.model;

import org.hibernate.validator.constraints.NotBlank;

import com.nyvi.core.annotation.Column;
import com.nyvi.core.annotation.Table;
import com.nyvi.core.base.mode.BaseDO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 系统用户
 * @author czk
 * @date 2018-01-13
 */
@Data
@Table(name = "sys_user")
@SuppressWarnings("serial")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysUserDO extends BaseDO {

	/**
	 * 用户名
	 */
	@Column
	@NotBlank(message = "用户名不能为空！")
	private String username;

	/**
	 * 手机号
	 */
	@Column
	@NotBlank(message = "手机号码不能为空!")
	private String phone;

	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;
}
