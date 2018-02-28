package com.mini.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * list 工具类
 * @author czk
 * @date 2018-01-30
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListUtil {

	/**
	 * 字符串数组类型id转long类型id
	 * @param ids
	 * @return
	 */
	public final static List<Long> convertFor(final String[] ids) {
		if (ArrayUtils.isEmpty(ids)) {
			return new ArrayList<>(0);
		}
		List<Long> idList = new ArrayList<>(ids.length);
		for (String str : ids) {
			boolean isNumber = NumberUtils.isCreatable(str);
			if (isNumber) {
				idList.add(NumberUtils.toLong(str));
			}
		}
		return idList;
	}
}
