package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.MarchantInfo;
import java.math.BigDecimal;

public interface MarchantInfoMapper {
    int deleteByPrimaryKey(BigDecimal infoId);

    int insert(MarchantInfo record);

    int insertSelective(MarchantInfo record);

    MarchantInfo selectByPrimaryKey(BigDecimal infoId);

    int updateByPrimaryKeySelective(MarchantInfo record);

    int updateByPrimaryKey(MarchantInfo record);
}