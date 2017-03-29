package com.qingke.thread;

public class TestWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box b = new Box();
		Cu cu = new Cu(b);
		Pu pu = new Pu(b);
		cu.start();
		pu.start();
	}

}

class Box{
	public int pu;
}

class Cu extends Thread{
	private Box box;
	public Cu(Box box){
		this.box = box;
	}
	public void run(){
		for(int i=0;i<100;i++){
			synchronized (box) {
//				System.out.println("Cu begin");
				while(box.pu==0){
					try {
//						System.out.println("Cu wait");
						box.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
//				System.out.println("Cu go");
				box.pu--;
				System.out.println(box.pu);
				box.notify();
//				System.out.println("Cu end");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Pu extends Thread{
	private Box box;
	public Pu(Box box){
		this.box = box;
	}
	public void run(){
		for(int i=0;i<100;i++){
			synchronized (box) {
//				System.out.println("Pu begin");
				while(box.pu==10){
					try {
//						System.out.println("Pu wait");
						box.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
//				System.out.println("Pu go");
				box.pu++;
				System.out.println(box.pu);
				box.notify();
//				System.out.println("Pu end");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
