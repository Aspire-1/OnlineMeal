package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.AddressInfoMapper;
import com.aspire.OnlineMeal.model.AddressInfo;
import com.aspire.OnlineMeal.service.IUserAddressService;

@Service("UserAddressService")
public class UserAddressServiceImpl implements IUserAddressService {

	@Autowired
	private AddressInfoMapper adi = null;
	
	@Override
	public int deleteByAddressId(BigDecimal id) throws Exception {
		return adi.deleteByPrimaryKey(id);
	}

	@Override
	public int add(AddressInfo addressInfo) throws Exception {
		return adi.insert(addressInfo);
	}

	@Override
	public List<AddressInfo> getByUserId(BigDecimal userId) throws Exception {
		return adi.selectByUserId(userId);
	}

	@Override
	public int modifyByAddressId(AddressInfo addressInfo) throws Exception {
		return adi.updateByPrimaryKey(addressInfo);
	}

}
