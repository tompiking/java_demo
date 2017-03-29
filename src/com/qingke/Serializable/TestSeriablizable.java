package com.qingke.Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSeriablizable {
	
	public static void main(String[] args){
		Student stu = new Student("tom", "ÄÐ", 10);
		try {
			ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("Student2.txt"));
			oot.writeObject(stu);
			oot.close();
			
			ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("Student2.txt"));
			Object o = ooi.readObject();
			
			ooi.close();
			System.out.println(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
