package com.aspire.test.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aspire.test.model.TestUser;
import com.aspire.test.service.ITestUserService;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("context.xml");
		
		ITestUserService itus = (ITestUserService) ac.getBean("TestUserService");
		
		TestUser testUser = new TestUser();
		testUser.setName("Hello33");
		testUser.setAge(12);
		
		itus.insert(testUser);
		
	}
}
