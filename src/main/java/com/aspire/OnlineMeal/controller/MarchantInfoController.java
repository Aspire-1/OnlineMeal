package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.MarchantInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IMarchantInfoService;

@RestController
@RequestMapping(value = "/MarchantInfo")
public class MarchantInfoController {

	@Autowired
	private IMarchantInfoService imis = null;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(MarchantInfo marchantInfo) throws Exception {

		ResultMessage result = new ResultMessage();

		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		marchantInfo.setRegistTime(sdf.format(new Date()));

		imis.add(marchantInfo);

		result.setResult("Y");
		result.setMessage("添加商家信息成功");

		return result;

	}

	@RequestMapping(value="/add/selective",method=RequestMethod.POST)
	public ResultMessage addWithSelective(MarchantInfo marchantInfo) throws Exception {

		ResultMessage result = new ResultMessage();

		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		marchantInfo.setRegistTime(sdf.format(new Date()));

		imis.addWithSelective(marchantInfo);

		result.setResult("Y");
		result.setMessage("添加商家信息成功");

		return result;

	}
	
	@RequestMapping(value="/modify/state")
	public ResultMessage modifyMarchantState(MarchantInfo marchantInfo) throws Exception{
		
		ResultMessage result = new ResultMessage();
		
		//前端传过指定的状态值来更改状态 例如 01 正常 02 休息中 03 接单中
		imis.modifyMarthantState(marchantInfo);
		
		result.setResult("Y");
		result.setMessage("修改商家状态成功");
		
		return result;
		
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public MarchantInfo getById(BigDecimal id) throws Exception{
		return imis.getByPrimaryKey(id);
	}
	
	
}
