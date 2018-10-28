package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.service.TestService;

@RestController
public class AopController {
	
	@Autowired
	private TestService testService;
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/getAop")
	public String getAop() throws Exception
	{
		testService.getTestService1();
		testService.getTestService2(new java.util.Date());
		
		demoService.getDemoService1();
		demoService.getDemoService2(new java.util.Date());
		demoService.getDemoService3(new java.util.Date(),"Demo");
		demoService.getDemoService4(new java.util.Date(),"Demo");
		demoService.getDemoService5(new java.util.Date(),"Demo");
		
		return "Aop Example Called";
	}

}
