package com.qingke.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


public class TestXMLbinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = new String[10];
		System.out.println(a.getClass());
		Student stu = new Student("tom","ÄÐ",10);
		JAXBContext content;
		try {
			content = JAXBContext.newInstance(Student.class);
			FileOutputStream file = new FileOutputStream("studeng.xml");
			content.createMarshaller().marshal(stu, file);
			
			Object o = content.createUnmarshaller().unmarshal(new File("studeng.xml"));
			content.createUnmarshaller();
			System.out.println(o.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
class Student{
	@XmlElementWrapper
	ArrayList<Student> students = new ArrayList<Student>();
	@XmlElement(name="name")
	public String name;
	@XmlElement(name="gender")
	private String gender;
	@XmlElement(name="age")
	private int age;
	
	public Student(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Student() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
}
