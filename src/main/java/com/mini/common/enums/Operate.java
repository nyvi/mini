package com.mini.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 查询基本操作
 * @author czk
 * @date 2017-12-01
 */
@AllArgsConstructor
public enum Operate {
    /**
     * 等于: =
     */
    EQ("="),
    /**
     * 大于: >
     */
    GT(">"),
    /**
     * 大于等于: >=
     */
    GTE(">="),
    /**
     * 小于: <
     */
    LT("<"),
    /**
     * 小于等于: <=
     */
    LTE("<="),
    /**
     * 全匹配: like %s%
     */
    LIKE("like"),
    /**
     * in 查询 in(), 字段必须为 List
     */
    IN("in");

    @Getter
    private String value;

}
