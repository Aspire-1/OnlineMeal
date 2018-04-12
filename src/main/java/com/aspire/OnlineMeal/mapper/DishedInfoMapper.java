package com.aspire.OnlineMeal.mapper;

import com.aspire.OnlineMeal.model.DishedInfo;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface DishedInfoMapper {
    int deleteByPrimaryKey(BigDecimal infoId) throws Exception;

    int insert(DishedInfo record) throws Exception;

    int insertSelective(DishedInfo record) throws Exception;

    DishedInfo selectByPrimaryKey(BigDecimal infoId) throws Exception;

    int updateByPrimaryKeySelective(DishedInfo record) throws Exception;

    int updateByPrimaryKeyWithBLOBs(DishedInfo record) throws Exception;

    int updateByPrimaryKey(DishedInfo record) throws Exception;
    //按类型查找菜肴
    List<DishedInfo> selectWithDishedType(DishedInfo record) throws Exception;
    //按照菜肴名称模糊查找
    List<DishedInfo> selectWithVagueName(DishedInfo record) throws Exception;
    //查找所有的菜肴
    List<DishedInfo> selectAll(BigDecimal marchantId) throws Exception;
    //分页方式取得所有的菜肴信息
    List<DishedInfo> selectAllWithPage(RowBounds rb,BigDecimal marchantId) throws Exception;
    //获取某商家所有的菜肴记录数
    int selectCountByAll(BigDecimal marchantId) throws Exception;
}