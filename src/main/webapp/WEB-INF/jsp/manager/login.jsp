<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../layout/header1.jsp">
	<c:param name="title" value="Ngwe Oo Bus Route Login" />
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
	max-width: 500px;
	margin: 130px auto 80px;
	padding: 10px 45px 30px 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
	border-radius: 10px;
}

.form p {
	font-size: 25px;
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
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" class="d-flex align-items-center">
		<div class="container d-flex align-items-center justify-content-between">
			<h1 class="logo">
				Ngwe Oo Bus Route Control Management System<span>.</span>
			</h1>
			<nav id="navbar" class="navbar">
				<ul>
					<li><a class="nav-link scrollto" href="contact">Contact</a></li>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
		</div>
	</header>
	<!-- End Header -->
<c:if test="${resultFlag==0}">
			  <div class="alert alert-danger alert-dismissible fade show center" role="alert" >
                   ${message}
                  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
         </c:if>
<div class="form">
        
            <ul class="nav nav-tabs d-flex" id="myTabjustified" role="tablist">
                    <li class="nav-item flex-fill" role="presentation">
                             <button class="nav-link w-100 active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-justified" type="button" role="tab" aria-controls="home" aria-selected="true">Manager Login</button>
                   </li>
                   <li class="nav-item flex-fill" role="presentation">
                             <button class="nav-link w-100" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-justified" type="button" role="tab" aria-controls="profile" aria-selected="true">Driver Login</button>
                   </li>         
          </ul>
          
           <div class="tab-content pt-2" id="myTabjustifiedContent">
             <div class="tab-pane fade show active " id="home-justified" role="tabpanel" aria-labelledby="home-tab">
                 <p>Manager Login</p>
		          <form:form method="post" action="validateManager" modelAttribute="manager">
			                <form:input  path="managerEmail" placeholder="email" required="true"/>
			                <form:input type="password" path="managerPassword" placeholder="password" required="true"/>
			                <button >login</button>
			                <!-- <p class="message"><a href="forgotPassword">Password Forgot? </a></p> -->
		         </form:form>
            </div>
    
              <div class="tab-pane fade show " id="profile-justified" role="tabpanel" aria-labelledby="profile-tab">
                   <p>Driver Login</p>
                    <form:form method="post" action="validateDriver" modelAttribute="driver">
                              <form:input  path="driverEmail"    placeholder="email"    required="true"/>
			                  <form:input  path="driverPassword" placeholder="password" required="true" type="password"/>
			                  <button >login</button>
			                <!--   <p class="message"> <a href="forgotPassword">Password Forgot?</a></p> -->
		            </form:form>
              </div>
          </div>
      </div>

	<!-- Jsp include tag for footer -->
	<jsp:include page="../layout/footer2.jsp" />