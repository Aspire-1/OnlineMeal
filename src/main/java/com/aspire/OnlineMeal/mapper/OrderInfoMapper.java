package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.OrderInfo;
import java.math.BigDecimal;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}