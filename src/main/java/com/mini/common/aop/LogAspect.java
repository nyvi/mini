package com.mini.common.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;

/**
 * 方法日志打印 aop实现类
 * @author czk
 * @date 2018-02-01
 */
@Aspect
@Log4j2
@Component
public class LogAspect {

	/**
	 * 切入点
	 */
	@Pointcut("@annotation(com.mini.common.annotations.Log)")
	private void pointcut() {

	}

	/**
	 * 接收到请求时
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("pointcut()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		log.info("url: {}", request.getRequestURL().toString());
		log.info("method: {}", request.getMethod());
		log.info("ip: {}", request.getRemoteAddr());
		log.info("class_method:{}.{} ", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		log.info("args: {}", Arrays.toString(joinPoint.getArgs()));
	}

	/**
	 * 处理完请求
	 * @param ret
	 * @throws Throwable
	 */
	@AfterReturning(returning = "ret", pointcut = "pointcut()")
	public void doAfterReturning(Object ret) throws Throwable {
		log.info("result : {}", ret);
	}

}
