package com.qingke.map1;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
	public static Map<String,Integer> hash;
	static class Com1 implements Comparator<String>{
		public Integer insertValue;
		public Map<String,Integer> tree;
		public int compare(String o1, String o2) {
			int result = 0;
			try{
				System.out.println("=============");
				if(hash.get(o1)==hash.get(o2)){
					result = 0;
				}else if(hash.get(o1)>hash.get(o2)){
					result = 1;
				}else{
					result = -1;
				}
			}catch(Exception e){
				System.out.println("=============11");
				System.out.println(insertValue);
//				if(insertValue==hash.get(o2)){
//					result = 0;
//				}else if(insertValue>hash.get(o2)){
//					result = 1;
//				}else{
//					result = -1;
//				}
			}
			System.out.println("=============0");
			System.out.println(result);
			return result;
		}
		
	}
	
	public static void main(String[] args){
//		testLinkedHashMap();
		testTreeMap();
//		testTreeMap1();
	}
	
	public static void testHashMap(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("tom", 6);
		map.put("dell", 2);
		map.put("len", 7);
		System.out.println(map);
		
		for(Map.Entry<String,Integer> entry:map.entrySet()){
			System.out.println(entry);
		}
		
		Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
		System.out.println("=======================");
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void testLinkedHashMap(){
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		map.put("tom", 6);
		map.put("dell", 2);
		map.put("len", 7);
		System.out.println(map);
		
		for(Map.Entry<String,Integer> entry:map.entrySet()){
			System.out.println(entry);
		}
		
		Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
		System.out.println("=======================");
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void testTreeMap(){
		Map<String,Integer> hash = new HashMap<String,Integer>();
		hash.put("tom", 6);
		hash.put("dell", 2);
		hash.put("len", 7);
		Com com = new Com(hash);
		Map<String,Integer> map = new TreeMap<String,Integer>(com);
		map.putAll(hash);
		System.out.println(map);
		
		for(Map.Entry<String,Integer> entry:map.entrySet()){
			System.out.println(entry);
		}
		
		Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
		System.out.println("=======================");
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void testTreeMap1(){
		Com1 com = new Com1();
		hash = new TreeMap<String,Integer>(com);
		com.insertValue = 6;
		com.tree = hash;
		hash.put("tom", 6);
		com.insertValue = 2;
		hash.put("dell", 2);
		com.insertValue = 7;
		hash.put("len", 7);
		com.insertValue = 1;
		hash.put("dd", 1);
		System.out.println(hash);
	}
}

class Com implements Comparator<String>{
	public Map<String,Integer> map;
	public Integer insertValue;
	public Com(Map<String,Integer> map){
		this.map = map;
	}
	public int compare(String o1, String o2) {
		int result = 0;
		System.out.println("================12");
		if(map.get(o1)==map.get(o2)){
			result = 0;
		}else if(map.get(o1)>map.get(o2)){
			result = 1;
		}else{
			result = -1;
		}
		return result;
	}
	public void test(){
		try{
			throw new IOException();
		}catch(IOException e){
			
		}finally{
			
		}
	}
	
}

