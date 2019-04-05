<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
</head>
<body>
<h2>User registartion page!</h2>
<s:form action="register" method="post" modelAttribute="user">
User name: <s:input path="name"/><br/>
Email : <s:input path="email"/><br/>
Password: <s:password path="password"/><br/>
<input type="submit" value="Register"/>
</s:form>
</body>
</html>