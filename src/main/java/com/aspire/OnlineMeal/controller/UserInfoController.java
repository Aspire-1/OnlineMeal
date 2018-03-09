package com.aspire.OnlineMeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.service.IUserInfoService;

@RestController
@RequestMapping(value ="/UserInfo")
public class UserInfoController {
	
	@Autowired
	private IUserInfoService iuis=null;
	
	@RequestMapping(value ="/add",method=RequestMethod.POST)
	public void add(UserInfo userInfo) {
		iuis.add(userInfo);
	}
	
	@RequestMapping(value ="/add/selective",method=RequestMethod.POST)
	public void addWithSelective(UserInfo userInfo){
		iuis.addWithSelective(userInfo);
		
	}
	
}
