package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.DishedType;
import java.math.BigDecimal;
import java.util.List;

public interface DishedTypeMapper {
    int deleteByPrimaryKey(BigDecimal id) throws Exception;

    int insert(DishedType record) throws Exception;

    int insertSelective(DishedType record) throws Exception;

    DishedType selectByPrimaryKey(BigDecimal id) throws Exception;
    
    List<DishedType> selectAll() throws Exception;
    

    int updateByPrimaryKeySelective(DishedType record) throws Exception;

    int updateByPrimaryKey(DishedType record) throws Exception;
}