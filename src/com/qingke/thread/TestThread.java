package com.qingke.thread;


public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		coding();
		BankAccount account = new BankAccount();
		Thread th = new BankThread(account,"hu");
		th.start();
		Thread th2 = new BankThread(account,"wi");
		th2.start();
		
	}
	//学习线程创建
	public static void coding(){
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
//			Thread th = new MyThread();
//			th.start();
			SecondThread sth = new SecondThread();
			Thread th = new Thread(sth);
			th.start();
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	//学习线程同步
	public static void learnThreadSync(){
		
	}
}
//第一种方法继承Thread并重写run方法
class MyThread extends Thread{
	public void run(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//第二种方法实现Runnable接口，并实现run方法
class SecondThread implements Runnable{
	public void run(){
		try {
			System.out.println("=====");
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class BankAccount{
	private int balance = 0;
	
	public boolean deposit(int balance,String user){
		if(balance==0)
			return false;
		else{
			synchronized (this) {
				System.out.println("当前余额："+this.balance);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.balance += balance;
				System.out.println(user+"余额："+this.balance);
			}
			return true;
		}
	}
}
class BankThread extends Thread{
	private BankAccount account;
	private String user;
	public BankThread(BankAccount account,String user){
		this.account = account;
		this.user = user;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName());
		account.deposit(100,user);
	}
}
