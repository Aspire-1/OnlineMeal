package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.DishedType;

public interface IDishedTypeService {
	//添加菜肴类型
	public int add(DishedType dishedType) throws Exception;
	//添加菜肴类型(可选项)
	public int addWithSelective(DishedType dishedType) throws Exception;
	//删除菜肴类型
	public int deleteDishedType(BigDecimal id) throws Exception;
	//查询所有的菜肴类型
	public List<DishedType> getAll() throws Exception;
	
}
