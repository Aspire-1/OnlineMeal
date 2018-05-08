package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.MarchantInfoMapper;
import com.aspire.OnlineMeal.model.MarchantInfo;
import com.aspire.OnlineMeal.service.IMarchantInfoService;

@Service("MarchantInfoService")
public class MarchantInfoServiceImpl implements IMarchantInfoService {

	@Autowired
	private MarchantInfoMapper mim = null;
	
	@Override
	public int add(MarchantInfo marchantInfo) throws Exception {
		return mim.insert(marchantInfo);
	}

	@Override
	public int addWithSelective(MarchantInfo marchantInfo) throws Exception {
		return mim.insertSelective(marchantInfo);
	}

	@Override
	public int modifyMarthantState(MarchantInfo marchantInfo) throws Exception {
		return mim.updateByPrimaryKeySelective(marchantInfo);
	}

	@Override
	public MarchantInfo getByPrimaryKey(BigDecimal id) throws Exception {
		return mim.selectByPrimaryKey(id);
	}

	@Override
	public List<MarchantInfo> getMarchantByType(String type) throws Exception {
		return mim.selectByType(type);
	}
	
	public List<MarchantInfo> getWithVagueName(String name) throws Exception{
		return mim.selectWithVagueName(name);
	}

	@Override
	public List<MarchantInfo> getAll() throws Exception {
		return mim.selectAll();
	}

}
