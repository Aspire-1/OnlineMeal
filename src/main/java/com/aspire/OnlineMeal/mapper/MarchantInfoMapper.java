package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.MarchantInfo;
import java.math.BigDecimal;
import java.util.List;

public interface MarchantInfoMapper {
    int deleteByPrimaryKey(BigDecimal infoId) throws Exception;

    int insert(MarchantInfo record) throws Exception;

    int insertSelective(MarchantInfo record) throws Exception;

    MarchantInfo selectByPrimaryKey(BigDecimal infoId) throws Exception;
    //按照商家类型进行查找
    List<MarchantInfo> selectByType(String type) throws Exception;
    //按照商家名称模糊查找
    List<MarchantInfo> selectWithVagueName(String name) throws Exception;

    int updateByPrimaryKeySelective(MarchantInfo record) throws Exception;

    int updateByPrimaryKey(MarchantInfo record) throws Exception;
}