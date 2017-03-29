package com.qingke.clone;

public class Account12 implements Cloneable{
	public String id;
	public String name;
	public int balance;
	
	public static void main(String[] args) throws CloneNotSupportedException{
		Account12 a1=new Account12("1", "÷‹±¶∏’",1000);
		Account12 a2=new Account12("2", "÷‹±¶∏’sb",1000);
		//Account a11=(Account)a1.clone();
		//a11.setId("3");
		System.out.println(a1.credit(500));
		System.out.println(a1.debit(800));
		System.out.println(a1.transferTo(a2, 400));
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		//System.out.println(a11.toString());
		//System.out.println(a1);
		//System.out.println(a11);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account12(String id,String name){
		this.id=id;
		this.name=name;
	}
	public Account12(String id,String name,int balance){
		this.id=id;
		this.name=name;
		this.balance=balance;
	}
	public int credit(int amount){
		balance=balance+amount;
		return balance;
	}
	public int debit(int amount){
		if(amount<=balance){
			 balance=balance-amount;
		}else{
			System.out.println("Amount1 exceeded balance");
		}
		return balance;
	}
	public int transferTo(Account12 another,int amount){
		if(amount<=balance){
			another.balance=another.balance+amount;
			balance=balance-amount;
		}else{
			System.out.println("Amount2 exceeded balance");
		}
		return balance;
	}
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	protected Object clone(){
		Account12 account;
		account = (Account12) this.clone();
//			account.id=(String)id.clone();
		return (Object)account;
	}
}
