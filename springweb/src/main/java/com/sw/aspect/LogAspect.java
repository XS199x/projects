package com.sw.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Title: LogAspect
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-07
 */
@Aspect
@Component
public class LogAspect {
	
	@Pointcut("execution(* com.sw.web.controller.HelloController.*(..))")
	public  void log (){}
	
	@Before("log()")
	public  void logBefore(){
		System.out.println("before");
	}
	
	@After("log()")
	public  void logAfter(){
		System.out.println("after");
	}
}
