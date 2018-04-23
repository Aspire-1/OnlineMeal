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
	//根据用户名或邮箱或手机号查找用户
	public UserInfo searchByLoginMessage(UserInfo userInfo) throws Exception;
	//通过主键id更新数据(选择性)
	public int modifyByUserIdSelective(UserInfo userInfo) throws Exception;
	//通过openid更新数据(选择性)
	public int modifyByOpenIdSelective(UserInfo userInfo) throws Exception;
	//根据openId校验用户密码
	public boolean validateWithOpenId(String openId,String userName,String password) throws Exception;
	//根据用户登陆信息校验用户密码
	public boolean validateWithLoginMessage(UserInfo userInfo,String password) throws Exception;
	//根据校验用户的用户名或是手机号或是邮箱是否存在
	public boolean isExitWithLoginMessage(UserInfo userInfo) throws Exception;
}
