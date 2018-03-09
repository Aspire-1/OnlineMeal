package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;

import com.aspire.OnlineMeal.model.UserInfo;

public interface IUserInfoService {
	public int add(UserInfo userInfo);
	
	public int addWithSelective(UserInfo userInfo);
	
	public UserInfo searchByUserID(BigDecimal id);
	
	
}
