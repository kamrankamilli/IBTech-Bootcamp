<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Calculate.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rectangle Area</title>
</head>
<body>
	<form action="RectangleArea.jsp" method="POST">
		Genişlik: <input type="text" name="width" value="<%=width%>"><br /> <br />
		Uzunluk: <input type="text" name="length" value="<%=length%>"><br /> <br />
		<input type="submit" value="Hesapla" name="btn-calculate"><br />
		<br />
	</form>
	<br /> 
	Alan = <%=area%>
	<br /> 
	Çevre = <%=perimeter%>
</body>
</html>