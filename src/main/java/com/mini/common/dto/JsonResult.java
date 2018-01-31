package com.mini.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Json返回数据格式
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult implements Serializable{

	private static final long serialVersionUID = -3251721328990152019L;

	private int code;	//返回状态码  -1:错误状态, 0:没有数据, 1:成功状态
	
	private String msg;	//返回提示信息
	
	private Object data; //返回数据
	
	/**
	 * 操作成功
	 */
	public static JsonResult success(){
		return JsonResult.success("操作成功！");
	}
	
	public static JsonResult success(String msg){
		return JsonResult.success(msg, "");
	}
	
	public static JsonResult success(String msg, Object data){
		return new JsonResult(1, msg, data);
	}
	
	/**
	 * 操作失败
	 */
	public static JsonResult error(){
		return JsonResult.error("操作失败");
	}
	
	public static JsonResult error(String msg){
		return JsonResult.error(msg, "");
	}
	
	public static JsonResult error(String msg, Object data){
		return new JsonResult(-1, msg, data);
	}
	
	/**
	 * 暂无数据
	 */
	public static JsonResult empty(){
		return JsonResult.empty("暂无数据！");
	}
	
	public static JsonResult empty(String msg){
		return JsonResult.empty(msg, "");
	}
	
	public static JsonResult empty(String msg, Object data){
		return new JsonResult(0, msg, data);
	}
	
	/**
	 * 自定义
	 */
	public static JsonResult bulid(int code, String msg, Object data){
		return new JsonResult(code, msg, data);
	}
}
