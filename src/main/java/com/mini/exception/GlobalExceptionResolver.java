package com.mini.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.mini.common.dto.JsonResult;

import lombok.extern.log4j.Log4j2;

/**
 * 全局异常控制
 * @author czk
 * @date 2018-02-01
 */
@Log4j2
@ControllerAdvice
public class GlobalExceptionResolver {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Exception exception) {
		log.error(exception.toString());
		StackTraceElement[] stackTrace = exception.getStackTrace();
		StringBuffer msg = new StringBuffer();
		for (StackTraceElement stackTraceElement : stackTrace) {
			msg.append(stackTraceElement).append("\n");
		}
		log.error(msg.toString());
		String requestType = request.getHeader("X-Requested-With");
		if (StringUtils.isBlank(requestType)) {
			return new ModelAndView("/error/500");
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			JsonResult result = JsonResult.error("系统异常，请稍后重试！");
			try {
				response.getWriter().write(JSON.toJSONString(result));
				response.getWriter().flush();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}
}
