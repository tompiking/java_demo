package com.qingke.hashSet;

public class Dog {
	public String name;
	public int age;
	public Dog(String namePar,int agePar){
		name = namePar;
		age  = agePar;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Dog)) return false;
		Dog dog = (Dog)obj;
		
		return (this.name==dog.name)&&(this.age==dog.age);
	}
}
