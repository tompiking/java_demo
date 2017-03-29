package com;


public class MyQueue {
	static int n=4;
	static int a[]=new int[n];
	static int b[]=new int[n];
	static int d=0;
	static void add(int c){
		
		if(a[n-1]==0){
			for(int i=0;i<n;i++){
				if(a[i]==0){
					a[i]=c;
					b=new int [n];
					b=a;
					break;
				}
			}
		}else{
			d=n;
			n=2*n;
			a=new int [n];
			for(int i=0;i<b.length;i++){
				a[i]=b[i];
			}
			a[d]=c;
			System.out.println("======================"+n);
		}
		
	}
	public static void main (String args[]){
		for(int j=0;j<100;j++){
			add(100);
		}
		for(int i=0;i<a.length;i++){
			System.out.println(i+"=="+a[i]);
		}
	}

}
