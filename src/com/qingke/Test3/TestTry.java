package com.qingke.Test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTry {
	public static void main(String[]args){
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		for(String s:list){
			System.out.println(s);
		}
		Set<String>set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("a");
		for(String s:set){
			System.out.println(s);
		}
		
//		Collections.max(coll)
		byte b=(byte) 129;
		System.out.println(b);
		
		System.out.println("a".equalsIgnoreCase("A"));
	}
}
