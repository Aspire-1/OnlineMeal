package com.aspire.OnlineMeal.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.OrderInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IOrderInfoService;

@RestController
@RequestMapping(value="/OrderInfo")
public class OrderInfoController {
	
	@Autowired
	private IOrderInfoService iois = null;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage addOrderInfo(OrderInfo orderInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		
		iois.addOrderInfo(orderInfo);
		
		result.setResult("Y");
		result.setMessage("添加订单信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/add/batch",method=RequestMethod.POST)
	public ResultMessage addOrderInfoWithBatch(@RequestBody OrderInfo[] oiArr) throws Exception{
		ResultMessage result = new ResultMessage();
		
		List<OrderInfo> list = Arrays.asList(oiArr);
		
		iois.addOrderInfoWithBatch(list);
		
		result.setResult("Y");
		result.setMessage("批量添加订单信息成功");
		
		return result;
	}
	
}
