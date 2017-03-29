package com.qingke.hashSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Dog> a = new TreeSet<Dog>(new AgeComp());
		a.add(new Dog("tom2",1));
		a.add(new Dog("tom1",2));
		a.add(new Dog("tom4",3));
		a.add(new Dog("tom3",4));
		a.add(new Dog("tom3",3));
		a.add(new Dog("tom2",3));
		System.out.println(a);
//		a.removeIf(Predicate.isEqual(10));
//		System.out.println(a);
	}

}

class AgeComp implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		if(o1.age==o2.age){
			return o1.name.compareTo(o2.name);
		}else if(o1.age<o2.age){
			return -1;
		}else{
			return 1;
		}
	}
	
}
