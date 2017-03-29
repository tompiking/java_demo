package com.qingke.inter;

public interface TextInterface {
	static void dd(){
		System.out.println("interface");
	}
	
	void ff();
	
	default void dd1(){
		System.out.println("interface");
	}
}
  