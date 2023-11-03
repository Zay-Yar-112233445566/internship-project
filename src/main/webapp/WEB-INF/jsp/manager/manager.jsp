<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="util.common"%>
<%@ page import="com.java.beans.*"%>
<c:import url="../layout/header.jsp">
	<c:param name="title" value="Manager Page" />
</c:import>

<%
    if(session.getAttribute("managerSession")==null){
    	response.sendRedirect("loginForm");
    }
    Manager manager=(Manager) session.getAttribute("managerSession");
%>
<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

	<div class="d-flex align-items-center justify-content-between">
		<a href="managerForm" class="logo d-flex align-items-center"> <img
			src="<%=common.url%>/assets/img/icon1.jpg" alt=""> <span
			class="d-none d-lg-block">Manager Panel</span>
		</a> <i class="fas fa-bars toggle-sidebar-btn"></i>
	</div>
	<!-- End Logo -->

	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">

			<li class="nav-item d-block d-lg-none"><a
				class="nav-link nav-icon search-bar-toggle " href="#"> <i
					class="fa fa-chevron-down ms-auto"></i>
			</a></li>
			<!-- End Search Icon-->

			<li class="nav-item dropdown pe-3"><a
				class="nav-link nav-profile d-flex align-items-center pe-0"
				href="#" data-bs-toggle="dropdown"> <span
					class="d-none d-md-block dropdown-toggle ps-2"><%=manager.getManagerName()%> Profile</span>
			</a> <!-- End Profile Iamge Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li class="dropdown-header">
						 <span>System Manager</span>
					</li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="userprofile"> <i class="fas fa-person"></i> <span>My
								Profile</span>
					</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="userprofile"> <i class="fas fa-gear"></i> <span>Account
								Settings</span>
					</a></li>

				</ul> <!-- End Profile Dropdown Items --></li>
			<!-- End Profile Nav -->

		</ul>
	</nav>
	<!-- End Icons Navigation -->

</header>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

	<ul class="sidebar-nav" id="sidebar-nav">

		<li class="nav-item"><a class="nav-link " href="managerForm">
				<i class="fa fa-th-large" aria-hidden="true"></i> <span>Dashboard</span>
		</a></li>
		<!-- End Dashboard Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#component-nav" data-bs-toggle="collapse" href="#">
				<i class="fa fa-calendar-check-o" aria-hidden="true"></i> <span>Bus
					Calendar</span><i class="fa fa-chevron-down ms-auto"></i>

		</a>
			<ul id="component-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="inUseListForm"> <i class="fa fa-list"></i><span>Bus
							Calendar List</span>
				</a></li>
			</ul></li>
		<!-- End Components Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#components-nav" data-bs-toggle="collapse"
			href="dirverListForm"> <i class="fa fa-users" aria-hidden="true"></i><span>Driver</span><i
				class="fa fa-chevron-down ms-auto"></i>

		</a>
			<ul id="components-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="driverListForm"> <i class="fa fa-list"></i><span>Driver
							List</span>
				</a></li>
			</ul></li>
		<!-- End Components Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#"> <i
				class="fas fa-bus"></i><span>Bus</span><i
				class="fa fa-chevron-down ms-auto"></i>
		</a>
			<ul id="forms-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="busListForm"> <i class="fas fa-list"></i><span>Bus
							List</span>
				</a></li>
			</ul></li>
		<!-- End Forms Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
				<i class="fa fa-th-list"></i><span>Bus Type</span><i
				class="fa fa-chevron-down ms-auto"></i>
		</a>
			<ul id="tables-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="busTypeListForm"> <i class="fas fa-th-list"></i><span>Bus
							Type List</span>
				</a></li>
			</ul></li>
		<!-- End Tables Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
				<i class="fas fa-route"></i><span>Route</span><i
				class="fa fa-chevron-down ms-auto"></i>
		</a>
			<ul id="charts-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><a href="routeListForm"><i class="fas fa-th-list"></i><span>Route
							List</span> </a></li>
			</ul></li>
		<!-- End Charts Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			href="signOut" onClick="myFunction();"> <i class="fa fa-arrow-right"></i> <span>Log
					Out</span>
		</a></li>

	</ul>
	</ul>
<script>
  function myFunction() {
     alert("Sure to Log out!");
     }
</script>
</aside>
<!-- End Sidebar-->

<main id="main" class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="pagetitle">
					<h1>Dashboard</h1>
					<nav>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="managerForm">Home</a></li>
							<li class="breadcrumb-item active">Dashboard</li>
						</ol>
					</	nav>
	     <c:if test="${resultFlag==0}">
			  <div class="alert alert-danger alert-dismissible fade show" role="alert">
                   ${message}
                  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
         </c:if>
         <c:if test="${resultFlag==1}">
			  <div class="alert alert-success alert-dismissible fade show" role="alert">
                   ${message}
                  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
         </c:if>
				</div> 
				<!-- End Page Title -->
				<section class="section dashboard">
					<div class="row">

						<!-- Main Body columns -->
						<div class="col-lg-12">
							<div class="row">

								<!-- Start Total Bus -->
								<div class="col-xxl-4 col-md-4">
									<a href="busListForm">
										<div class="card info-card sales-card">
											<div class="card-body">
												<h5 class="card-title">
													Total <span>| Bus</span>
												</h5>

												<div class="d-flex align-items-center">
													<div
														class="card-icon rounded-circle d-flex align-items-center justify-content-center">
														<i class="fas fa-bus"></i>
													</div>
													<div class="ps-3">
													 <% int busCount=(int)session.getAttribute("busCount"); %>
														<h6>${busCount}</h6>
													</div>
												</div>
											</div>
										</div>
									</a>
								</div>
								<!-- End Total Bus -->

								<!-- Start Route -->
								<div class="col-xxl-4 col-md-4">
									<a href="routeListForm">
										<div class="card info-card sales-card">
											<div class="card-body">
												<h5 class="card-title">
													Total <span>| Route</span>
												</h5>

												<div class="d-flex align-items-center">
													<div
														class="card-icon rounded-circle d-flex align-items-center justify-content-center">
														<i class="fas fa-route"></i>
													</div>
													<div class="ps-3">
                                                         <% int routeCount=(int)session.getAttribute("routeCount");%>  
														<h6>${routeCount}</h6>
													</div>
												</div>
											</div>
										</div>
									</a>
								</div>
								<!-- End Route -->

								<!-- Start Total Booking -->
								<div class="col-xxl-4 col-md-4">
									<a href="busTypeListForm">
										<div class="card info-card sales-card">
											<div class="card-body">
												<h5 class="card-title">
													Total <span>| Bus Type</span>
												</h5>

												<div class="d-flex align-items-center">
													<div
														class="card-icon rounded-circle d-flex align-items-center justify-content-center">
														<i class="fas fa-bus"></i>
													</div>
													<div class="ps-3">
													 <% int busTypeCount=(int)session.getAttribute("busTypeCount"); %>
														<h6>${busTypeCount}</h6>
													</div>
												</div>
											</div>
										</div>
									</a>
								</div>
								<!-- End Total Booking -->


								<!-- Start Total Booked Customer Card -->
								<div class="col-xxl-4 col-md-4">
									<a href="driverListForm">
										<div class="card info-card revenue-card">
											<div class="card-body">
												<h5 class="card-title">
													Total <span>| Driver</span>
												</h5>

												<div class="d-flex align-items-center">
													<div
														class="card-icon rounded-circle d-flex align-items-center justify-content-center">
														<i class="fa fa-person"></i>
													</div>
													<div class="ps-3">
													 <% int driverCount=(int)session.getAttribute("driverCount"); %>
														<h6>${driverCount}</h6>
													</div>
												</div>
											</div>
										</div>
									</a>
								</div>
								<!-- End Total Booked Customer Card -->
								
								<!-- Start Total Booked Customer Card -->
								<div class="col-xxl-4 col-md-4">
									<a href="inUseListForm">
										<div class="card info-card revenue-card">
											<div class="card-body">
												<h5 class="card-title">
													Total <span>| Bus Calendar </span>
												</h5>

												<div class="d-flex align-items-center">
													<div
														class="card-icon rounded-circle d-flex align-items-center justify-content-center">
														<i class="fa fa-book"></i>
													</div>
													<div class="ps-3">
													 <% int busCalendarCount=(int)session.getAttribute("busCalendarCount"); %>
														<h6>${busCalendarCount}</h6>
													</div>
												</div>
											</div>
										</div>
									</a>
								</div>							
		
							</div>
						</div>

					</div>
				</section>
			</div>
		</div>
	</div>

</main>
<!-- Jsp include tag for footer -->
<jsp:include page="../layout/footer.jsp" />