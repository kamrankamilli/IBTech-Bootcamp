<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.homework.rectangle.Rectangle"%>
<%
double width = 0;
double length = 0;
double area = 0;
double perimeter = 0;
if (request.getParameter("btn-calculate") != null) {
	width = Double.parseDouble(request.getParameter("width"));
	length = Double.parseDouble(request.getParameter("length"));
	Rectangle rectangle = new Rectangle(width, length);
	area = rectangle.getArea();
	perimeter = rectangle.getPerimeter();
}
%>