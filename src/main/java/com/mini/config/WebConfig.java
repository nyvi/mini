package com.mini.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mini.interceptor.LoginInterceptor;

/**
 * 系统配置
 * @author czk
 * @date 2018-02-01
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private LoginInterceptor loginInterceptor;

	/**
	 * 登录拦截器 
	 * 多个拦截器组成一个拦截器链 
	 * addPathPatterns 用于添加拦截规则 
	 * excludePathPatterns 用户排除拦截
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).excludePathPatterns("/login.html", "/login");
		super.addInterceptors(registry);
	}
}
