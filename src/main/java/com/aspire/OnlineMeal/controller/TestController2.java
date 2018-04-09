package com.aspire.OnlineMeal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import com.aspire.OnlineMeal.publicPOJO.Message;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.publicPOJO.URLUtil2;
import com.aspire.OnlineMeal.webSocket.MyWebSocketHandler;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value="/TestController")
public class TestController2 {
	
	@RequestMapping(value="/testLogin",method=RequestMethod.GET)
	public String loginTest(HttpServletRequest request,HttpServletResponse response,String id,String type) throws Exception{
		//用户登陆之后要存储信息到httpSession中
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("type", type);
		RequestDispatcher rd = null;
		//使用转发的方式进行跳转 此时页面中存在session的值
		if("user".equals(type)){
			rd=request.getRequestDispatcher("/userOrder.html");
			rd.forward(request, response);
		}else if("marchant".equals(type)){
			rd=request.getRequestDispatcher("/marchantOrder.html");
			rd.forward(request, response);
		}
		return "404";
	}
	
	
	@RequestMapping(value="/test")
	public ResultMessage test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ResultMessage result = new ResultMessage();
		result.setMessage("测试连通");
		result.setResult("Y");
		return result;
	}
	
	@RequestMapping(value="/getOpenId")
	public String getOpenId(String code){
		String wxCode = code;
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";  //请求地址 https://api.weixin.qq.com/sns/jscode2session  
        Map<String,String> requestUrlParam = new HashMap<String,String>(); 
        String appId="wxebecb8bf38bafe93";
        String appSecret = "38cdd352e8c31668bb0d498de1c3a17a";
        requestUrlParam.put("appid", appId);  //开发者设置中的appId  
        requestUrlParam.put("secret", appSecret); //开发者设置中的appSecret  
        requestUrlParam.put("js_code", wxCode); //小程序调用wx.login返回的code  
        requestUrlParam.put("grant_type", "authorization_code");    //默认参数  
        return URLUtil2.sendPost(requestUrl,requestUrlParam);
	}
	
}
