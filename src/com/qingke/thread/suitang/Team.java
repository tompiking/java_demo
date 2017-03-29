package com.qingke.thread.suitang;

public class Team implements Runnable {
	public boolean flag=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			for(int i=0;i<6;i++){
				System.out.println(Thread.currentThread().getName()+"¹¥»÷["+i+"]");
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"½áÊøÕ½¶·");
	}
}
