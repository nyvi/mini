package com.mini.sys.query;


import com.nyvi.support.annotation.Query;
import com.nyvi.support.base.query.BaseQuery;

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

	@Query
	public String username;
	
	@Query
	public String phone;
}
