<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<c:import url="../../layout/header.jsp">
	<c:param name="title" value="Driver Edit Page" />
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
				<li><a href="/NgweOoBusRouteControlManagementSystem/inUseListForm"> <i class="fa fa-list"></i><span>Bus
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
				<li><a href="/NgweOoBusRouteControlManagementSystem/driverListForm"> <i class="fa fa-list"></i><span>Driver
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
				<li><a href="/NgweOoBusRouteControlManagementSystem/busListForm"> <i class="fas fa-list"></i><span>Bus
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
				<li><a href="/NgweOoBusRouteControlManagementSystem/busTypeListForm"> <i class="fas fa-th-list"></i><span>Bus
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
				<li><a href="/NgweOoBusRouteControlManagementSystem/routeListForm"><i class="fas fa-th-list"></i><span>Route
							List</span> </a></li>
			</ul></li>


		<li class="nav-item"><a class="nav-link collapsed"
			href="signOut" onClick="myFunction();"> <i class="fa fa-arrow-right"></i> <span>Log
					Out</span>
		</a></li>
		<!-- End F.A.Q Page Nav -->
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
							<li class="breadcrumb-item"><a href="/NgweOoBusRouteControlManagementSystem/managerForm">Home</a></li>
							<li class="breadcrumb-item active"><a href="/NgweOoBusRouteControlManagementSystem/driverListForm">Driver
									 List</a></li>
									 <li class="breadcrumb-item active"><a
								href="/NgweOoBusRouteControlManagementSystem/driverForm">Add Driver</a></li>
						</ol>
					</nav>
				</div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
					   <div  class="row mb-3">
						<h5 class="card-title" align="center">Driver View Form</h5>
						</div>
						<form:form class="row g-3"
							action="#" method="post" modelAttribute="driver">
							
							<div class="row mb-3">
								<label for=driverId class="col-sm-4 col-form-label">Driver
									ID</label>
								<div class="col-sm-8">
									<form:input class="form-control" id="inputText"
										path="driverId" value="${driver.driverId }" readonly="true" />
								</div>
							</div>
							
							<div class="row mb-3">
								<label for="busTypeName" class="col-sm-4 col-form-label">Driver
									Name</label>
								<div class="col-sm-8">
									<form:input class="form-control" id="inputText"
										path="driverName" value="${driver.driverName }" readonly="true"  />
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputEmail3" class="col-sm-4 col-form-label">Phone</label>
								<div class="col-sm-8">
									<form:input class="form-control" id="driverPhone"
										path="driverPhone" value="${driver.driverPhone}" readonly="true" />
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputEmail3" class="col-sm-4 col-form-label">Email</label>
								<div class="col-sm-8">
									<form:input type="email" class="form-control" id="driverEmail"
										path="driverEmail" value="${driver.driverEmail}" readonly="true"  />
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputEmail3" class="col-sm-4 col-form-label">Address</label>
								<div class="col-sm-8">		
										
								<form:textarea class="form-control" placeholder="Address"
									style="height: 100px; margin-top: 20px;"
									path="driverAddress" readonly="true" />
									
								</div>
							</div>
							<div class="row mb-3 text-center">

								<div class="col-sm-8">
								</div>
									<div class="col-sm-4">
									<a href="/NgweOoBusRouteControlManagementSystem/driverListForm"><button type="button" class="btn btn-primary"
										style="width: 100%;">Cancel</button></a>
								</div>
							</div>
						</form:form>
						<!-- End Horizontal Form -->
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
