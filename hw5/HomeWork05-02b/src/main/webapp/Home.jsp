<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("Login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>
		Hoşgeldin
		<%=session.getAttribute("username")%>
	</h1>
	<br />
	<a href="Logout.jsp">Çık</a>
</body>
</html>