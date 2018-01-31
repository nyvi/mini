package com.mini.common.base.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mini.common.annotations.Column;

import lombok.Data;

/**
 * BaseDO
 * @author czk
 * @date 2017-12-01
 */
@Data
public class BaseDO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Column(value = "id", isKey = true)
	private Long id;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@Column(value = "gmt_create")
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@Column(value = "gmt_modified")
	private Date gmtModified;
}
