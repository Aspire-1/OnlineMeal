package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.MarchantMenu;

public interface MarchantMenuMapper {
    int insert(MarchantMenu record);

    int insertSelective(MarchantMenu record);
}