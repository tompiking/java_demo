package com.qingke.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
//		for(int i = 0; i<=10;i++){
//			list.add(i+1);
//		}
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(3);
		list.add(1);
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(1);
		list.add(1);
		list.add(6);
		list.add(5);
		System.out.println(list);
		System.out.println("============================");
		System.out.println(test2(list));
	}
	
	public static List<?> test1(List<?> list,int n){
		list.remove(n-1);
		return list;
	}
	public static List<Integer> test2(List<Integer> list){
		List<Integer> l = new ArrayList<Integer>();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int value = it.next();
			if (!l.contains(value))
				l.add(value);
		}
		return l;
	}

}
