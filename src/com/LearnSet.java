package com;

import java.util.Set;
import java.util.TreeSet;

public class LearnSet {

	public static void main(String[] args) {
   Set<String> set=new TreeSet<String>();
   set.add("hello");
   set.add("animal");
   set.add("word");
   set.add("cook");
   for(String s:set){
	   System.out.println(s);
   }
	}

}
