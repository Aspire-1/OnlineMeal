package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.AddressInfo;

public interface IUserAddressService {
	
	public int deleteByAddressId(BigDecimal id) throws Exception;
	public int add(AddressInfo addressInfo) throws Exception;
	public List<AddressInfo> getByUserId(BigDecimal id) throws Exception;
	public int modifyByAddressId(AddressInfo addressInfo) throws Exception;
	
}
