package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.OrderInfo;

public interface IOrderInfoService {
	
	//添加订单内容
	public int addOrderInfo(OrderInfo orderInfo) throws Exception;
	
	//删除订单内容
	public int deleteOrderInfo(OrderInfo orderInfo) throws Exception;
	
	//查找菜肴，通过用户订单主键查找订单信息
	public List<OrderInfo> getAllOrderInfoByUserOrderId(BigDecimal userOrderId) throws Exception;
}
