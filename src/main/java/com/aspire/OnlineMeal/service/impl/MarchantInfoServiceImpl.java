package com.aspire.OnlineMeal.service.impl;

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
		// TODO Auto-generated method stub
		return mim.updateByPrimaryKeySelective(marchantInfo);
	}

}
