package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.MarchantManager;
import java.math.BigDecimal;

public interface MarchantManagerMapper {
    int deleteByPrimaryKey(BigDecimal id) throws Exception;

    int insert(MarchantManager record) throws Exception;

    int insertSelective(MarchantManager record) throws Exception;

    MarchantManager selectByPrimaryKey(BigDecimal id) throws Exception;
    //通过手机号查找商家管理员
    MarchantManager selectByPhone(String phone) throws Exception;
    
    int updateByPrimaryKeySelective(MarchantManager record) throws Exception;

    int updateByPrimaryKey(MarchantManager record) throws Exception;
    
}