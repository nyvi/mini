package com.mini.sys.model;

import org.hibernate.validator.constraints.NotBlank;

import com.mini.common.annotations.Column;
import com.mini.common.annotations.Table;
import com.mini.common.base.model.BaseDO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 系统用户
 * @author czk
 * @date 2018-01-13
 */
@Data
@Table("sys_user")
@SuppressWarnings("serial")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysUserDO extends BaseDO {

	/**
	 * 用户名
	 */
	@Column("username")
	@NotBlank(message = "用户名不能为空！")
	private String username;

	/**
	 * 手机号
	 */
	@Column("phone")
	@NotBlank(message = "手机号码不能为空!")
	private String phone;

	/**
	 * 密码
	 */
	@Column("password")
	private String password;
}
