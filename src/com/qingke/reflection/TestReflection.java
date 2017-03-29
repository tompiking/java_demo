package com.qingke.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog a = new Dog();
		Class<?> ac = a.getClass();
		System.out.println(ac);
		System.out.println("======================");
		Method[] methods = ac.getMethods();
		for(Method m : methods){
			System.out.println(m.getName());
		}
		System.out.println("======================");
		Method[] methods2 = ac.getDeclaredMethods();
		for(Method m : methods2){
			System.out.println(m.getName());
		}
		System.out.println("======================");
		Class<?> suc = ac.getSuperclass();
		System.out.println(suc);
		System.out.println("======================");
		Object o = null;
		try {
			o = ac.newInstance();
			Field fn = ac.getField("name");
			Field fn1 = ac.getDeclaredField("age");
			fn.set(o, "xmiao");
			fn1.setAccessible(true);
			fn1.set(o, 12);
			System.out.println(fn.get(o));
			System.out.println(fn1.get(o));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("======================");
		try {
			Method ma = ac.getMethod("getAge");
			Object re = ma.invoke(o);
			System.out.println(re);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Dog{
	public String name;
	private int age;
	public Dog(){
		
	}
	public Dog(String name,int age){
		this.age = age;
		this.name = name;
	}

	@Deprecated
	public int getAge() {
		return age;
	}
	@SuppressWarnings("unused")
	private void setAge(int age) {
		this.age = age;
	}
	
}
