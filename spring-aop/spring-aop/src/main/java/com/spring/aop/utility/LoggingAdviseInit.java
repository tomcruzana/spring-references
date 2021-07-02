package com.spring.aop.utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//JoinPoint - access method signature and args
@Order(1) // controls the order of advise execution
@Aspect
@Component
public class LoggingAdviseInit {

	@Before("execution(public Integer com.spring.aop.service.*.add*(..))")
	public void beforeLoggingAdd(JoinPoint joinpoint) {
		System.out.println("### LOGGING ADD METHOD : BEFORE : FIRST ###");

		// display method signiture using JoinPoint
		MethodSignature ms = (MethodSignature) joinpoint.getSignature();
		System.out.println("method: " + ms);

		// display method args using JoinPoint (it's stored in obj array because a
		// method can have many or zero args)
		Object[] args = joinpoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
	}
}