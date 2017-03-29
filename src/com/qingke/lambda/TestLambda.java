package com.qingke.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ld = new ArrayList<Integer>();
		ld.add(12);
		ld.add(23);
		//lambda,方法可以传入lambda的前提是接受的参数类型是@FunctionalInterface接口
		ld.forEach((Integer a)-> System.out.println(a));
		//匿名内部类
		ld.forEach(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
		System.out.println("===================");
		print(ld,(Integer a)->a>=23);
		System.out.println("===================");
		MyList<Integer> list = new MyList<Integer>();
		list.add(11);
		list.add(28);
		list.myForEach((Integer a,Predicate<Integer> p)-> {if(p.test(a)) System.out.println(a);},(Integer a)->a<=23);
		System.out.println("-------------------------------------");
		list.forEach((Integer a)->{if(a>=23) System.out.println(a);});
	}
	
	public static void print(List<Integer> list,Predicate<Integer> p){
		list.forEach((Integer a)-> {
									if(p.test(a))
										System.out.println(a);
									});
	}
}

class MyList<T> extends ArrayList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void myForEach(MyIfFor<T> ifFor,Predicate<T> p){
		for(T t : this){
			ifFor.myFor(t,p);
		}
	}
	
}

interface MyIfFor<T>{
	public void myFor(T t,Predicate<T> p);
}
