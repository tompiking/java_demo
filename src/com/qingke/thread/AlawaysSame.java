package com.qingke.thread;

import java.util.Random;

public class AlawaysSame{

	public static void main(String[] args) {
		EnergyBox box = new EnergyBox(100, 100);
		Thread th = new Thread(box);
		th.start();
	}
}

class Energy implements Runnable{
	private int maxEnergy;
	private int index;
	private static Object objLock = new Object();
	public Energy(int maxEnergy,int index){
		this.maxEnergy = maxEnergy;
		this.index = index;
	}
	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}
	public int getMaxEnergy() {
		return this.maxEnergy;
	}
	@Override
	public void run() {
		while(true){
			this.exchange(index,new Random().nextInt(EnergyBox.energyBox.length),new Random().nextInt(maxEnergy));
		}
		
	}
	
	public void exchange(int from,int to,int energyValue){
		synchronized (objLock) {
			while(maxEnergy<=energyValue){
				try {
					objLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(energyValue!=0){
				this.maxEnergy -= energyValue;
				Energy toEnergy = EnergyBox.energyBox[to];
				toEnergy.setMaxEnergy(toEnergy.getMaxEnergy()+energyValue);
				System.out.println(from+"===>"+to+"交换能量:"+energyValue +"总能量:"+EnergyBox.getTotal());
			}
			objLock.notifyAll();
		}
	}
}

class EnergyBox implements Runnable{
	public static Energy[] energyBox;
	
	public EnergyBox(int count,int maxEnergy){
		energyBox = new Energy[count];
		for(int i=0;i<count;i++){
			energyBox[i] = new Energy(maxEnergy,i);
		}
	}
	@Override
	public void run() {
		for(Energy energy : energyBox){
			Thread th = new Thread(energy);
			th.start();
		}
	}
	
	public static int getTotal(){
		int total = 0;
		for(Energy en : energyBox){
			total += en.getMaxEnergy();
		}
		return total;
	}
}

