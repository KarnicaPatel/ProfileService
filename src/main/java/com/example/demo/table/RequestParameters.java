package com.example.demo.table;

import org.springframework.stereotype.Component;

@Component
public class RequestParameters {
	public String userName;
	public String first_name;
	public String last_name;
	public String age;
	public String id;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RequestParameters(String userName, String first_name, String last_name, String age, String id) {
		super();
		this.userName = userName;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.id = id;
	}
	@Override
	public String toString() {
		return "RequestParameters [userName=" + userName + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", age=" + age + ", id=" + id + "]";
	}

	public RequestParameters () {
		
	}
	
}
