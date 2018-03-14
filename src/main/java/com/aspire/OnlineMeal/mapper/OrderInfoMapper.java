package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.OrderInfo;
import java.math.BigDecimal;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(BigDecimal id) throws Exception;

    int insert(OrderInfo record) throws Exception;

    int insertSelective(OrderInfo record) throws Exception;

    OrderInfo selectByPrimaryKey(BigDecimal id) throws Exception;

    int updateByPrimaryKeySelective(OrderInfo record) throws Exception;

    int updateByPrimaryKey(OrderInfo record) throws Exception;
}