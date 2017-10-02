<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registere</title>
</head>
<body>
	<form:form modelAttribute="user" method="post">
		<form:errors path="*"/>
		<div>
			<form:label path="login">Login</form:label>
			<form:input path="login"/>
		</div>
		<div>
			<form:label path="name">name</form:label>
			<form:input path="name"/>
		</div>
		<div>
			<form:label path="lastName">last name</form:label>
			<form:input path="lastName"/>
		</div>
		<div>
			<form:label path="email">email</form:label>
			<form:input type ="email" path="email"/>
		</div>
		<div>
			<form:label path="password">Password</form:label>
			<form:password path="password"/>
		</div>
		<input type="submit"></input>
	</form:form>
</body>
</html>