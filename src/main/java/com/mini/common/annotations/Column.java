package com.mini.common.annotations;

import java.lang.annotation.*;

/**
 * 表字段注解
 * @author czk
 * @date 2017-12-01
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    /**
     * 字段名
     * @return 字段名称
     */
    String value() default "";

    /**
     * 是否主键,默认false
     * @return true主键/false非主键
     */
    boolean isKey() default false;
}
