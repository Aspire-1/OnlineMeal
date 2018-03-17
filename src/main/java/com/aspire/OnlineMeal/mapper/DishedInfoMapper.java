package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.DishedInfo;
import java.math.BigDecimal;
import java.util.List;

public interface DishedInfoMapper {
    int deleteByPrimaryKey(BigDecimal infoId) throws Exception;

    int insert(DishedInfo record) throws Exception;

    int insertSelective(DishedInfo record) throws Exception;

    DishedInfo selectByPrimaryKey(BigDecimal infoId) throws Exception;

    int updateByPrimaryKeySelective(DishedInfo record) throws Exception;

    int updateByPrimaryKeyWithBLOBs(DishedInfo record) throws Exception;

    int updateByPrimaryKey(DishedInfo record) throws Exception;
    //按类型查找菜肴
    List<DishedInfo> selectWithDishedType(String dishedType) throws Exception;
    //按照菜肴名称模糊查找
    List<DishedInfo> selectWithVagueName(String name) throws Exception;
    
}