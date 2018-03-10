package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;

import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;

public interface IUserInfoService {
	public int add(UserInfo userInfo) throws Exception ;
	
	public int addWithSelective(UserInfo userInfo) throws Exception;
	
	public UserInfo searchByUserID(BigDecimal id) throws Exception;
	
	
}
