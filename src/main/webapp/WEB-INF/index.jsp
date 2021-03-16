<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
</head>
<body>
	<div class=	"container w-75 p-3 mx-auto">
		<form:form class="form-group col" action="/register" method="POST" modelAttribute="user">
		
			<h1>Register</h1>
			
			<form:label path="name">Name</form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path ="name" class="form-control"/>
			
			<form:label path="email">Email</form:label>
			<form:errors path="email" class="text-danger"/>
			<form:input type="email" path ="email" class="form-control"/>
			
			<form:label path="password">Password</form:label>
			<form:errors path="password" class="text-danger"/>
			<form:password path ="password" class="form-control"/>
			
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:errors path="confirmPassword" class="text-danger"/>
			<form:password path ="confirmPassword" class="form-control"/>
			
			<input type="submit" value="Register"/>
		</form:form>
		
		<form class="form-group col" action="/login" method="POST" >
			<h1>Login</h1>
			 <p class="text-danger"><c:out value="${error}" /></p>
			
			<label for="email">Email</label>
			<input name ="email" class="form-control"/>
			
			<label for="password">Password</label>
			<input type="password" name ="password" class="form-control"/>
			
			
			<input type="submit" value="Login"/>
		</form>
		
	</div>
</body>
</html>