<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.homework.encryption.Encryption, com.homework.manager.UserManager, com.homework.entity.User"%>
<%
String username="";
String password="";
String message="";

if(request.getParameter("btn-login")!=null){
	username=request.getParameter("username");
	password=request.getParameter("password");
	String encryptedPassword = Encryption.get_SHA_512_SecurePassword(password);
	UserManager userManager = new UserManager();
	User user = userManager.findByUserName(username);
	
	if(user!=null && user.getUserPassword().equals(encryptedPassword)){
		session.setAttribute("username", username);
		response.sendRedirect("Home.jsp");
	}
	else{
		message="Girdiyiniz bilgiler yanlış";
	}	
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giriş</title>
</head>

<body>
<h1>Giriş</h1>
<br/>
	<form action="Login.jsp" method="POST">
		Kullancı Ismi: <input type="text" name="username" value="<%=username %>"><br/><br/>
		Şifre: <input type="text" name="password" value="<%=password %>"><br/><br/>
		<input type="submit" name="btn-login" value="Giriş yap" ><br/><br/>
	</form>
	<a href="Register.jsp">Kayıt ol</a>
	<br/>
	<br/>
	<%=message %>
</body>
</html>