package com.aspire.OnlineMeal.service;

import java.math.BigDecimal;
import java.util.List;

import com.aspire.OnlineMeal.model.MarchantInfo;

public interface IMarchantInfoService {
	
	public int add(MarchantInfo marchantInfo) throws Exception;
	public int addWithSelective(MarchantInfo marchantInfo) throws Exception;
	
	public int modifyMarthantState(MarchantInfo marchantInfo) throws Exception;
	public MarchantInfo getByPrimaryKey(BigDecimal id) throws Exception;
	public List<MarchantInfo> getMarchantByType(String type) throws Exception;
	public List<MarchantInfo> getWithVagueName(String name) throws Exception;
	public List<MarchantInfo> getAll() throws Exception;
}
