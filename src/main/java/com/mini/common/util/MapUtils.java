package com.mini.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Map工具类
 * @author czk
 * @date 2017-12-02
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapUtils {

    /**
     * 最大容量
     */
    private static final int MAX_POWER_OF_TWO = 1 << 30;

    /**
     * 容量最小判断
     */
    private static final int MIN = 3;

    /**
     * 初始化HashMap
     * @param expectedSize 初始化个数
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> HashMap<K, V> newHashMap(int expectedSize) {
        return new HashMap<K, V>(capacity(expectedSize));
    }

    /**
     * 初始化LinkedHashMap
     * @param expectedSize 初始化个数
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> HashMap<K, V> newLinkedHashMap(int expectedSize) {
        return new LinkedHashMap<K, V>(capacity(expectedSize));
    }

    /**
     * Map初始化容量
     * @param expectedSize 预计数据个数
     * @return
     */
    public static final int capacity(int expectedSize) {
        if (expectedSize < 0) {
            throw new IllegalArgumentException("Map初始化大小不能小于0");
        }
        if (expectedSize < MIN) {
            return expectedSize + 1;
        }
        if (expectedSize < MAX_POWER_OF_TWO) {
            return (int) ((float) expectedSize / 0.75F + 1.0F);
        }
        return Integer.MAX_VALUE;
    }

}
