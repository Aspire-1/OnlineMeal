package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.DishedInfoMapper;
import com.aspire.OnlineMeal.model.DishedInfo;
import com.aspire.OnlineMeal.service.IDishedInfoService;

@Service("DishedInfoService")
public class DishedInfoServiceImpl implements IDishedInfoService {

	@Autowired
	private DishedInfoMapper dim = null;
	
	@Override
	public int addDished(DishedInfo dishedInfo) throws Exception {
		// TODO Auto-generated method stub
		return dim.insert(dishedInfo);
	}

	@Override
	public int addDishedWithSelective(DishedInfo dishedInfo) throws Exception {
		// TODO Auto-generated method stub
		return dim.insertSelective(dishedInfo);
	}

	@Override
	public int deleteDished(BigDecimal id) throws Exception {
		// TODO Auto-generated method stub
		return dim.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyDished(DishedInfo dishedInfo) throws Exception {
		// TODO Auto-generated method stub
		return dim.updateByPrimaryKeySelective(dishedInfo);
	}

	@Override
	public List<DishedInfo> getDishedWithDishedType(String dishedType) throws Exception {
		// TODO Auto-generated method stub
		return dim.selectWithDishedType(dishedType);
	}

	@Override
	public List<DishedInfo> getWithVagueName(String target) throws Exception {
		// TODO Auto-generated method stub
		return dim.selectWithVagueName(target);
	}

}
