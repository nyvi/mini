package com.mini.common.annotations;

import com.mini.common.enums.Operate;

import java.lang.annotation.*;

/**
 * 查询字段注解
 * @author czk
 * @date 2017-12-01
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Query {
    /**
     * 字段名
     * @return 字段名称
     */
    String value() default "";

    /**
     * 操作符
     * @return 操作符
     */
    Operate operate() default Operate.EQ;

    /**
     * 参数内容前缀
     * @return 参数内容前缀
     */
    String prefix() default "";

    /**
     * 参数内容后缀
     * @return 参数内容后缀
     */
    String suffix() default "";
}
