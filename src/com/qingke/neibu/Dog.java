package com.qingke.neibu;

public class Dog {
	public String name;
	public DogFooter footer;
	public boolean equals(Object o){
		Dog d=(Dog)o;
		return d.name==this.name;
	}
	public Dog(){
		name = "tt";
		footer = new DogFooter();
	}
	private class DogFooter{
		public void print(){
			System.out.println(name);
		}
	}
	private class Food{
		public void beEat(){
			System.out.println("被吃了");
		}
	}
	public void eat(Food foot){
		foot.beEat();
	}
	
	public static void main(String[] srgs){
		Dog dog = new Dog();
		dog.footer.print();
		System.out.println(dog.name);
		dog.eat(dog.new Food(){
			public void beEat(){
				System.out.println("被吃了啊");
			}
		});
		
		String a = "123";
		String b = new String("123");//"1123".substring(1);
		System.out.println(b);
		System.out.println(a==b);
	}
}
