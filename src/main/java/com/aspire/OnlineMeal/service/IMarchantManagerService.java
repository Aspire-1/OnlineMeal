package com.aspire.OnlineMeal.service;

import com.aspire.OnlineMeal.model.MarchantManager;

public interface IMarchantManagerService {
	
	public int addSelective(MarchantManager manager) throws Exception;
	public MarchantManager getByPhone(String phone) throws Exception;
	public boolean isExit(String phone) throws Exception;
	public boolean validateLogin(String phone,String password) throws Exception;
}
