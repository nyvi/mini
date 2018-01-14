package com.mini.common.base.service.impl;

import com.mini.common.base.dao.BaseDAO;
import com.mini.common.base.model.BaseDO;
import com.mini.common.base.query.BaseQuery;
import com.mini.common.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * @author czk
 * @date 2018-01-13
 */
public class BaseServiceImpl<T extends BaseDO> implements BaseService<T> {

    /**
     * BaseDAO
     */
    @Autowired
    private BaseDAO<T> baseDAO;

    /**
     * 保存
     * @param t 实体
     * @return 影响行数
     */
    @Override
    public int save(T t) {
        return baseDAO.save(t);
    }

    /**
     * 更新非空字段,id不能为空
     * @param t 实体
     * @return 影响行数
     */
    @Override
    public int update(T t) {
        return baseDAO.update(t);
    }

    /**
     * 更新或保存,id为空时保存,非空更新
     * @param t 实体
     * @return 影响行数
     */
    @Override
    public int saveOrUpdate(T t) {
        if (Objects.isNull(t.getId())) {
            return baseDAO.save(t);
        }
        return baseDAO.update(t);
    }

    /**
     * 批量保存
     * @param list 实体集合
     * @return 影响行数
     */
    @Override
    public int batchSave(List<T> list) {
        return baseDAO.batchSave(list);
    }

    /**
     * 删除
     * @param id 主键
     * @return 影响行数
     */
    @Override
    public int delete(Long id) {
        return baseDAO.delete(id);
    }

    /**
     * 批量删除
     * @param idList id集合
     * @return 影响行数
     */
    @Override
    public int batchDelete(List<Long> idList) {
        return baseDAO.batchDelete(idList);
    }

    /**
     * 查询总数
     * @param query 查询条件
     * @return 影响行数
     */
    @Override
    public <Q extends BaseQuery> int getCount(Q query) {
        return baseDAO.getCount(query);
    }

    /**
     * 查询实体
     * @param id 主键
     * @return 查不到返回null, 否则返回实体
     */
    @Override
    public T getEntity(Long id) {
        return baseDAO.getEntity(id);
    }

    /**
     * 查询列表
     * @param query 查询条件
     * @return 返回列表
     */
    @Override
    public <Q extends BaseQuery> List<T> getList(Q query) {
        return baseDAO.getList(query);
    }
}
