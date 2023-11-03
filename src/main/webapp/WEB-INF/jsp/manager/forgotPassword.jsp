<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../layout/header1.jsp">
	<c:param name="title" value="About" />
</c:import>
<style>
/*body background css*/
body {
	padding: 0;
	margin: 0;
	background: url(background.jpg) no-repeat;
	background-size: cover;
}

/*login form css*/
.form {
	font-family: "Roboto", sans-serif;
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	opacity: 99%;
	max-width: 460px;
	margin: 130px auto 80px;
	padding: 10px 45px 30px 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
	border-radius: 10px;
}

.form p {
	font-size: 15px;
	padding: 1px;
	text-align: center;
}

.form input {
	outline: 0;
	border-radius: 10px;
	background: #F2F2F2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form input:hover {
	background-color: #D3F8F9;
	transition: all 1s ease 0s;
}

.form input:focus {
	background-color: #D3F8F9;
	transition: all 1s ease 0s;
}

.form button {
	text-transform: uppercase;
	outline: 0;
	border-radius: 10px;
	background: #1ADBE5;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background-color: #06C5CF;
	transition: all 1s ease 0s;
}

.form .message {
	margin: 15px 0 0;
	color: #B3B3B3;
	font-size: 12px;
}

.form .message a {
	color: #06C5CF;
	text-decoration: none;
}
</style>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" class="d-flex align-items-center">
		<div
			class="container d-flex align-items-center justify-content-between">
			<h1 class="logo">
				Ngwe Oo Bus Route Control Management System<span>.</span>
			</h1>
			<nav id="navbar" class="navbar">
				<ul>
					<li><a href="loginForm"> Login</a></li>
					<li><a class="nav-link scrollto" href="contact">Contact</a></li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- .navbar -->
		</div>
	</header>
	<!-- End Header -->
	<div class="form">
		<div class="pt-0 pb-4">
			<h3>Send Email</h3>
			<p>Enter email to get new password</p>
		</div>
		<form:form method="post" action="resendMail" modelAttribute="command">
			<form:input type="email" placeholder="username" path="" />
			<button>Resend</button>
		</form:form>
	</div>
	<!-- Jsp include tag for footer -->
	<jsp:include page="../layout/footer2.jsp" />