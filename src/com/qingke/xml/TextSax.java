package com.qingke.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TextSax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		useSaxReadXml();
	}
	
	public static void useSaxReadXml(){
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			SaxParserHandler hd = new SaxParserHandler("student");
			parser.parse("sample.xml", hd);
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

class SaxParserHandler extends DefaultHandler {
	private Map<String,String> map;//存储正在解析的元素数据
	private List<Map<String,String>> list;//存储所有解析的元素数据
	String currentTag;//正在解析的元素名
	String currentValue;//正在解析的元素数据
	String nodeName;//开始解析的元素
	

	public SaxParserHandler(String nodeName) {
		super();
		this.nodeName = nodeName;
	}
	//
	public void startDocument () throws SAXException{
        list = new ArrayList<Map<String,String>>();
    }

    public void endDocument ()
        throws SAXException
    {
        super.endDocument();
        System.out.println(list);
    }

    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
        if(qName.equals(nodeName)){
        	map = new HashMap<String,String>();
        }
        if(map!=null&&attributes!=null){
        	for(int i = 0; i<attributes.getLength();i++){
        		map.put(attributes.getQName(i), attributes.getValue(i));
        	}
        }
        currentTag = qName;
    }

    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
       if(qName.equals(nodeName)){
    	   list.add(map);
    	   map=null;
       }
    }


    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        if(currentTag!=null && map!=null){
        	currentValue = new String(ch,start,length);
        	if(currentValue!=null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")){
        		map.put(currentTag, currentValue);
        	}
        	currentTag = null;
        	currentValue = null;
        }
    }
	
}
