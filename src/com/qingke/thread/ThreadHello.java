package com.qingke.thread;

import java.util.ArrayList;

public class ThreadHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printHello();
	}
	
	public static void printHello(){
		ArrayList<Thread> arr = new ArrayList<Thread>(50);
		for(int i=0;i<50;i++){
			Thread th = new CustomThread();
			th.setName("Thread"+(i+1));
			arr.add(th);
		}
		for(int i=50;i>0;i--){
			Thread th = arr.get(i-1);
			th.start();
			try {
				th.join();
				System.out.println("====================");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class CustomThread extends Thread{
	public void run(){
		System.out.println(this.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
