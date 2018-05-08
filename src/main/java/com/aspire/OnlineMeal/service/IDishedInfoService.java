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
	//根据主键获取菜肴信息
	public DishedInfo getByPrimaryKey(BigDecimal id) throws Exception;
	//获取所有的菜肴信息
	public List<DishedInfo> getAll(BigDecimal marchantId) throws Exception;
	//按菜肴类型查找菜肴信息
	public List<DishedInfo> getDishedWithDishedType(DishedInfo dishedInfo) throws Exception;
	//按菜肴名称模糊查找菜肴信息
	public List<DishedInfo> getWithVagueName(DishedInfo dishedInfo) throws Exception;
	//分页查找所有的菜肴信息
	public List<DishedInfo> getAllWithPage(int rows,int page,BigDecimal marchantId) throws Exception;
	//获取某商家的菜肴信息记录数
	public int getCountByAll(BigDecimal marchantId) throws Exception;
	//获取某商家菜肴信息的总页数
	public int getPageCountByAll(int rows,BigDecimal marchantId) throws Exception;
}
