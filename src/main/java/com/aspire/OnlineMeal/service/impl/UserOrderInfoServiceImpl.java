package com.aspire.OnlineMeal.service.impl;

import java.awt.RadialGradientPaint;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.UserOrderInfoMapper;
import com.aspire.OnlineMeal.model.UserInfo;
import com.aspire.OnlineMeal.model.UserOrderInfo;
import com.aspire.OnlineMeal.service.IUserOrderInfoService;

@Service("UserOrderInfoService")
public class UserOrderInfoServiceImpl implements IUserOrderInfoService {
	
	@Autowired
	private UserOrderInfoMapper uoim = null;

	@Override
	public BigDecimal addUserOrderInfoWithSelective(UserOrderInfo uoi) throws Exception {
		uoim.insertSelective(uoi);
		return uoi.getId();
	}

	@Override
	public int deleteUserOrderInfo(UserOrderInfo uoi) throws Exception {
		return uoim.updateTheUserOrderState(uoi);
	}

	@Override
	public UserOrderInfo getOrderDetailByOrderInfoId(BigDecimal id) throws Exception {
		return uoim.selectByPrimaryKey(id);
	}

	@Override
	public List<UserOrderInfo> getAllOrderByUserID(BigDecimal id) throws Exception {
		return uoim.selectByUserId(id);
	}

	@Override
	public BigDecimal getPrimaryKey() throws Exception {
		return uoim.selectCurrentSeq();
	}

	@Override
	public List<UserOrderInfo> getAllOrderByMarchantId(BigDecimal marchantId) throws Exception {
		return uoim.selectByMarchantId(marchantId);
	}

	@Override
	public int getOrderCountByUserId(BigDecimal id) throws Exception {
		return uoim.selectUserOrderCountByUserId(id);
	}

	@Override
	public int getOrderCountByMarchantId(BigDecimal id) throws Exception {
		return uoim.selectUserOrderCountByMarchantId(id);
	}

	@Override
	public List<UserOrderInfo> getUserOrderWithPageByUserId(int rows, int page, BigDecimal userId) throws Exception {
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return uoim.selectByUserIdWithPage(rb, userId);
	}

	@Override
	public List<UserOrderInfo> getUserOrderWithPageByMarchantId(int rows, int page, BigDecimal marchantId)
			throws Exception {
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return uoim.selectByMarchantIdWithPage(rb, marchantId);
	}

	@Override
	public int getAllPageByUserId(int rows,BigDecimal userId) throws Exception {
		int pageCount=0;
		int count=this.getOrderCountByUserId(userId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public int getAllPageByMarchantId(int rows,BigDecimal marchantId) throws Exception {
		int pageCount=0;
		int count=this.getOrderCountByMarchantId(marchantId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public UserOrderInfo getByPriamryKey(BigDecimal id) throws Exception {
		return uoim.selectByPrimaryKey(id);
	}

//	@Override
//	public List<UserOrderInfo> getUserOrderByMarchantIdWithTime(String startTime, String endTime, BigDecimal marchantId)
//			throws Exception {
//		return uoim.selectUserOrderByMarchantIdWithTime(startTime, endTime, marchantId);
//	}

	@Override
	public int modifyUserOrderState(UserOrderInfo uoi) throws Exception {
		return uoim.updateByPrimaryKeySelective(uoi);
	}

	@Override
	public List<UserOrderInfo> getUserOrderWithPhone(String phone, BigDecimal marchantId,int rows,int page) throws Exception {
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return uoim.selectUserOrderByPhone(phone, marchantId,rb);
	}
	
	@Override
	public int getOrderCountWithPhone(String phone, BigDecimal marchantId) throws Exception {
		return uoim.selectCountWithUserOrderByPhone(phone, marchantId);
	}
	
	@Override
	public int getAllPageByPhone(int rows,BigDecimal marchantId,String phone) throws Exception {
		int pageCount=0;
		int count=this.getOrderCountWithPhone(phone, marchantId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<UserOrderInfo> getUserOrderByMarchantIdWithTime(String startTime, String endTime, BigDecimal marchantId,
			int rows, int page) throws Exception {
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return uoim.selectUserOrderByMarchantIdWithTime(startTime, endTime, marchantId, rb);
	}

	@Override
	public int getOrderCountByMarchantIdWithTime(String startTime, String endTime, BigDecimal marchantId)
			throws Exception {
		// TODO Auto-generated method stub
		return uoim.selectOrderCountByMarchantIdWithTime(startTime, endTime, marchantId);
	}

	@Override
	public int getAllPageByTime(int rows, String startTime, String endTime, BigDecimal marchantId) throws Exception {
		int pageCount=0;
		int count=this.getOrderCountByMarchantIdWithTime(startTime, endTime, marchantId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<UserOrderInfo> getUserOrderByPayState(String payState, BigDecimal marchantId, int rows, int page)
			throws Exception {
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return uoim.selectUserOrderByPayState(payState, marchantId, rb);
	}

	@Override
	public int getUserOrderCountByPayState(String payState, BigDecimal marchantId) throws Exception {
		return uoim.selectCountWithUserOrderByPayState(payState, marchantId);
	}

	@Override
	public int getAllPageByPayState(int rows, String payState, BigDecimal marchantId) throws Exception {
		int pageCount=0;
		int count=this.getUserOrderCountByPayState(payState, marchantId);
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
