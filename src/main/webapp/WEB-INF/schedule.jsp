<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Schedule</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/Navigation-with-Button.css">
<link rel="stylesheet" href="/resources/css/schedule.css">
</head>
<body>
	<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
        <div class="container"><a class="navbar-brand" href="dashboard">Budgetapp</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1"><a class="text-dark" href="expense/new">Add new Expense</a><a class="text-dark" href="#">Add new goal</a><a class="text-dark" href="#">Am I on track?</a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"></li>
                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" href="#">Account</a>
                        <div class="dropdown-menu"><a class="dropdown-item" href="/schedule">Schedule</a><a class="dropdown-item" href="revenues/new">Add Revenue</a><a class="dropdown-item" href="#">View Savings<br></a><a class="dropdown-item" href="savings/add">Edit Savings</a><a class="dropdown-item" href="#">Achievements</a><a class="dropdown-item" href="#">Account Info</a></div>
                    </li>
                </ul><button class="btn btn-danger border rounded-pill" id="nav-btn" type="button">Logout</button><span class="navbar-text actions"> </span>
            </div>
        </div>
    </nav>
	<div id="main">
		<div id="calcontainer">
                <div id="calcalendar">
                    <div class="month">
                        <i class="fas fa-angle-left prev"></i>
                        <div class="date">
                            <h1></h1>
                            <p></p>
                        </div>
                        <i class="fas fa-angle-right next"></i>
                    </div>
                    <div class="weekdays">
                        <div>Sun</div>
                        <div>Mon</div>
                        <div>Tue</div>
                        <div>Wed</div>
                        <div>Thu</div>
                        <div>Fri</div>
                        <div>Sat</div>
                    </div>
                    <div class="days"></div>
                </div>
                <script src="/resources/js/calendar.js"></script>
		</div>
	</div>
</body>
</html>