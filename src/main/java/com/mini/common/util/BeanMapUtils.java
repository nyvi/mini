package com.mini.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * beanMap 互转工具类
 * @author czk
 * @date 2017-12-10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanMapUtils {

    /**
     * bean转为Map,不包含值空字段
     * @param bean
     * @return
     */
    public static final <T> Map<String, Object> beanToMap(T bean) {
        return beanToMap(bean, true);
    }

    /**
     * bean转为Map
     * @param bean
     * @param ignore 是否忽略值为空的字段
     * @return
     */
    public static final <T> Map<String, Object> beanToMap(T bean, boolean ignore) {
        if (Objects.isNull(bean)) {
            return new HashMap<>(0);
        }
        BeanMap beanMap = BeanMap.create(bean);
        Map<String, Object> map = new HashMap<>(MapUtils.capacity(beanMap.size()));
        for (Object key : beanMap.keySet()) {
            Object value = beanMap.get(key);
            if (ignore && Objects.isNull(value)) {
                continue;
            }
            map.put(key.toString(), value);
        }
        return map;
    }

    /**
     * Map转Bean
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

}
