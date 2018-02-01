package com.mini.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j2;

/**
 * 拦截器配置
 * @author czk
 * @date 2018-02-01
 */
@Log4j2
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 访问方法之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			String requestURI = request.getRequestURI();
			log.info("当前请求路径是:{}", requestURI);
		}
		return true;
	}
	
}
