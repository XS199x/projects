package com.spark.aop;

import com.spark.utils.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Title: LogAspect
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-13
 */
@Aspect
@Order(1)
@Component
public class LogAspect {
	private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.spark.controller..*.* (..))")
	public void pointcut() {
		LOG.info("******LogAspect******");
	}
	
	@Before("pointcut()")
	public void before() {
		LOG.info("******LogAspect(before)******");
	}
	
	@After("pointcut()")
	public void after() {
		LOG.info("******LogAspect(after)******");
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		String start = DateUtil.getNowDateDefault();
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			LOG.error(throwable.getMessage(),throwable);
		}finally {
			String end = DateUtil.getNowDateDefault();
			LOG.info("请求时间："+start+"-"+end);
			LOG.info("result:"+ Optional.ofNullable(result).orElse("").toString());
		}
		return result;
	}
	
	@AfterReturning("pointcut()")
	public void afterReturning() {
	
	}
	
	@AfterThrowing("pointcut()")
	public void afterThrowing() {
	
	}
	
}
