package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.UserOrderInfo;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface UserOrderInfoMapper {
    int deleteByPrimaryKey(BigDecimal id) throws Exception;

    int insert(UserOrderInfo record) throws Exception;

    int updateTheUserOrderState(UserOrderInfo userOrderInfo) throws Exception;
    
    int insertSelective(UserOrderInfo record) throws Exception;

    UserOrderInfo selectByPrimaryKey(BigDecimal id) throws Exception;

    List<UserOrderInfo> selectByUserId(BigDecimal userId) throws Exception;
    
    List<UserOrderInfo> selectByMarchantId(BigDecimal marchantId) throws Exception;
    
    List<UserOrderInfo> selectByUserIdWithPage(RowBounds rb,BigDecimal userId) throws Exception;
    
    List<UserOrderInfo> selectByMarchantIdWithPage(RowBounds rb,BigDecimal marchantId) throws Exception;
   
    List<UserOrderInfo> selectUserOrderByMarchantIdWithTime(String startTime,String endTime, BigDecimal marchantId,RowBounds rb) throws Exception;
    int selectOrderCountByMarchantIdWithTime(String startTime,String endTime,BigDecimal marchantId) throws Exception;

    List<UserOrderInfo> selectUserOrderByPhone(String phone, BigDecimal marchantId,RowBounds rb) throws Exception;
    int selectCountWithUserOrderByPhone(String phone,BigDecimal marchantId) throws Exception;
    
    int selectUserOrderCountByUserId(BigDecimal userId) throws Exception;
    
    int selectUserOrderCountByMarchantId(BigDecimal marchantId) throws Exception;
    
    BigDecimal selectCurrentSeq() throws Exception;
    
    int updateByPrimaryKeySelective(UserOrderInfo record) throws Exception;

    int updateByPrimaryKey(UserOrderInfo record) throws Exception;

    List<UserOrderInfo> selectUserOrderByPayState(String payState, BigDecimal marchantId,RowBounds rb) throws Exception;
    int selectCountWithUserOrderByPayState(String payState,BigDecimal marchantId) throws Exception;
}