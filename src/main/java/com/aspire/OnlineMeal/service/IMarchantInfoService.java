package com.aspire.OnlineMeal.service;

import com.aspire.OnlineMeal.model.MarchantInfo;

public interface IMarchantInfoService {
	
	public int add(MarchantInfo marchantInfo) throws Exception;
	public int addWithSelective(MarchantInfo marchantInfo) throws Exception;
	
	public int modifyMarthantState(MarchantInfo marchantInfo) throws Exception;
	
}
