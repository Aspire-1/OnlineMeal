package com.aspire.OnlineMeal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.OrderInfoMapper;
import com.aspire.OnlineMeal.model.OrderInfo;
import com.aspire.OnlineMeal.service.IOrderInfoService;

@Service("OrderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService {

	@Autowired
	private OrderInfoMapper oim = null;
	
	@Override
	public int addOrderInfo(OrderInfo orderInfo) throws Exception {
		return oim.insert(orderInfo);
	}
	
	@Override
	public int addOrderInfoWithBatch(List<OrderInfo> list) throws Exception {
		return oim.insertWithBatch(list);
	}

	@Override
	public int deleteOrderInfo(BigDecimal orderId) throws Exception {
		// TODO Auto-generated method stub
		return oim.deleteByPrimaryKey(orderId);
	}

	@Override
	public List<OrderInfo> getAllOrderInfoByUserOrderId(BigDecimal userOrderId) throws Exception {
		// TODO Auto-generated method stub
		return oim.selectByUserOrderId(userOrderId);
	}

	

}
