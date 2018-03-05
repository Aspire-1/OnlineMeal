package com.aspire.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.test.mapper.ITestUserMapper;
import com.aspire.test.model.TestUser;
import com.aspire.test.service.ITestUserService;

@Service("TestUserService")
public class TestUserService implements ITestUserService {
	
	@Autowired
	private ITestUserMapper itum = null;
	
	public void insert(TestUser testUser) throws Exception {
		itum.insert(testUser);
	}
	
}
