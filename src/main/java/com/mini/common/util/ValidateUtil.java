package com.mini.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 验证
 * @author czk
 * @date 2018-02-28
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidateUtil {

	/**
	 * 参数验证
	 * @param result
	 */
	public static void checkArgument(BindingResult result) {
		if (result.hasErrors()) {
			ObjectError objectError = result.getAllErrors().get(0);
			throw new IllegalArgumentException(objectError.getDefaultMessage());
		}
	}
}
