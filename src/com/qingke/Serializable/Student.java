package com.qingke.Serializable;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private String gander;
	private int age;
	private int age2;
	
	public Student(String name, String gander, int age) {
		super();
		this.name = name;
		this.gander = gander;
		this.age = age;
		age2 = 45;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gander=" + gander + ", age=" + age + ", age2=" + age2 + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGander() {
		return gander;
	}
	public void setGander(String gander) {
		this.gander = gander;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
