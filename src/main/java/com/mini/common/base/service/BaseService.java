package com.mini.common.base.service;

import com.mini.common.base.model.BaseDO;
import com.mini.common.base.query.BaseQuery;

import java.util.List;

/**
 * 公共接口
 * @author czk
 * @date 2018-01-13
 */
public interface BaseService<T extends BaseDO> {

    /**
     * 保存
     * @param t 实体
     * @return 影响行数
     */
    int save(T t);

    /**
     * 更新非空字段,id不能为空
     * @param t 实体
     * @return 影响行数
     */
    int update(T t);

    /**
     * 更新或保存,id为空时保存,非空更新
     * @param t 实体
     * @return 影响行数
     */
    int saveOrUpdate(T t);

    /**
     * 批量保存
     * @param list 实体集合
     * @return 影响行数
     */
    int batchSave(List<T> list);

    /**
     * 删除
     * @param id 主键
     * @return 影响行数
     */
    int delete(Long id);

    /**
     * 批量删除
     * @param idList id集合
     * @return 影响行数
     */
    int batchDelete(List<Long> idList);

    /**
     * 查询总数
     * @param query 查询条件
     * @return 影响行数
     */
    <Q extends BaseQuery> int getCount(Q query);

    /**
     * 查询实体
     * @param id 主键
     * @return 查不到返回null, 否则返回实体
     */
    T getEntity(Long id);

    /**
     * 查询列表
     * @param query 查询条件
     * @return 返回列表
     */
    <Q extends BaseQuery> List<T> getList(Q query);
}
