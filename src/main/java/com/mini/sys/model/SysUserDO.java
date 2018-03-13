package com.mini.sys.model;

import java.io.Serializable;
import java.util.Date;

import com.nyvi.support.annotation.Column;
import com.nyvi.support.annotation.Id;
import com.nyvi.support.annotation.Table;

import lombok.Data;

/**
 * 系统用户
 * @author czk
 * @date 2018-01-13
 */
@Data
@Table("sys_user")
@SuppressWarnings("serial")
public class SysUserDO implements Serializable {

	/**
	 * id
	 */
	@Id
	private Long id;

	/**
	 * 用户名
	 */
	@Column
	private String username;

	/**
	 * 手机号
	 */
	@Column
	private String phone;

	/**
	 * 密码
	 */
	@Column
	private String password;

	/**
	 * 创建时间
	 */
	@Column(update = false)
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	@Column
	private Date gmtModified;
}
