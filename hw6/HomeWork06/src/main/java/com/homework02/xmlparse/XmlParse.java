package com.homework02.xmlparse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.homework.xmlutil.XmlUtilities;

public class XmlParse {
	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.home") + "/Documents/Students.xml";
		Document document = XmlUtilities.parse(path);

		Element root = document.getDocumentElement();

		NodeList students = root.getElementsByTagName("student");
		for (int i = 0; i < students.getLength(); i++) {
			Element student = (Element) students.item(i);
			long studentId = XmlUtilities.getAttribute(student, "id", 0);
			String studentName = XmlUtilities.getSingleElementText(student, "name", "");
			double studentMark = XmlUtilities.getSingleElementText(student, "mark", 0);
			System.out.println("Student ID: " + studentId);
			System.out.println("Studnet Name: " + studentName);
			System.out.println("Student Mark: " + studentMark);
		}
	}
}
