<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" href="Front.css">
</head>
<body>
<%
	HttpSession session1=request.getSession(false);
	if(session1 !=null && session1.getAttribute("username") !=null) {
		String username=(String) session1.getAttribute("username");
	%>	
	
	
    <div class="container">
    <h1>Welcome,<%= username %>!</h1>
   
    <p>We're Delighted to have you on our platform.⭐</p>
   
    <h3>Explore, learn, and connect✈️ with our vibrant community!</h3>
    <p>Feel free to stay as long as you like, and when you're ready</p>
    you can <a href="logout">Logout</a> securely.👍
        
    </div>
    <%
    }
    else
    {
		response.sendRedirect("LoginPage.html");
	}
	%>
</body>
</html>