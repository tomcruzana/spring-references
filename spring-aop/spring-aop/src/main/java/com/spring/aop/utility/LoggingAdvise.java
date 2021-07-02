package com.spring.aop.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/* doc: https://bit.ly/3qaF0Zd
 * extra doc: https://bit.ly/3xBHqlW
 * 
 * overview:
 * create advise class
 * enable component scanning
 * create pointcut pattern expressions delegated to proper advaise annotations. ex: @Before, @Around
 * (optional) add an @Order for order of execution
 * (optional) use pointcut declarations and combine or reuse 'em
 * (optional) use JoinPoint object to access method signature and args of matching methods! 
 * */

// AOP Advises demo
@Order(2) // controls the order of advise execution
@Aspect
@Component
public class LoggingAdvise {

	// before advise
	@Before("execution(public Integer com.spring.aop.service.*.add*(..))")
	public void beforeLoggingAdd() {
		System.out.println("### LOGGING ADD METHOD : BEFORE : SECOND ###");
	}

	// after
	@After("execution(public Integer com.spring.aop.service.*.add*(..))")
	public void afterLoggingAdd() {
		System.out.println("### LOGGING ADD METHOD : AFTER ###");
	}

	// after returning advise
	// -returning is an optional param that will give access to the returning value
	// of matching methods
	// -the returning value which is 'result' must match the param name of the
	// advise
	// method
	@AfterReturning(pointcut = "execution(public Integer com.spring.aop.service.*.add*(..))", returning = "result")
	public void afterReturningLoggingAdd(Object result) {
		System.out.println("### LOGGING ADD METHOD : AFTER RETURNING ###");

		System.out.println("result: " + result.toString());
	}

	// after throwing advise
	// -the throwing value which is 'throwingException' must match the param name of
	// the advise method
	@AfterThrowing(pointcut = "execution(public Integer com.spring.aop.service.*.add*(..))", throwing = "throwingException")
	public void afterExceptionLoggingAdd(Throwable throwingException) {
		System.out.println("### LOGGING ADD METHOD : AFTER THROWING ###");

		System.out.println("exception: " + throwingException);
	}

	// around
	// extra doc: https://www.baeldung.com/spring-aop-advice-tutorial
	// advice type which ensures that an advice runs before and after the method
	// execution
	// -ProceedingJoinPoint is used as an argument of the methods which hints for
	// before, after, after throwing and around. ProceedingJoinPoint has the methods
	// like getKind, getTarget, proceed etc
	@Around("execution(public Integer com.spring.aop.service.*.add*(..))")
	public String aroundLoggingAdd(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("### LOGGING ADD METHOD : AROUND ###");
		Object result = jp.proceed();
		System.out.println("### LOGGING ADD METHOD : AROUND ###");
		return result.toString();
	}

}