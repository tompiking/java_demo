package com.qingke.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("sample.xml");
			NodeList list = document.getElementsByTagName("student");
			for(int i = 0;i<list.getLength();i++){
				Node node = list.item(i);
				System.out.println("=============================");
				for(Node atr = node.getFirstChild();atr!=null;atr=atr.getNextSibling()){
					if(atr.getNodeType()!=Node.ELEMENT_NODE) continue;
					System.out.println(atr.getNodeName()+"="+atr.getTextContent());
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
