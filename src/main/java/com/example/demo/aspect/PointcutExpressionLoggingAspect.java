package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1) /* @Order used for Ordering Aspects : to run sequential order */
@Configuration
public class PointcutExpressionLoggingAspect {
	
	/*PointcutExpressions reuse with advices*/
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* getTest*())")
	private void pointcutExpression1() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpression1");

	}
	
	@Pointcut("execution(* getDemo*())")
	private void pointcutExpression2() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpression2");

	}

	@Before("pointcutExpression1()")
	private void pointcutExpressionWithBeforeAdvicePatter1() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpressionWithBeforeAdvicePatter1");

	}
	
	@Before("pointcutExpression2()")
	private void pointcutExpressionWithBeforeAdvicePatter2() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpressionWithBeforeAdvicePatter2");

	}
	
	
	/*
	 * Combined Pointcut Expression With Logical Operators (&&  and  || and  !)
	 */
	
	@Before("pointcutExpression1() && pointcutExpression2()")
	private void pointcutExpressionWithBeforeAdvicePatter3() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpressionWithBeforeAdvicePatter3");

	}
	
	@Before("pointcutExpression1() || pointcutExpression2()")
	private void pointcutExpressionWithBeforeAdvicePatter4() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpressionWithBeforeAdvicePatter4");

	}
	
	@Before("pointcutExpression1() && !pointcutExpression2()")
	private void pointcutExpressionWithBeforeAdvicePatter5() {
		logger.info("\n PointcutExpressionLoggingAspect executing pointcutExpressionWithBeforeAdvicePatter5");

	}


	
	
}
