<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.common"%>
<c:import url="../layout/header1.jsp">
	<c:param name="title" value="About" />
</c:import>
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
<section id="contact" class="contact">
	<div class="container" data-aos="fade-up">
		<div class="section-title">
			<h3>
				<span>Contact Us</span>
			</h3>
			<p>How can we help you?</p>
		</div>
		<div class="row" data-aos="fade-up" data-aos-delay="100">
			<div class="col-lg-6 col-md-6">
				<div class="info-box  mb-4">
				<a href="mailto:myominor792@gmail.com">
					<i class="fa fa-envelope"></i>
					<h3>Email Us</h3>
					<p>myominor792@gmail.com</p>
				</a>
				</div>
				
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="info-box  mb-4">
					<i class="fa fa-phone"></i>
					<h3>Call Us</h3>
					<p>+959 751 007 386</p>
				</div>
			</div>
		</div>
	</div>
</section>
	<!-- Jsp include tag for footer -->
	<jsp:include page="../layout/footer2.jsp" />