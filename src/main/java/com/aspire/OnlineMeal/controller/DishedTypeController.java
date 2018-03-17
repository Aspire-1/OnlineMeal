package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.DishedType;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IDishedTypeService;

@RestController
@RequestMapping(value="/DishedType")
public class DishedTypeController {
	
	@Autowired
	private IDishedTypeService idts = null;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(DishedType dishedType) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idts.add(dishedType);		
		result.setResult("Y");
		result.setMessage("添加菜肴类型成功");
		
		return result;
	}
	
	@RequestMapping(value="/add/selective",method=RequestMethod.POST)
	public ResultMessage addWithSelective(DishedType dishedType) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idts.addWithSelective(dishedType);		
		result.setResult("Y");
		result.setMessage("添加菜肴类型成功");
		
		return result;
	}
	
	@RequestMapping(value="/get/All",method=RequestMethod.GET)
	public List<DishedType> getAll() throws Exception{
		return idts.getAll();
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultMessage deleteDishedType(BigDecimal id) throws Exception{
		ResultMessage result = new ResultMessage();
		
		idts.deleteDishedType(id);
		
		result.setResult("Y");
		result.setMessage("删除菜肴类型成功");
		
		return result;
	}
	
	
	
}
