package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.UserInfo;
import java.math.BigDecimal;

public interface UserInfoMapper {
    int deleteByPrimaryKey(BigDecimal id); 

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKeyWithBLOBs(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}