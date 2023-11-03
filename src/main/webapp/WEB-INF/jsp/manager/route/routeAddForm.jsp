<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<c:import url="../../layout/header.jsp">
	<c:param name="title" value="Route Register Page" />
</c:import>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

	<div class="d-flex align-items-center justify-content-between">
		<a href="managerForm" class="logo d-flex align-items-center"> <img
			src="<%=common.url%>/assets/img/icon1.jpg" alt=""> <span
			class="d-none d-lg-block">Manager Panel</span>
		</a> <i class="fas fa-bars toggle-sidebar-btn"></i>
	</div>
	<!-- End Logo -->


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
			data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
				<i class="fa fa-users" aria-hidden="true"></i><span>Driver</span><i
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
						  <li class="breadcrumb-item active"><a href="routeListForm">Route
									List</a></li>
							<li class="breadcrumb-item active">Add Route</li>
					
						</ol>
					</nav>
				</div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
					   <div  class="row mb-3">
						<h5 class="card-title" align="center">Route Register Form</h5>
						</div>
						<form:form class="row g-3"
							action="/NgweOoBusRouteControlManagementSystem/saveRoute" method="post"
							modelAttribute="route">
							<div class="row mb-3">
								<label for="departurePoint" class="col-sm-4 col-form-label">Departure
									Point </label>
								<div class="col-sm-8">
									<form:input class="form-control" id="inputText"
										path="departurePoint" value="${route.departurePoint }"
										required="true" />
								</div>
							</div>
							<div class="row mb-3">
								<label for="destinationPoint" class="col-sm-4 col-form-label">Destination
									Point </label>
								<div class="col-sm-8">
									<form:input class="form-control" id="inputText"
										path="destinationPoint" value="${route.destinationPoint }"
										required="true" />
								</div>
							</div>
							<div class="row mb-3">
								<label for="timeRequired" class="col-sm-4 col-form-label">Required
									Time(hour) </label>
								<div class="col-sm-8">
									<form:input type="number" class="form-control" id="inputText"
										path="timeRequired" value="${route.timeRequired }"
										required="true" />
								</div>
							</div>
							<div class="row mb-3">
								<label for="fare" class="col-sm-4 col-form-label">Fare </label>
								<div class="col-sm-8">
									<form:input type="number" class="form-control" id="inputText" path="fare"
										value="${route.fare }" required="true" />
								</div>
							</div>
							<div class="row mb-3 text-center">
								<div class="col-md-6">
									<a href="/NgweOoBusRouteControlManagementSystem/routeListForm"><button type="button" class="btn modalbutton btn-primary"
										style="width: 100%;" data-bs-dismiss="modal">Cancel</button></a>
								</div>
								<div class="col-sm-6">
									<button type="submit" class="btn btn-primary"
										style="width: 100%;">Add</button>
								</div>
							</div>
						</form:form>
						<!-- End Route Edit Form -->
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</main>
<!-- End #main -->
<!-- Jsp include tag for footer -->
<c:import url="../../layout/footer.jsp">
</c:import>
