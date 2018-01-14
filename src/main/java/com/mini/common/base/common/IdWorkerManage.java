package com.mini.common.base.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * id生成器工厂
 * @author czk
 * @date 2017-12-01
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdWorkerManage {

    private static IdWorker idWorkerInstance = null;

    /**
     * 获取
     * single 单例模式(懒汉式，线程安全)
     * @return 唯一id
     */
    private static synchronized IdWorker getIdWorkerInstance() {
        if (idWorkerInstance == null) {
            idWorkerInstance = new IdWorker(1, 1);
        }
        return idWorkerInstance;
    }

    /**
     * 获取唯一id
     * @return
     */
    public static long getId() {
        return getIdWorkerInstance().getId();
    }

}
