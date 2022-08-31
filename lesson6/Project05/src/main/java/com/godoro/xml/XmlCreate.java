package com.godoro.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlCreate {
	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
		Document document = XmlUtilities.create("employee");
		Element employee = document.getDocumentElement();
		employee.setAttribute("id", "401");
		XmlUtilities.addSingleElementText(document, employee, "name", "Neşet Ertaş");
		XmlUtilities.addSingleElementText(document, employee, "salary", 9845);
		long id = XmlUtilities.getAttribute(employee, "id", 0);
		String name = XmlUtilities.getSingleElementText(employee, "name", "");
		double salary = XmlUtilities.getSingleElementText(employee, "salary", 0);
		System.out.println(+id+" " + name + " " + salary);
		
		
		String path = "/home/kam/Documents/employee.xml";
		XmlUtilities.dump(document, path);
	}
}
