package com.aspire.test.model;

import org.apache.ibatis.type.Alias;

@Alias("TestUser")
public class TestUser {
	private String id;
	private String name;
	private int age;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
