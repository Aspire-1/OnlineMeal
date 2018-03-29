package com.aspire.OnlineMeal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.publicPOJO.URLUtil2;

@RestController
@RequestMapping(value="/TestController")
public class TestController2 {
	
	@RequestMapping(value="/test")
	public ResultMessage test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ResultMessage result = new ResultMessage();
		result.setMessage("测试连通");
		result.setResult("Y");
		response.sendRedirect("");
		return result;
	}
	
	@RequestMapping(value="/getOpenId")
	public String getOpenId(String code){
		String wxCode = code;
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";  //请求地址 https://api.weixin.qq.com/sns/jscode2session  
        Map<String,String> requestUrlParam = new HashMap<String,String>(); 
        String appId="";
        String appSecret = "";
        requestUrlParam.put("appid", appId);  //开发者设置中的appId  
        requestUrlParam.put("secret", appSecret); //开发者设置中的appSecret  
        requestUrlParam.put("js_code", wxCode); //小程序调用wx.login返回的code  
        requestUrlParam.put("grant_type", "authorization_code");    //默认参数  
        return URLUtil2.sendPost(requestUrl,requestUrlParam);
	}
	
}
