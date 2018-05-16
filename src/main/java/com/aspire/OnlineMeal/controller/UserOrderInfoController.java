package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.DishedInfo;
import com.aspire.OnlineMeal.model.OrderInfo;
import com.aspire.OnlineMeal.model.UserOrderInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IDishedInfoService;
import com.aspire.OnlineMeal.service.IOrderInfoService;
import com.aspire.OnlineMeal.service.IUserOrderInfoService;

@RestController
@RequestMapping(value = "/UserOrderInfo")
public class UserOrderInfoController {

	@Autowired
	private IUserOrderInfoService iuois = null;
	@Autowired
	private IOrderInfoService iois = null;
	@Autowired
	private IDishedInfoService idis = null;

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
	
	//通过主键获取userOrderInfo
	@RequestMapping(value="/get/primaryKey",method=RequestMethod.POST)
	public UserOrderInfo getByPrimaryKey(BigDecimal id) throws Exception{
		return iuois.getByPriamryKey(id);
	}
	
//	@RequestMapping(value="/get/marchant/time",method=RequestMethod.POST)
//	public List<UserOrderInfo> getByMarchantIdWithTime(String startTime,String endTime,BigDecimal marchantId) throws Exception{
//		return iuois.getUserOrderByMarchantIdWithTime(startTime, endTime, marchantId);
//	}
	
	@RequestMapping(value="/get/marchant/time",method=RequestMethod.POST)
	public ResultInfo getByMarchantIdWithTime(String startTime,String endTime,
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page,BigDecimal marchantId) throws Exception{
		ResultInfo result = new ResultInfo();
		result.setCount(iuois.getOrderCountByMarchantIdWithTime(startTime, endTime, marchantId));
		result.setPageCount(iuois.getAllPageByTime(rows, startTime, endTime, marchantId));
		result.setList(iuois.getUserOrderByMarchantIdWithTime(startTime, endTime, marchantId, rows, page));
		result.setRows(rows);
		result.setPage(page);
		
		return result;
	}
	
	@RequestMapping(value="/get/payState",method=RequestMethod.POST)
	public ResultInfo getByPayState(String payState,
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page,BigDecimal marchantId) throws Exception{
		ResultInfo result = new ResultInfo();
		result.setCount(iuois.getUserOrderCountByPayState(payState, marchantId));
		result.setPageCount(iuois.getAllPageByPayState(rows, payState, marchantId));
		result.setList(iuois.getUserOrderByPayState(payState, marchantId, rows, page));
		result.setRows(rows);
		result.setPage(page);
		return result;
	}
	
	@RequestMapping(value="/get/phone",method=RequestMethod.POST)
	public ResultInfo getByUserPhone(String phone,
			@RequestParam(required=false,defaultValue="3") int rows,
			@RequestParam(required=false,defaultValue="1") int page,BigDecimal marchantId) throws Exception{
		ResultInfo result = new ResultInfo();
		result.setCount(iuois.getOrderCountWithPhone(phone, marchantId));
		result.setPageCount(iuois.getAllPageByPhone(rows, marchantId, phone));
		result.setList(iuois.getUserOrderWithPhone(phone, marchantId,rows,page));
		result.setRows(rows);
		result.setPage(page);
		return result;
	}
	
	//订单状态的修改
	@RequestMapping(value="/modify/state",method=RequestMethod.POST)
	public ResultMessage modifyUserOrderState(UserOrderInfo uoi) throws Exception{
		ResultMessage result = new ResultMessage();
		//用户订单状态 01 完成订单 02 待商家接单 03 商家已接单 04 烹饪中 05 配送中 06 待取消订单 07 取消订单 99 异常
		int sqlResult = iuois.modifyUserOrderState(uoi);
		if(uoi.getState().equals("01")){
			result.setResult("Y");
			result.setMessage("订单已完成");
		}else if(sqlResult==0){
			result.setResult("N");
			result.setMessage("数据库操作异常");
		}else if(uoi.getState().equals("03")){
			result.setResult("Y");
			result.setMessage("商家接单成功");
		}
		return result;
	}
	
	//获取订单主键
	@RequestMapping(value="/get/key",method=RequestMethod.POST)
	public BigDecimal getPrimaryKey() throws Exception{
		return iuois.getPrimaryKey();
	}
	
	//下订单操作
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	public ResultMessage placeOrder(@RequestBody UserOrderInfo userOrder) throws Exception{
		ResultMessage result = new ResultMessage();
		Date date = new Date();
		
		// 用户订单编号的生成
		DecimalFormat dFormat = new DecimalFormat("0000");
		if(userOrder.getUserid()!=null && userOrder.getMarchantId()!=null){
			String code = dFormat.format(userOrder.getUserid().longValue()) + dFormat.format(userOrder.getMarchantId().longValue())
			+ String.valueOf(date.getTime());
			userOrder.setCode(code);
		}
		
		//订单状态置为待商家接单
		userOrder.setState("02");
		//订单状态一开始为未付款状态
		userOrder.setPayState("02");
		// 订单创建时间的添加
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		userOrder.setCreateTime(sdf.format(date));
		
		List<OrderInfo> orderContent = userOrder.getOrderContents();
		
		//修改菜肴信息表中的库存信息
		//modifyDeshedInfoStore(orderContent);
		
		BigDecimal userOrderId = iuois.addUserOrderInfoWithSelective(userOrder);
		System.out.println("---当前序列值："+userOrderId+"-----");
		for (OrderInfo orderInfo : orderContent) {
			orderInfo.setUserOrderId(userOrderId);
		}
		iois.addOrderInfoWithBatch(orderContent);
		
		result.setResult(""+userOrderId);
		result.setMessage("提交订单成功");
		return result;
	}
	
	public void modifyDeshedInfoStore(List<OrderInfo> orderInfos) throws Exception{
		for (OrderInfo orderInfo : orderInfos) {
			DishedInfo dishedInfo = idis.getByPrimaryKey(orderInfo.getDishedId());
			BigDecimal oldStore = dishedInfo.getStore();
			BigDecimal useDished = orderInfo.getDishedCount();
			BigDecimal newStore = oldStore.subtract(useDished);
			System.out.println("新库存："+ newStore);
			dishedInfo.setStore(newStore);
			idis.modifyDished(dishedInfo);
		}
	}
	
}
