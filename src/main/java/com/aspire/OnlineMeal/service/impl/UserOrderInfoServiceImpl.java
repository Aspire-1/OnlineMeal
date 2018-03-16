package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.UserOrderInfoMapper;
import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.model.UserOrderInfo;
import com.aspire.OnlineMeal.service.IUserOrderInfoService;

@Service("UserOrderInfoService")
public class UserOrderInfoServiceImpl implements IUserOrderInfoService {
	
	@Autowired
	private UserOrderInfoMapper uoim = null;
	
	@Override
	public int addUserOrderInfoWithSelective(UserOrderInfo uoi) throws Exception {
		return uoim.insertSelective(uoi);
	}

	@Override
	public int deleteUserOrderInfo(UserOrderInfo uoi) throws Exception {
		return uoim.updateTheUserOrderState(uoi);
	}

	@Override
	public UserOrderInfo getOrderDetailByOrderInfoId(BigDecimal id) throws Exception {
		return uoim.selectByPrimaryKey(id);
	}

	@Override
	public List<UserOrderInfo> getAllOrderByUserID(BigDecimal id) throws Exception {
		return uoim.selectByUserId(id);
	}

	@Override
	public int getPrimaryKey() throws Exception {
		return uoim.selectCurrentSeq();
	}

}
