package com.homework01.xmlparse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.homework.xmlutil.XmlUtilities;

public class XmlParse {
	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.home") + "/Documents/Student.xml";
		Document document = XmlUtilities.parse(path);

		Element student = document.getDocumentElement();

		long studentId = XmlUtilities.getAttribute(student, "id", 0);
		System.out.println("Studen ID: " + studentId);

		String studentName = XmlUtilities.getSingleElementText(student, "name", "");
		System.out.println("Student Name: " + studentName);

		double studentMark = XmlUtilities.getSingleElementText(student, "mark", 0);
		System.out.println("Student Mark: " + studentMark);

	}
}
