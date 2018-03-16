package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.OrderInfo;
import java.math.BigDecimal;
import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(BigDecimal id) throws Exception;

    int insert(OrderInfo record) throws Exception;

    int insertSelective(OrderInfo record) throws Exception;
    
    int insertWithBatch(List<OrderInfo> list) throws Exception;

    OrderInfo selectByPrimaryKey(BigDecimal id) throws Exception;
    
    List<OrderInfo> selectByUserOrderId(BigDecimal userOrderId) throws Exception;

    int updateByPrimaryKeySelective(OrderInfo record) throws Exception;

    int updateByPrimaryKey(OrderInfo record);
}