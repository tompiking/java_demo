package com.qingke.thread;

public class ExtentsAndImp {
	public static void main(String[] args){
		
		Add2 th = new Add2();
		Thread th1 = new Thread(th,"1");
		Thread th2 = new Thread(th,"2");
		th1.start();
		th2.start();
		Thread th4 = new Add1(th);
		Thread th3 = new Add1(th);
		th4.setName("4");
		th3.setName("5");
		th3.start();
		th4.start();
	} 
}

class Add1 extends Thread{
	public int count = 5;
	public Add2 add2;
	public Add1(Add2 add){
		add2 = add;
	}
	@Override
	public void run() {
		while(true){
			synchronized (add2) {
				if(count>10)
					break;
				count++;
				System.out.println(Thread.currentThread().getName()+"=="+count);
			}
		}
	}
}

class Add2 implements Runnable{
	public int count = 5;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(count<=10){
			synchronized (this) {
				if(count>10)
					break;
				count++;
				System.out.println(Thread.currentThread().getName()+"=="+count);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
