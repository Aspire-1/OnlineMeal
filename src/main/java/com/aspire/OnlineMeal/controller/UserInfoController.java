package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IUserInfoService;

@RestController
@RequestMapping(value ="/UserInfo")
public class UserInfoController {
	
	@Autowired
	private IUserInfoService iuis=null;
	
	@RequestMapping(value ="/add",method=RequestMethod.POST)
	public ResultMessage add(UserInfo userInfo) throws Exception {
		
		ResultMessage rMessage = new ResultMessage();
		
		iuis.add(userInfo);
		rMessage.setResult("Y");
		rMessage.setMessage("用户详细注册成功");
		return rMessage;
	}
	
	@RequestMapping(value ="/add/selective",method=RequestMethod.POST)
	public ResultMessage addWithSelective(UserInfo userInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		userInfo.setRegistTime(sdf.format(new Date()));
		iuis.addWithSelective(userInfo);
		result.setMessage("用户简易注册成功");
		result.setResult("Y");
		
		return result;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public UserInfo getById(BigDecimal id) throws Exception{
		return iuis.searchByUserID(id);
	}
	
}
