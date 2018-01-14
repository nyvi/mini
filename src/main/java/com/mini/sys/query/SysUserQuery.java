package com.mini.sys.query;

import com.mini.common.annotations.Query;
import com.mini.common.annotations.Table;
import com.mini.common.base.query.BaseQuery;
import com.mini.common.enums.Operate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询Query
 * @author czk
 * @date 2018-01-14
 */
@Data
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class SysUserQuery extends BaseQuery {

    @Query(value = "name", operate = Operate.LIKE, prefix = "%", suffix = "%")
    public String name;
}
