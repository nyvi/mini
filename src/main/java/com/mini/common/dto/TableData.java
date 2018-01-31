package com.mini.common.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表格显示数据 bootstrap Table 数据格式
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TableData<T> {

	/**
	 * 总记录数
	 */
	Integer total;

	/**
	 * 显示数据
	 */
	List<T> rows;

	/**
	 * 客户端分页返回数据
	 * @param rows 显示数据
	 * @return
	 */
	public static <T> TableData<T> bulid(List<T> rows) {
		return new TableData<>(null, rows);
	}

	/**
	 * 服务端分页返回数据
	 * @param total  总记录数
	 * @param rows 显示数据
	 * @return
	 */
	public static <T> TableData<T> bulid(int total, List<T> rows) {
		return new TableData<>(total, rows);
	}

	/**
	 * 暂无数据
	 * 
	 * @return
	 */
	public static <T> TableData<T> empty() {
		return new TableData<>(0, new ArrayList<>(0));
	}

}
