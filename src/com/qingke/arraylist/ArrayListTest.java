package com.qingke.arraylist;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args){
		//集合中只能存对象的引用，不能存基本数据类型，比如int要用Integer
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		//ctrl+shift+l可以修改快捷方式，alt+/可以补全代码,比如输入sysout按快捷键补全System.out.println（）
		System.out.println(list.get(1));
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		list.remove(0);
		Iterator<Integer> it = list.iterator();
		System.out.println("===================");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}
}
