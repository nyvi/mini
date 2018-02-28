package com.mini.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
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
	 * Json转换使用FastJson
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.BrowserCompatible, // 数字字符串化
				SerializerFeature.WriteMapNullValue, 	  // 保留空的字段
				SerializerFeature.WriteNullStringAsEmpty, // String null -> ""
				SerializerFeature.WriteNullNumberAsZero); // Number null -> 0
		config.setDateFormat("yyyy-MM-dd HH:mm");
		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(converter);
	}

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
