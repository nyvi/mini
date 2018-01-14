package com.mini.common.base.query;

import lombok.Data;

import java.io.Serializable;

/**
 * Base Query
 * @author czk
 * @date 2017-12-01
 */
@Data
public class BaseQuery implements Serializable {

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 每页显示个数
     */
    private Integer pageSize = 10;

    /**
     * 排序
     */
    private String order;

}
