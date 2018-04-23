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

	@Override
	//通过OpenId获取用户信息并校验数据
	public boolean validateWithOpenId(String openId,String userName,String password) throws Exception {
		UserInfo user = uim.selectByUserOpenId(openId);
		if(user!=null && userName!=null && userName.equals(user.getUserName())){
			if(password != null && password.equals(user.getPassword())){
				return true;
			}
		}
		return false;
	}

	@Override
	public UserInfo searchByLoginMessage(UserInfo userInfo) throws Exception {
		return uim.selectByLoginMessage(userInfo);
	}

	@Override
	public boolean validateWithLoginMessage(UserInfo userInfo, String password) throws Exception {
		UserInfo user = uim.selectByLoginMessage(userInfo);
		if(user!=null && password.equals(user.getPassword())){
			return true;
		}
		return false;
	}
	
	
}
