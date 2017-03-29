package com.qingke.xml;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class TestJdom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build("sample.xml");
			Element root = doc.getRootElement();
			System.out.println("root:"+root.getName());
			List<Element> list = root.getChildren();
			for(Element e : list){
				if(e.getName().equals("student")){
					System.out.println(e.getChildText("name"));
					System.out.println(e.getChildText("gender"));
					System.out.println(e.getChildText("age"));
				}
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
