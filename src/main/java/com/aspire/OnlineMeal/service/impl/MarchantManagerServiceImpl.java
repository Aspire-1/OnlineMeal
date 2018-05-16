package com.aspire.OnlineMeal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.OnlineMeal.mapper.MarchantManagerMapper;
import com.aspire.OnlineMeal.model.MarchantManager;
import com.aspire.OnlineMeal.service.IMarchantManagerService;

@Service("MarchantManagerService")
public class MarchantManagerServiceImpl implements IMarchantManagerService {

	@Autowired
	private MarchantManagerMapper mmm = null;
	
	@Override
	public int addSelective(MarchantManager manager) throws Exception {
		return mmm.insertSelective(manager);
	}

	@Override
	public MarchantManager getByPhone(String phone) throws Exception {
		return mmm.selectByPhone(phone);
	}
	
	@Override
	public boolean isExit(String phone) throws Exception{
		if(mmm.selectByPhone(phone)!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean validateLogin(String phone, String password) throws Exception {
		
		MarchantManager manager = mmm.selectByPhone(phone);
		if(manager!=null && manager.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public int modifyManagerPwd(String oldPwd, String newPwd, String phone) throws Exception {
		if(this.validateLogin(phone, oldPwd)){
			MarchantManager manager = mmm.selectByPhone(phone);
			MarchantManager newManager = new MarchantManager();
			newManager.setId(manager.getId());
			newManager.setPassword(newPwd);
			return mmm.updateByPrimaryKeySelective(newManager);
		}
		
		return -1;
	}
	
	@Override
	public int modifyManager(MarchantManager manager) throws Exception{
		return mmm.updateByPrimaryKeySelective(manager);
	}
	
	
	
}
