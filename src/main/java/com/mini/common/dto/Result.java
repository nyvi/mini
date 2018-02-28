package com.mini.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mini.common.enums.ResultCode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回格式
 * @author czk
 * @date 2018-02-07
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result implements Serializable{

	private static final long serialVersionUID = -3251721328990152019L;
	
	/**
	 * 返回状态码   参考 ResultCode
	 */
	private int code;
	
	/**
	 * 返回提示信息
	 */
	private String msg;	
	
	/**
	 * 返回数据
	 */
	private Object data; 
	
	/**
	 * 操作成功
	 */
	public static Result success(){
		return Result.success("操作成功！");
	}
	
	public static Result success(String msg){
		return Result.success(msg, "");
	}
	
	public static Result success(String msg, Object data){
		return new Result(ResultCode.SUCCESS.code(), msg, data);
	}
	
	/**
	 * 操作失败
	 */
	public static Result error(){
		return Result.error("操作失败");
	}
	
	public static Result error(String msg){
		return Result.error(msg, "");
	}
	
	public static Result error(String msg, Object data){
		return new Result(-1, msg, data);
	}
	
	/**
	 * 暂无数据
	 */
	public static Result empty(){
		return Result.empty("暂无数据！");
	}
	
	public static Result empty(String msg){
		return Result.empty(msg, "");
	}
	
	public static Result empty(String msg, Object data){
		return new Result(0, msg, data);
	}
	
	/**
	 * 自定义
	 */
	public static Result bulid(int code, String msg, Object data){
		return new Result(code, msg, data);
	}
}
