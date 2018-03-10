package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.AddressInfo;
import java.math.BigDecimal;
import java.util.List;

public interface AddressInfoMapper {
	int deleteByPrimaryKey(BigDecimal id) throws Exception;

	int insert(AddressInfo record) throws Exception;

	int insertSelective(AddressInfo record) throws Exception;

	AddressInfo selectByPrimaryKey(BigDecimal id) throws Exception;
	
	List<AddressInfo> selectByUserId(BigDecimal userId) throws Exception;

	int updateByPrimaryKeySelective(AddressInfo record) throws Exception;

	int updateByPrimaryKey(AddressInfo record) throws Exception;
}