package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.OrderInfo;
import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.model.UserOrderInfo;

public interface IUserOrderInfoService {
	//增加订单
	public BigDecimal addUserOrderInfoWithSelective(UserOrderInfo uoi) throws Exception;
	//获取主键
	public BigDecimal getPrimaryKey() throws Exception;
	//取消订单 将订单状态置为取消状态 不为删除订单操作
	public int deleteUserOrderInfo(UserOrderInfo uoi) throws Exception;
	//修改用户订单状态
	public int modifyUserOrderState(UserOrderInfo uoi) throws Exception;
	//根据主键获取订单
	public UserOrderInfo getByPriamryKey(BigDecimal id) throws Exception;
	//获取订单的详情
	public UserOrderInfo getOrderDetailByOrderInfoId(BigDecimal id) throws Exception;
	//查询用户所有的订单
	public List<UserOrderInfo> getAllOrderByUserID(BigDecimal id) throws Exception;
	//查询商家所有的订单
	public List<UserOrderInfo> getAllOrderByMarchantId(BigDecimal marchantId) throws Exception;
	//查询用户所有的订单数
	public int getOrderCountByUserId(BigDecimal id) throws Exception;
	//查询商家所有的订单数
	public int getOrderCountByMarchantId(BigDecimal id) throws Exception;
	//根据电话查找用户订单
	public List<UserOrderInfo> getUserOrderWithPhone(String phone,BigDecimal marchantId,int rows,int page) throws Exception;
	//根据电话查找的用户订单总数
	public int getOrderCountWithPhone(String phone,BigDecimal marchantId) throws Exception;
	//根据电话查找获取用户订单总页数
	public int getAllPageByPhone(int rows,BigDecimal marchantId,String phone) throws Exception;
	//分页查找用户订单
	public List<UserOrderInfo> getUserOrderWithPageByUserId(int rows,int page,BigDecimal userId) throws Exception;
	//分页查找商家订单
	public List<UserOrderInfo> getUserOrderWithPageByMarchantId(int rows,int page,BigDecimal marchantId) throws Exception;
	//获取用户订单的总页数
	public int getAllPageByUserId(int rows,BigDecimal userId) throws Exception;
	//获取商家订单的总页数
	public int getAllPageByMarchantId(int rows,BigDecimal marchantId) throws Exception;
	//根据时间获取商家订单
	public List<UserOrderInfo> getUserOrderByMarchantIdWithTime(String startTime,String endTime,BigDecimal marchantId,int rows,int page) throws Exception;
	//根据时间获取商家订单的总数
	public int getOrderCountByMarchantIdWithTime(String startTime,String endTime,BigDecimal marchantId) throws Exception;
	//根据时间获取商家订单的总页数
	public int getAllPageByTime(int rows,String startTime,String endTime,BigDecimal marchantId) throws Exception;
	//根据付款状态获取商家
	public List<UserOrderInfo> getUserOrderByPayState(String payState,BigDecimal marchantId,int rows,int page) throws Exception;
	//根据付款状态获取商家的总数
	public int getUserOrderCountByPayState(String payState,BigDecimal marchantId) throws Exception;
	//根据付款状态获取商家的总页数
	public int getAllPageByPayState(int rows,String payState,BigDecimal marchantId) throws Exception;
}
