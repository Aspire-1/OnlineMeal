package com.aspire.OnlineMeal.publicPOJO;

//用于处理结果生成JSON
public class ResultMessage {
	private String result=null;
	private String message=null;
	private String errors=null;
	private Object object = null;
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
}
