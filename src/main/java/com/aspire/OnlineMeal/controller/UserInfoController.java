package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	@RequestMapping(value="/get/userId",method=RequestMethod.POST)
	public UserInfo getById(BigDecimal id) throws Exception{
		return iuis.searchByUserID(id);
	}
	
	@RequestMapping(value="/get/openId",method=RequestMethod.POST)
	public UserInfo getByOpenId(String openId) throws Exception{
		return iuis.searchByOpenId(openId);
	}
	
	@RequestMapping(value="/modify/userId",method=RequestMethod.POST)
	public ResultMessage modifyByUserId(UserInfo userInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		iuis.modifyByUserIdSelective(userInfo);
		result.setResult("Y");
		result.setMessage("修改信息成功");
		return result;
	}
	
	@RequestMapping(value="/modify/openId",method=RequestMethod.POST)
	public ResultMessage modifyByOpenId(UserInfo userInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		//记住传入的值是openid
		iuis.modifyByOpenIdSelective(userInfo);
		result.setResult("Y");
		result.setMessage("修改信息成功");
		return result;
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResultMessage validateWithOpenId(String openId,String userName,String password) throws Exception{
		ResultMessage result = new ResultMessage();
		if(iuis.validateWithOpenId(openId, userName, password)){
			result.setResult("true");
			result.setMessage("校验用户名密码正确");
		}else{
			result.setResult("false");
			result.setMessage("用户名或密码错误");
		}
		return result;
	}
	
	@RequestMapping(value="/validate/loginMessage",method=RequestMethod.POST)
	public ResultMessage validateWithLogin(String loginMessage,String password) throws Exception{
		ResultMessage result = new ResultMessage();
		UserInfo userInfo = new UserInfo();
		String ruleEmail = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		String rulePhone = "^1[0-9]{10}$";
		Pattern pEmail = Pattern.compile(ruleEmail);
		Pattern pPhone = Pattern.compile(rulePhone);
		Matcher mEmail = pEmail.matcher(loginMessage);
		Matcher mPhone = pPhone.matcher(loginMessage);
		if(mEmail.matches()){
			userInfo.setRegistEmail(loginMessage);
		}else if(mPhone.matches()){
			userInfo.setRegistPhone(loginMessage);
		}else{
			userInfo.setUserName(loginMessage);
		}
		if(iuis.validateWithLoginMessage(userInfo, password)){
			result.setResult("true");
			result.setMessage("校验用户名密码正确");
		}else{
			result.setResult("false");
			result.setMessage("用户名或密码错误");
		}
		return result;
	}
	
}
