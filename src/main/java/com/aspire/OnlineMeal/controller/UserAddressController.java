package com.aspire.OnlineMeal.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.OnlineMeal.model.AddressInfo;
import com.aspire.OnlineMeal.publicPOJO.ResultMessage;
import com.aspire.OnlineMeal.service.IUserAddressService;

@RestController
@RequestMapping(value="/UserAddress")
public class UserAddressController {
	
	@Autowired
	private IUserAddressService iuas = null;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(AddressInfo addressInfo) throws Exception{
		ResultMessage result = new ResultMessage();
		
		iuas.add(addressInfo);
		result.setResult("Y");
		result.setMessage("增加地址信息成功");
		
		return result;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public List<AddressInfo> getByUserId(BigDecimal id) throws Exception{
		return iuas.getByUserId(id);
	}
	
	
}
