package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3) /* @Order used for Ordering Aspects : to run sequential order */
@Configuration
public class JoinPointLoggingAspect {

	/* JoinPoint used for to get metadata about method*/

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * Match Method With Parameter Fully Qualified Parameter Name Required
	 */
	@Before("execution(* get*(java.util.Date))")
	public void joinPointPatter1(JoinPoint jp) {
		logger.info("\n JoinPointLoggingAspect executing joinPointPatter1");
		MethodSignature m = (MethodSignature) jp.getSignature();
		logger.info("\n ****** JoinPoint Method Description : {} ", m);

		Object[] args = jp.getArgs();
		for (Object object : args) {
			logger.info("\n ****** JoinPoint Method ArgumentValue : {} ", object);
		}
	}

	/*
	 * Match Method With Multi Parameter Fully Qualified Parameter Name Required
	 */
	@Before("execution(* get*(java.util.Date,..))")
	public void joinPointPatter2(JoinPoint jp) {
		logger.info("\n JoinPointLoggingAspect executing joinPointPatter2");
		MethodSignature m = (MethodSignature) jp.getSignature();
		logger.info("\n ****** JoinPoint Method Description : {} ", m);

		Object[] args = jp.getArgs();
		for (Object object : args) {

			logger.info("\n ****** JoinPoint Method ArgumentValue : {} ", object);
		}
	}

}
