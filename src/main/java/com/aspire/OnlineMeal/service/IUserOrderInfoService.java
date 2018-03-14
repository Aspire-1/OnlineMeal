package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.model.UserOrderInfo;

public interface IUserOrderInfoService {
	
	//增加订单
	public int addUserOrderInfoWithSelective(UserOrderInfo uoi) throws Exception;
	
	//取消订单 将订单状态置为取消状态 不为删除订单操作
	public int deleteUserOrderInfo(UserOrderInfo uoi) throws Exception;
	
	//获取订单的详情
	public UserOrderInfo getOrderDetailByOrderInfoId(BigDecimal id) throws Exception;
	
	//查询用户所有的订单
	public List<UserOrderInfo> getAllOrderByUserID(BigDecimal id) throws Exception;
}
