<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>site about security</title>
</head>
<body>
<p><%=request.getAttribute("msg") %></p>
<a href="secure">przejdz do drugiej strony</a>
<a href="register">przejdz do rejestracji</a>
<form action="logout" method="post">
<input type="submit" value="logout"/>
</form>
</body>
</html>