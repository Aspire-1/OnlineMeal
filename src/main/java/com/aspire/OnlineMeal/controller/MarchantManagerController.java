package com.aspire.OnlineMeal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping(value="/modify/pwd",method=RequestMethod.POST)
	public ResultMessage modifyManagerPwd(String phone,String oldPwd,String newPwd) throws Exception{
		ResultMessage result = new ResultMessage();
		if(imms.modifyManagerPwd(oldPwd, newPwd, phone)!=-1){
			result.setResult("Y");
			result.setMessage("密码修改成功");
		}else{
			result.setResult("N");
			result.setMessage("密码修改失败");
		}
		return result;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResultMessage login(String phone,String password,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ResultMessage result = new ResultMessage();
		
		MarchantManager manager = imms.getByPhone(phone);
		//商家管理员登陆状态  01 在线  02 下线
		manager.setManagerLoginStates("01");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		manager.setManagerLastloginTime(sdf.format(date));
		imms.modifyManager(manager);
		result.setResult("Y");
		result.setMessage("登陆成功");
		result.setObject(manager);
		return result;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public ResultMessage logout(MarchantManager manager) throws Exception{
		ResultMessage result = new ResultMessage();
		manager.setManagerLoginStates("02");
		imms.modifyManager(manager);
		result.setMessage("成功下线");
		result.setResult("Y");
		return result;
		
	}
	
}
