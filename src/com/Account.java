package com;

import java.util.HashSet;
import java.util.Set;

public class Account implements Cloneable {
    String id,name;
    private int balance=0;
    
    public static void main(String []args){
    	Account a = new Account("1130","Tom");
    		
    	//try {
    		Account aclone = new Account("1130","Tom");
    		
    		System.out.println(a.hashCode());
    		System.out.println(aclone.hashCode());
    		
    		Set<Account> set = new HashSet<Account>();
    		set.add(a);	
    		
    		System.out.println(set.contains(aclone));   		
		//} catch (CloneNotSupportedException e) {
			//System.out.println("“Ï≥£");
			//e.printStackTrace();
		//}  	   	
    }
    
    public Account(String id,String name){
    	this.id = id;
    	this.name = name;
    }
    
    public Account(String id,String name,int balance){
    	this.id = id;
    	this.name = name;
    	this.balance = balance;
    }
    
    public String getID(){
    	return id;
    }
    
    public String getName(){
    	return name;
    }
    
    public int getBalance(){
    	return balance;
    }
    
    public int credit(int amount){
    	balance = balance + amount;
    	return balance;
    }
    
    public int debit(int amount){
    	if(amount<=balance){
    		balance = balance - amount;
    	}
    	else{
    		System.out.println("Amount exceeded balance");
    	}
    	return balance;
    }
    
    public int transferTo(Account another,int amount){
    	if(amount<=balance){
    		another.balance = another.balance - amount;
    	}
    	else{
    		System.out.println("Amount exceeded balance");
    	}
    	return another.balance;
    }
    
    public String toString(){
    	return "Account[id="+id+",name="+name+",balance="+balance+"]";
    }
    
    public int hashCode(){
    	return (id+name).hashCode();
    }
    
    public boolean equals(Object c){
    	if(!(c instanceof Account)) return false;
    	Account a = (Account)c;
    	return a.id==this.id&&a.name==this.name;
    }
}
