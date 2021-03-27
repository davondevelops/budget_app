<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Budget </title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/Navigation-with-Button.css">

</head>
<body>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
        <div class="container"><a class="navbar-brand" href="#">Budgetapp</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1"><a class="text-dark" href="#">Add new Expense</a><a class="text-dark" href="#">Add new goal</a><a class="text-dark" href="#">Am I on track?</a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"></li>
                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" href="#">Account</a>
                        <div class="dropdown-menu"><a class="dropdown-item" href="/schedule">Schedule</a><a class="dropdown-item" href="#">Add Revenue</a><a class="dropdown-item" href="#">View Savings<br></a><a class="dropdown-item" href="#">Edit Savings</a><a class="dropdown-item" href="#">Achievements</a><a class="dropdown-item" href="#">Account Info</a></div>
                    </li>
                </ul><button class="btn btn-danger border rounded-pill" id="nav-btn" type="button">Logout</button><span class="navbar-text actions"> </span>
            </div>
        </div>
    </nav>
    <div class="container" id="header">
        <div class="row">
            <div class="col">
                <h1>Welcome, ${user.name }</h1>
            </div>
        </div>
        <div class="row" id="info">
            <div class="col">
                <h3>Income</h3>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${weeklyIncome }</h4>
                        <p class="card-text"></p>
                    </div>
                </div>
                <h6 class="text-center text-muted mb-2">Amount per month</h6>
            </div>
            <div class="col">
                <h3>Expense</h3>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${weeklyExpenses}</h4>
                        <p class="card-text"></p>
                    </div>
                </div>
                <h6 class="text-center text-muted mb-2">Amount per Yer</h6>
            </div>
            <div class="col">
                <h3>Savings</h3>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${savings.checkingBalance }</h4>
                        <p class="card-text"></p>
                    </div>
                </div>
                <h6 class="text-center text-muted mb-2">${savings.savingBalance }</h6>
            </div>
        </div>
    </div>
    <div class="container" style="margin-top: 40px;">
        <div class="row">
            <div class="col">
                <h3>Next Payday</h3>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Next Payday Amount</h4>
                        <p class="card-text"></p>
                    </div>
                </div>
                <h6 class="text-center text-muted mb-2"></h6>
            </div>
            <div class="col">
                <h3>Next Bill</h3>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Next Major Bill</h4>
                        <p class="card-text"></p>
                    </div>
                </div>
                <h6 class="text-center text-muted mb-2">Can You Make it</h6>
            </div>
            <div class="col">
                <h3>Next Goal</h3>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Next goal</h4>
                        <p class="card-text"></p>
                    </div>
                </div>
                <h6 class="text-center text-muted mb-2">Are you on track to reach it?</h6>
            </div>
        </div>
    </div>
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>