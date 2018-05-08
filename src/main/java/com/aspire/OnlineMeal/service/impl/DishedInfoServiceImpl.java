package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	public List<DishedInfo> getDishedWithDishedType(DishedInfo dishedInfo) throws Exception {
		// TODO Auto-generated method stub
		return dim.selectWithDishedType(dishedInfo);
	}

	@Override
	public List<DishedInfo> getWithVagueName(DishedInfo dishedInfo) throws Exception {
		// TODO Auto-generated method stub
		return dim.selectWithVagueName(dishedInfo);
	}

	@Override
	public List<DishedInfo> getAll(BigDecimal marchantId) throws Exception {
		// TODO Auto-generated method stub
		return dim.selectAll(marchantId);
	}

	@Override
	public List<DishedInfo> getAllWithPage(int rows, int page,BigDecimal marchantId) throws Exception {
		RowBounds rb=new RowBounds(rows*(page-1),rows);
		return dim.selectAllWithPage(rb, marchantId);
	}

	@Override
	public int getCountByAll(BigDecimal marchantId) throws Exception {
		return dim.selectCountByAll(marchantId);
	}
	
	@Override
	public int getPageCountByAll(int rows,BigDecimal marchantId) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll(marchantId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public DishedInfo getByPrimaryKey(BigDecimal id) throws Exception {
		return dim.selectByPrimaryKey(id);
	}

}
