<%@page import="java.util.Base64"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%User u=(User)request.getSession().getAttribute("user");%>
<h1>Welcome <%= u.getUsername() %></h1>
<%String image=new String(Base64.getEncoder().encode(u.getUserimage())); %>
<img alt="" src="data:image/jpeg;base64,<%=image%>" width="150" height="100">
</body>
</html>
