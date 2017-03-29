package com.qingke.hashSet;

import java.util.HashSet;
import java.util.Set;

public class TestHashCode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Dog> a = new HashSet<Dog>();
		a.add(new Dog("tom2",1));
		a.add(new Dog("tom1",2));
		a.add(new Dog("tom4",3));
		a.add(new Dog("tom3",4));
		a.add(new Dog("tom3",3));
		a.add(new Dog("tom2",3));
		System.out.println(a);
		System.out.println(new Dog("tom2",1).equals(new Dog("tom2",3)));
		System.out.println(a.contains(new Dog("tom2",3)));
	}
}
