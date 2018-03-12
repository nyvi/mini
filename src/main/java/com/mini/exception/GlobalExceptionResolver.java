package com.mini.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		log.error(exception.getMessage(), exception);
		/*String requestType = request.getHeader("X-Requested-With");
		if (StringUtils.isBlank(requestType)) {
			//return new ModelAndView("/error/500");
		}
		Result result = null;
		if (exception instanceof IllegalArgumentException) {
			result = Result.error(exception.getMessage());
		} else if (exception instanceof NoHandlerFoundException) {
			result = Result.error("接口 [" + request.getRequestURI() + "] 不存在");
		} else {
			result = Result.error("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
			log.error(exception.getMessage(), exception);
		}
		responseResult(response, result);*/
		return null;
	}

	/**
	 * json返回
	 * @param response
	 * @param result
	 */
/*	private void responseResult(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			response.getWriter().write(JSON.toJSONString(result));
			response.getWriter().flush();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}*/
}
