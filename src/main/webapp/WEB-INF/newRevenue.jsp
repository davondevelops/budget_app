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
		<form:form class="form-group col-8 mx-auto" action="/revenue/add" method="POST" modelAttribute="revenue">
			<h3>Enter Revenue</h3>
			
			<form:hidden path="user" value="${user.id }"/>
			
			<form:label path="name">Name</form:label>
			<form:errors class="text-danger" path="name"/>
			<form:input class="form-control" path="name"/>
			
			<form:label path="frequency">Frequency</form:label>
			<form:errors path="frequency" class="text-danger"/>
			<form:select path="frequency" class="form-control">
				<form:option  value="1" >Weekly</form:option>
				<form:option value="2">Bi-weekly</form:option>
				<form:option value="3">Monthly</form:option>
			</form:select>
			
			<form:label path="amount">Amount</form:label>
			<form:errors class="text-danger" path="amount"/>
			<form:input class="form-control" path="amount"/>
			
			<input type="submit" value="Add Revenue"/>
		</form:form>
	</div>
</body>
</html>