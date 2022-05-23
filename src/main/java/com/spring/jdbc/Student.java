package com.spring.jdbc;

public class Student {

	private int sId;
	private String name;
	private String city;
	public Student() {
		
	}
	public Student(int sId, String name, String city) {
		super();
		this.sId = sId;
		this.name = name;
		this.city = city;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", city=" + city + "]";
	}
	
	
	
}
