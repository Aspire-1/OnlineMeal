package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.UserOrderInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IUserOrderInfoService;

@RestController
@RequestMapping(value = "/UserOrderInfo")
public class UserOrderInfoController {

	@Autowired
	private IUserOrderInfoService iuois = null;

	@RequestMapping(value = "/add/Selective", method = RequestMethod.POST)
	public ResultMessage addUserOrderWithSelective(UserOrderInfo uoi) throws Exception {
		Date date = new Date();
		ResultMessage result = new ResultMessage();

		// 用户订单编号的生成
		DecimalFormat dFormat = new DecimalFormat("0000");
		String code = dFormat.format(uoi.getUserid().longValue()) + dFormat.format(uoi.getMarchantId().longValue())
				+ String.valueOf(date.getTime());
		uoi.setCode(code);

		// 订单创建时间的添加
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		uoi.setCreateTime(sdf.format(date));
		
		iuois.addUserOrderInfoWithSelective(uoi);
		
		result.setMessage("添加订单成功");
		
		System.out.println(iuois.getPrimaryKey());

		return result;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultMessage deleteUserOrderInfo(UserOrderInfo uoi) throws Exception {
		ResultMessage result = new ResultMessage();

		uoi.setState("07");
		iuois.deleteUserOrderInfo(uoi);

		result.setResult("Y");
		result.setMessage("订单取消成功");

		return result;
	}

	@RequestMapping(value = "/getAll/user", method = RequestMethod.POST)
	public List<UserOrderInfo> getAllOrderByUserId(BigDecimal userId) throws Exception {
		return iuois.getAllOrderByUserID(userId);
	}

	@RequestMapping(value = "/get/detail", method = RequestMethod.POST)
	public UserOrderInfo getOrderDetail(BigDecimal id) throws Exception {
		return iuois.getOrderDetailByOrderInfoId(id);

	}
	
	@RequestMapping(value="/getAll/marchant",method=RequestMethod.POST)
	public List<UserOrderInfo> getAllOrderByMarchantId(BigDecimal marchantId) throws Exception{
		return iuois.getAllOrderByMarchantId(marchantId);
	}
	
	@RequestMapping(value="/getAll/user/page",method=RequestMethod.POST)
	public ResultInfo getAllOrderWithPageByUserId(
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page,
			BigDecimal userId) throws Exception{
		ResultInfo result = new ResultInfo();
		result.setCount(iuois.getOrderCountByUserId(userId));
		result.setPageCount(iuois.getAllPageByUserId(rows, userId));
		result.setList(iuois.getUserOrderWithPageByUserId(rows, page, userId));
		result.setRows(rows);
		result.setPage(page);
		return result;
	}
	
	@RequestMapping(value="/getAll/marchant/page",method=RequestMethod.POST)
	public ResultInfo getAllOrderWithPageByMarchantId(
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page,
			BigDecimal marchantId) throws Exception{
		ResultInfo result = new ResultInfo();
		result.setCount(iuois.getOrderCountByMarchantId(marchantId));
		result.setPageCount(iuois.getAllPageByMarchantId(rows, marchantId));
		result.setList(iuois.getUserOrderWithPageByMarchantId(rows, page, marchantId));
		result.setRows(rows);
		result.setPage(page);
		return result;
	}
	
	@RequestMapping(value="/get/primaryKey",method=RequestMethod.POST)
	public UserOrderInfo getByPrimaryKey(BigDecimal id) throws Exception{
		return iuois.getByPriamryKey(id);
	}
}
