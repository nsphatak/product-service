package com.eresh.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {

	@Pointcut("@annotation(com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand)")
	public void circuitBreakerCommandAnnotationPointCut() {
	}
	
	@After("circuitBreakerCommandAnnotationPointCut()")
	public void methodsAnnotatedWithCircuitBrekerCommand(final JoinPoint joinPoint) {
		System.out.println("INSD+IDE custom annotaton");
	}
}
