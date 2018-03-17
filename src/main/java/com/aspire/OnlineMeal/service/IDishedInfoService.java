package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.DishedInfo;

public interface IDishedInfoService {
	//添加菜肴信息
	public int addDished(DishedInfo dishedInfo) throws Exception;
	//添加菜肴信息(可选信息)
	public int addDishedWithSelective(DishedInfo dishedInfo) throws Exception;
	//删除菜肴信息
	public int deleteDished(BigDecimal id) throws Exception;
	//修改菜肴信息
	public int modifyDished(DishedInfo dishedInfo) throws Exception;
	//按菜肴类型查找菜肴信息
	public List<DishedInfo> getDishedWithDishedType(String dishedType) throws Exception;
	//按菜肴名称模糊查找菜肴信息
	public List<DishedInfo> getWithVagueName(String targe) throws Exception;
}
