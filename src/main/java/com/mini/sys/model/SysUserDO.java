package com.mini.sys.model;

import com.mini.common.annotations.Column;
import com.mini.common.annotations.Table;
import com.mini.common.base.model.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户
 * @author czk
 * @date 2018-01-13
 */
@Data
@Table("sys_user")
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class SysUserDO extends BaseDO {

    /**
     * 用户名
     */
    @Column("name")
    private String name;

    /**
     * 手机号
     */
    @Column("phone")
    private String phone;

    /**
     * 密码
     */
    @Column("password")
    private String password;
}
