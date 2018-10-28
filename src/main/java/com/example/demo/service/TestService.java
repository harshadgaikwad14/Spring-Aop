package com.example.demo.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TestService {

	public void getTestService1() {

		System.out.println(getClass() + ": Called TestService - getTestService1() : ");

	}

	public void getTestService2(final Date date) {

		System.out.println(getClass() + ": Called TestService - getTestServic2() : " + date);

	}
}
