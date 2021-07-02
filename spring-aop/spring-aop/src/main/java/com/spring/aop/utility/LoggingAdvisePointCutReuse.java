package com.spring.aop.utility;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//pointcut declarations for reuse and combination demo
@Aspect
@Component
public class LoggingAdvisePointCutReuse {
	
	// pointcut templates to be reused
	@Pointcut("execution(public Integer com.spring.aop.service.*.delete*(..))")
	public void myPointCutTemplateforDelete() {}
	
	@Pointcut("execution(public Integer com.spring.aop.service.*.update*(..))")
	public void myPointCutTemplateforUpdate() {}
	
	// advises
	@Before("myPointCutTemplateforDelete()")
	public void AfterDeleteLogging() {
		System.out.println("### LOGGING DELETE METHOD : BEFORE ###");
	}
	
	@After("myPointCutTemplateforDelete() || myPointCutTemplateforUpdate()")
	public void AfterUpdateLogging() {
		System.out.println("### LOGGING DELETE OR UPDATE METHOD : AFTER ###");
	}
}