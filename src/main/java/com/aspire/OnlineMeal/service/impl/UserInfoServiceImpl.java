package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.UserInfoMapper;
import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.service.IUserInfoService;

@Service("UserInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private UserInfoMapper uim = null;
	
	@Override
	public int add(UserInfo userInfo) {
		uim.insert(userInfo);
		return 1;
	}

	@Override
	public int addWithSelective(UserInfo userInfo) {
		uim.insertSelective(userInfo);
		return 1;
	}

	@Override
	public UserInfo searchByUserID(BigDecimal id) {
		return uim.selectByPrimaryKey(id);
	}
	
}
