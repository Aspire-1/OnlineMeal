package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.DishedTypeMapper;
import com.aspire.OnlineMeal.model.DishedType;
import com.aspire.OnlineMeal.service.IDishedTypeService;

@Service("DishedTypeService")
public class DishedTypeServiceImpl implements IDishedTypeService {

	@Autowired
	private DishedTypeMapper dtm = null;
	
	@Override
	public int add(DishedType dishedType) throws Exception {
		return dtm.insert(dishedType);
	}

	@Override
	public int addWithSelective(DishedType dishedType) throws Exception {
		// TODO Auto-generated method stub
		return dtm.insertSelective(dishedType);
	}

	@Override
	public int deleteDishedType(BigDecimal id) throws Exception {
		// TODO Auto-generated method stub
		return dtm.deleteByPrimaryKey(id);
	}

	@Override
	public List<DishedType> getAll() throws Exception {
		return dtm.selectAll();
	}

}
