package com.qingke.thread.suitang;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Team t = new Team();
		System.out.println("序幕慢慢拉开");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread wg = new Thread(t,"瓦岗军");
		System.out.println(wg.getName()+"进入战斗序列");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread sj = new Thread(t,"隋军");
		System.out.println(sj.getName()+"进入战斗序列");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wg.start();
		sj.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Hero h = new Hero(t);
		Thread cyj = new Thread(h,"程咬金");
		System.out.println("半路杀出个"+cyj.getName());
		cyj.start();
		try {
			cyj.join();
			sj.join();
			wg.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("结束战斗");
		System.out.println("序幕慢慢关闭");
	}

}
