package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)  /* @Order used for Ordering Aspects : to run sequential order */
@Configuration
public class BeforeAdviceLoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(public void getTestService1())")
	public void beforeAdvicePatter1() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter1");

	}
	
	/*
	 * Match Method With Specific Method Name and Any No Of Method Parameter
	 * Providing modifiers-pattern and return-type-pattern and Method Name
	 */
	
	@Before("execution(public void getTestService2(..))")
	public void beforeAdvicePatter2() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter2");

	}
	
	/*
	 * Match Method With method name start with get and Any No Of Method Parameter
	 * Providing modifiers-pattern and return-type-pattern
	 */
	
	@Before("execution(public void get*(..))")
	public void beforeAdvicePatter3() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter3");

	}
	
	/*
	 * Match Method With Specific Method and Any No Of Method Parameter
	 * 
	 */
	
	@Before("execution(** getTestService2(..))")
	public void beforeAdvicePatter4() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter4");

	}
	
	/*
	 * Match Method With Specific Method Name
	 *
	 */
	
	@Before("execution(* getTestService1())")
	public void beforeAdvicePatter5() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter5");

	}
	
	/*
	 * Match Method With PackageName and Zero No Of Method Parameter
	 *
	 */
	
	@Before("execution(* com.example.demo.*.*())")
	public void beforeAdvicePatter6() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter6");

	}
	
	/*
	 * Match Method With PackageName and Any No Of Method Parameter
	 *
	 */
	
	@Before("execution(* com.example.demo.*.*(..))")
	public void beforeAdvicePatter7() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter7");

	}
	
	/*
	 * Match Method With Parameter
	 * Fully Qualified Parameter Name Required 
	 */
	@Before("execution(* get*(java.util.Date))")
	public void beforeAdvicePatter8() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter8");

	}
	
	
	/*
	 * Match Method With Multi Parameter
	 * Fully Qualified Parameter Name Required 
	 */
	@Before("execution(* get*(java.util.Date,..))")
	public void beforeAdvicePatter9() {
		logger.info("\n BeforeAdviceLoggingAspect executing beforeAdvicePatter9");

	}
}
