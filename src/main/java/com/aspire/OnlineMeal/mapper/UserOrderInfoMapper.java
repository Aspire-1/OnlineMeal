package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.UserOrderInfo;
import java.math.BigDecimal;
import java.util.List;

public interface UserOrderInfoMapper {
    int deleteByPrimaryKey(BigDecimal id) throws Exception;

    int insert(UserOrderInfo record) throws Exception;

    int updateTheUserOrderState(UserOrderInfo userOrderInfo) throws Exception;
    
    int insertSelective(UserOrderInfo record) throws Exception;

    UserOrderInfo selectByPrimaryKey(BigDecimal id) throws Exception;

    List<UserOrderInfo> selectByUserId(BigDecimal userId) throws Exception;
    
    int updateByPrimaryKeySelective(UserOrderInfo record) throws Exception;

    int updateByPrimaryKey(UserOrderInfo record) throws Exception;
}