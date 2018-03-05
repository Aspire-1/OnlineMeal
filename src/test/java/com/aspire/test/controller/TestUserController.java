package com.aspire.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.test.model.TestUser;
import com.aspire.test.service.ITestUserService;

@RestController
@RequestMapping(value="/testUser")
public class TestUserController {
	@Autowired
	private ITestUserService itus = null;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(TestUser testUser) throws Exception{
		itus.insert(testUser);
	}
	
}
