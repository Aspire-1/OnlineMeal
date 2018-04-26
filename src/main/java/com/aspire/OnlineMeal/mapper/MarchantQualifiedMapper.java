package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.MarchantQualifiedWithBLOBs;

public interface MarchantQualifiedMapper {
    int insert(MarchantQualifiedWithBLOBs record);

    int insertSelective(MarchantQualifiedWithBLOBs record);
}