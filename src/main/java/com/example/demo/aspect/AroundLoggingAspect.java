package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(10) /* @Order used for Ordering Aspects : to run sequential order */
@Configuration
public class AroundLoggingAspect {

	/* PointcutExpressions reuse with advices */

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * Match Method With Multi Parameter Fully Qualified Parameter Name Required
	 */
	@Around("execution(* get*(java.util.Date,..))")
	public void aroundPatter1(ProceedingJoinPoint pjp) {
		logger.info("AroundLoggingAspect executing aroundPatter1");

		logger.info("=====> @Around BEFORE METHOD CALLLED");

		MethodSignature m = (MethodSignature) pjp.getSignature();
		logger.info("=====> JoinPoint Method Description : {} ", m);

		Object[] args = pjp.getArgs();
		for (Object object : args) {

			logger.info("=====> JoinPoint Method ArgumentValue : {} ", object);
		}

		try {
			pjp.proceed();

		} catch (Exception e) {
		} catch (Throwable e) {
			
			e.printStackTrace();
		}

		logger.info("=====> @Around AFTER METHOD CALLLED");

		logger.info("=====> JoinPoint Method Final Result : {} ", pjp.getSignature());

	}

}
