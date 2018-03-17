package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.DishedInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IDishedInfoService;

@RestController
@RequestMapping(value="/DishedInfo")
public class DishedInfoController {
	
	@Autowired
	private IDishedInfoService idis = null;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(DishedInfo dishedInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idis.addDished(dishedInfo);
		result.setResult("Y");
		result.setMessage("添加菜肴信息成功");
		
		return result;
		
	}
	
	@RequestMapping(value="/add/selective",method=RequestMethod.POST)
	public ResultMessage addWithSelective(DishedInfo dishedInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idis.addDishedWithSelective(dishedInfo);
		result.setResult("Y");
		result.setMessage("添加菜肴信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultMessage deleteDished(BigDecimal id) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idis.deleteDished(id);
		result.setResult("Y");
		result.setMessage("删除菜肴信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultMessage modifyDished(DishedInfo dishedInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idis.modifyDished(dishedInfo);
		result.setResult("Y");
		result.setMessage("修改菜肴信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/get/byDishedType",method=RequestMethod.POST)
	//根据类型编号查找
	public List<DishedInfo> getDishedWithDishedType(String dishedType) throws Exception{
		return idis.getDishedWithDishedType(dishedType);
	}
	
	@RequestMapping(value="/get/vagueName",method=RequestMethod.POST)
	public List<DishedInfo> getWithVagueName(String target) throws Exception{
		System.out.println(target);
		return idis.getWithVagueName(target);
	}
	
	
}
