package com.homework03.generatexml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.homework.xmlutil.XmlUtilities;

public class XmlGenerate {
	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
		Document document = XmlUtilities.create("student");
		Element root = document.getDocumentElement();
		root.setAttribute("id", "601");
		XmlUtilities.addSingleElementText(document,root,"name","Yıldırım Gürses");
		XmlUtilities.addSingleElementText(document,root,"mark",2.7);
		
		String path =  System.getProperty("user.home") + "/Documents/Generated.xml";
		XmlUtilities.dump(document,path);
		
	}
}
