package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(10) /* @Order used for Ordering Aspects : to run sequential order */
@Configuration
public class AfterThrowingLoggingAspect {

	/* PointcutExpressions reuse with advices */

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
		
	/*
	 * Match Method With Multi Parameter Fully Qualified Parameter Name Required
	 */
	@AfterThrowing(pointcut= "execution(* get*(java.util.Date,..))",throwing="ex")
	public void afterThrowingPatter1(JoinPoint jp,Exception ex) {
		logger.info("AfterThrowingLoggingAspect executing afterThrowingPatter1");
		MethodSignature m = (MethodSignature) jp.getSignature();
		logger.info("=====> JoinPoint Method Description : {} ", m);

		Object[] args = jp.getArgs();
		for (Object object : args) {

			logger.info("=====> JoinPoint Method ArgumentValue : {} ", object);
		}
		logger.info("=====> Method Exception Name : {} ", ex.getMessage());
	}

}
