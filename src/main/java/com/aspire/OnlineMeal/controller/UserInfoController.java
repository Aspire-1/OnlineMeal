package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.publicPOJO.URLUtil2;
import com.aspire.OnlineMeal.service.IUserInfoService;

@RestController
@RequestMapping(value ="/UserInfo")
public class UserInfoController {
	
	private String ruleEmail = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
	private String rulePhone = "^1[0-9]{10}$";
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
	
	@RequestMapping(value="/isExit/loginMessage",method=RequestMethod.POST)
	public ResultMessage isExitWithRegist(String loginMessage,String password) throws Exception{
		ResultMessage result = new ResultMessage();
		UserInfo userInfo = new UserInfo();
		Pattern pEmail = Pattern.compile(ruleEmail);
		Pattern pPhone = Pattern.compile(rulePhone);
		Matcher mEmail = pEmail.matcher(loginMessage);
		Matcher mPhone = pPhone.matcher(loginMessage);
		if(mEmail.matches()){
			userInfo.setRegistEmail(loginMessage);
			System.out.println("匹配邮箱格式");
		}else if(mPhone.matches()){
			userInfo.setRegistPhone(loginMessage);
			System.out.println("匹配手机格式");
		}else{
			userInfo.setUserName(loginMessage);
		}
		if(iuis.isExitWithLoginMessage(userInfo)){
			result.setResult("true");
			result.setMessage("该信息已存在");
		}else{
			result.setResult("false");
			result.setMessage("该信息未存在");
		}
		return result;
	}
	
	//登陆 修改状态
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResultMessage login(String loginMessage,String password,HttpServletRequest request,HttpServletResponse response,BigDecimal marchantId) throws Exception{
		ResultMessage result = new ResultMessage();
		Pattern pEmail = Pattern.compile(ruleEmail);
		Pattern pPhone = Pattern.compile(rulePhone);
		Matcher mEmail = pEmail.matcher(loginMessage);
		Matcher mPhone = pPhone.matcher(loginMessage);
		UserInfo userInfo = new UserInfo();
		if(mEmail.matches()){
			userInfo.setRegistEmail(loginMessage);
			System.out.println("匹配邮箱格式");
		}else if(mPhone.matches()){
			userInfo.setRegistPhone(loginMessage);
			System.out.println("匹配手机格式");
		}else{
			userInfo.setUserName(loginMessage);
		}
		//获取对象
		UserInfo user = iuis.searchByLoginMessage(userInfo);
		//修改登陆状态
		iuis.login(userInfo);
		result.setResult("Y");
		result.setMessage("登陆成功");
		result.setObject(user);
		return result;
	}
	
	//登出
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public ResultMessage logout(UserInfo user) throws Exception{
		ResultMessage result = new ResultMessage();
		iuis.logout(user);
		result.setResult("Y");
		result.setMessage("已退出账号");
		return result;
	}
	
	@RequestMapping(value="/getOpenId",method=RequestMethod.POST)
	public String getOpenId(String code) throws Exception{
		String wxCode = code;
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";  //请求地址 https://api.weixin.qq.com/sns/jscode2session  
        Map<String,String> requestUrlParam = new HashMap<String,String>(); 
        String appId="wxebecb8bf38bafe93";
        String appSecret = "38cdd352e8c31668bb0d498de1c3a17a";
        requestUrlParam.put("appid", appId);  //开发者设置中的appId  
        requestUrlParam.put("secret", appSecret); //开发者设置中的appSecret  
        requestUrlParam.put("js_code", wxCode); //小程序调用wx.login返回的code  
        requestUrlParam.put("grant_type", "authorization_code");    //默认参数
        String openid = URLUtil2.sendPost(requestUrl,requestUrlParam);
        
        return openid;
	}
	
	@RequestMapping(value="/login/withWeChat",method=RequestMethod.POST)
	public ResultMessage loginWeChat(UserInfo user) throws Exception{
		ResultMessage result = new ResultMessage();
		UserInfo exitUser = iuis.searchByOpenId(user.getOpenId());
		if(exitUser!=null){
			iuis.modifyByUserIdSelective(user);
			result.setResult("gx");
			result.setMessage("更新用户数据成功");
			result.setObject(exitUser);
		}else{
			iuis.addWithSelective(user);
			result.setResult("zj");
			result.setMessage("增加用户数据成功");
			result.setObject(iuis.searchByOpenId(user.getOpenId()));
		}
		return result;
	}
	
}
