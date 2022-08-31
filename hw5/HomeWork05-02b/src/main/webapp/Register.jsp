<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.homework.encryption.Encryption, com.homework.manager.UserManager,com.homework.entity.User"%>
<%
String username="";
String password="";
String message="";
if(request.getParameter("btn-register")!=null){
	
	username=request.getParameter("username");
	password=request.getParameter("password");
	if(password.length()>=6){
		
		String encryptedPassword = Encryption.get_SHA_512_SecurePassword(password);
		User user = new User(0,username,encryptedPassword);
		UserManager userManager = new UserManager();
		boolean isCreated = userManager.createUser(user);

		if(isCreated){
			session.setAttribute("username", username);
			response.sendRedirect("Home.jsp");
		}
		
		else{
			message="Kullancı ismi var, farkli kullanıcı ismi giriniz";
		}
		
	}else{
		
		message ="Şifre 6 karakterden az olmamalıdır";
	}
	
}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kayıt</title>
</head>

<body>
<h1>Kayıt</h1>
<br/>
<form action="Register.jsp" method="POST">
		Kullancı Ismi: <input type="text" name="username" value="<%=username %>"><br/><br/>
		Şifre: <input type="text" name="password" value="<%=password %>"><br/><br/>
		<input type="submit" name="btn-register" value="Kayıt ol" ><br/><br/>
	</form>
	<a href="Login.jsp">Zaten kayıtlı?</a>
	<br/>
	<br/>
	<%=message %>
</body>
</html>