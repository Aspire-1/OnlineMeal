package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.UserInfoMapper;
import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IUserInfoService;

@Service("UserInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private UserInfoMapper uim = null;
	
	@Override
	public int add(UserInfo userInfo) throws Exception {
		return uim.insert(userInfo);
	}

	@Override
	public int addWithSelective(UserInfo userInfo) throws Exception {
		return uim.insertSelective(userInfo);
	}

	@Override
	public UserInfo searchByUserID(BigDecimal id) throws Exception {
		return uim.selectByPrimaryKey(id);
	}

	@Override
	public UserInfo searchByOpenId(String openId) throws Exception {
		return uim.selectByUserOpenId(openId);
	}

	@Override
	public int modifyByUserIdSelective(UserInfo userInfo) throws Exception {
		return uim.updateByPrimaryKeySelective(userInfo);
	}

	@Override
	public int modifyByOpenIdSelective(UserInfo userInfo) throws Exception {
		return uim.updateByOpenIdSelective(userInfo);
	}
	
	
}
