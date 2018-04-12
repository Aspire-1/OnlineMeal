package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.MarchantManager;
import java.math.BigDecimal;

public interface MarchantManagerMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(MarchantManager record);

    int insertSelective(MarchantManager record);

    MarchantManager selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(MarchantManager record);

    int updateByPrimaryKey(MarchantManager record);
}