package com.mini.common.annotations;

import java.lang.annotation.*;

/**
 * 表名注解
 * @author czk
 * @date 2017-12-01
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    /**
     * 表名称
     * @return
     */
    String value() default "";
}
