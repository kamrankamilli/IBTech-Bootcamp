package com.godoro.xml;



import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlBuild {

	public static void main(String[] args) throws Exception {
		//JAXP
		String path = "file:///home/kam/Documents/product.xml";
		Document document = XmlUtilities.parse(path);
		
		//DOM
		Element product = document.getDocumentElement();
		long id = XmlUtilities.getAttribute(product,"id",0);
		System.out.println("Özdeşlik: " + id);
		
		String name =XmlUtilities.getSingleElementText(product,"id","");
		System.out.println("Ad: " + name);
		double price = XmlUtilities.getSingleElementText(product,"price",0);
		System.out.println("Eder: " + price);
	}

}
