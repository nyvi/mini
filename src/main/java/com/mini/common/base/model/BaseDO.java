package com.mini.common.base.model;

import com.mini.common.annotations.Column;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    @Column(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(value = "gmt_modified")
    private Date gmtModified;
}
