package com.aspire.OnlineMeal.result;

import java.util.List;

public class ResultInfo<T> {
	//总记录数
	private int count =0;
	//页面总数
	private int pageCount=0;
	//当前页面
	private int page=0;
	//当前记录数
	private int rows=0;
	//返回的列表数据
	private List<T> list=null;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
