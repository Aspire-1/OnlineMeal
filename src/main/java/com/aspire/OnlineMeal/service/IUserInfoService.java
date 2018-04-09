package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;

import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;

public interface IUserInfoService {
	//添加用户信息
	public int add(UserInfo userInfo) throws Exception ;
	//添加用户信息(选择性)
	public int addWithSelective(UserInfo userInfo) throws Exception;
	//通过userId查找用户信息
	public UserInfo searchByUserID(BigDecimal id) throws Exception;
	//通过openId查找用户信息
	public UserInfo searchByOpenId(String openId) throws Exception;
	//通过主键id更新数据(选择性)
	public int modifyByUserIdSelective(UserInfo userInfo) throws Exception;
	//通过openid更新数据(选择性)
	public int modifyByOpenIdSelective(UserInfo userInfo) throws Exception;
	
}
