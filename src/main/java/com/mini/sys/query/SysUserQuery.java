package com.mini.sys.query;

import com.mini.common.annotations.Query;
import com.mini.common.base.query.BaseQuery;
import com.mini.common.enums.Operate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 用户查询Query
 * @author czk
 * @date 2018-01-14
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("serial")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysUserQuery extends BaseQuery {

	@Query(operate = Operate.LIKE, suffix = "%")
	public String username;

	public String phone;
}
