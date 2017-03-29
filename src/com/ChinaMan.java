package com;

public class ChinaMan extends Man {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChinaMan p = new ChinaMan();
		System.out.println("com sub");
		System.out.println(p.name);
		p.isMan(p);
		
	}
	
	public ChinaMan(){
		super();
		System.out.println("1111111111111111111111");
	}
	
	private static class PrKj{
		
	}
	
	public void isMan(Person person){
		System.out.println(person.getClass());
		ChinaMan.PrKj t = new ChinaMan.PrKj();
		System.out.println(t.getClass());
	}

}
