package com.example.demo.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DemoService {

	public void getDemoService1() {

		System.out.println(getClass() + ": Called DemoService - getDemoService1() : ");

	}

	public void getDemoService2(final Date date) {

		System.out.println(getClass() + ": Called DemoService - getDemoService2() : " + date);

	}
	
	
	public void getDemoService3(final Date date,final String name) {

		System.out.println(getClass() + ": Called DemoService - getDemoService3() : " + date);

	}
	
	public String getDemoService4(final Date date,final String name) {

		System.out.println(getClass() + ": Called DemoService - getDemoService4() : " + date);
		return date+"---"+name;

	}
	
	public String getDemoService5(final Date date,final String name) throws Exception {

		System.out.println(getClass() + ": Called DemoService - getDemoService5() : " + date);
		
		System.out.println(1/0);
	
		
		return date+"---"+name;

	}
}
