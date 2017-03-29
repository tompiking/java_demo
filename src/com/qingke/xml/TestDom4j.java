package com.qingke.xml;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDom4j {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read("sample.xml");
			Element root = doc.getRootElement();
//			List<Element> list = root.elements();
//			Iterator<Element> it = list.iterator();
			Iterator<Element> it = root.elementIterator();
			while(it.hasNext()){
				System.out.println(it.next().getName());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
