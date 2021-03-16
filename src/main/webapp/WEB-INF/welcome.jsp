<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >



</head>
</head>
<body>
	<div class=	"container w-75 p-3 mx-auto">
		<h2 class="text-center">Welcome ${user.name}</h2>
		<div id="form">
			<h2 class="text-center">Mind answering some questions to get started?</h2>
			<a class="btn btn-primary" href="/revenues/new" >Yes</a>
			<a class="btn btn-warning" href="/dashboard" >No</a>
		</div>
	</div>
</body>
</html>