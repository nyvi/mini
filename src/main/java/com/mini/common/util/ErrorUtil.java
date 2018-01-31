package com.mini.common.util;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.mini.common.dto.JsonResult;


public class ErrorUtil {

	/**
	 * 返回表单错误
	 */
	public static JsonResult getError(BindingResult result) {
		List<ObjectError> allErrors = result.getAllErrors();
		StringBuffer msg = new StringBuffer(256);
		allErrors.forEach(r -> msg.append(r.getDefaultMessage()).append("<br/>"));
		return JsonResult.error(msg.toString());
	}
}
