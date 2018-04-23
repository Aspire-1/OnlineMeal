package com.aspire.OnlineMeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.MarchantManager;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IMarchantManagerService;

@RestController
@RequestMapping(value = "/MarchantManager")
public class MarchantManagerController {
	
	@Autowired
	private IMarchantManagerService imms = null;
	
	@RequestMapping(value="/add/selective",method=RequestMethod.POST)
	public ResultMessage addSelective(MarchantManager manager) throws Exception{
		ResultMessage result = new ResultMessage();
		imms.addSelective(manager);
		result.setResult("Y");
		result.setMessage("添加管理员信息成功");
		return result;
	}
	
	@RequestMapping(value="/isExit")
	public ResultMessage isExit(String phone) throws Exception{
		ResultMessage result = new ResultMessage();
		if(imms.isExit(phone)){
			result.setResult("Y");
			result.setMessage("该手机号已存在");
		}else{
			result.setResult("N");
			result.setMessage("该手机号未被注册");
		}
		return result;
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResultMessage validatePassword(String phone,String password) throws Exception{
		ResultMessage result = new ResultMessage();
		if(imms.validateLogin(phone, password)){
			result.setResult("Y");
			result.setMessage("手机密码校验正确");
		}else{
			result.setResult("N");
			result.setMessage("手机或密码错误");
		}
		return result;
	}
}
