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
		<form:form class="form-group col-8 mx-auto" action="/savings/update" method="POST" modelAttribute="savings">
			<h3>Enter Savings (optional)</h3>
			
			<form:hidden path="user_id" value="${user.id }"/>
			
			<form:label path="checkingBalance">Checking Balance</form:label>
			<form:errors class="text-danger" path="checkingBalance"/>
			<form:input class="form-control" path="checkingBalance"/>
			
			
			<form:label path="savingBalance">Saving Balance</form:label>
			<form:errors class="text-danger" path="savingBalance"/>
			<form:input class="form-control" path="savingBalance"/>
			
			<input type="submit" value="Add Savings"/>
		</form:form>
	</div>
</body>
</html>