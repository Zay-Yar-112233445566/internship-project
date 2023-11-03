<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<c:import url="../../layout/header.jsp">
	<c:param name="title" value="Bus Calendar Register Page" />
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
							<li class="breadcrumb-item"><a href="managerForm">Home</a></li>
							<li class="breadcrumb-item active"><a
								href="/NgweOoBusRouteControlManagementSystem/inUseListForm">Bus
									Calendar List</a></li>
							<li class="breadcrumb-item active">Add Bus
									Calendar
							</li>
						</ol>
					</nav>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="card">
					<div class="card-body">
						<div class="row mb-3">
							<h5 class="card-title" align="center">Bus Calendar Register
								Form</h5>
						</div>
						
						<form:form class="row g-3" action="/NgweOoBusRouteControlManagementSystem/searchValidInfo"  modelAttribute="inUse1" method="post">
						   
						    <div class="row mb-3" style="margin-bottom:50px;">
									<label for="departureDate" class="col-sm-4 col-form-label">Departure Date </label>
									<div class="col-sm-5">
										<form:input type="date" class="form-control" id="departureDate" path="departureDate" value="${departureDate}" required="true"/>
									</div>
								    <div class="col-sm-3">
										<button type="submit" class="btn  btn-primary" style="width: 100%;">Search</button>
									</div>							
							</div>
						</form:form>
								
						<form:form class="row g-3" action="/NgweOoBusRouteControlManagementSystem/saveInUse"  modelAttribute="inUse" method="post">					
							<div class="row mb-3">
								<label for="departureTime" class="col-sm-4 col-form-label">Departure Time</label>
								<div class="col-sm-8">
									<form:input type="time" class="form-control" id="inputText" path="departureTime" value="${inUse.departureTime }" required="true" />
								    <form:input type="date" class="form-control" id="departureDate" path="departureDate" value="${departureDate}" hidden="true"/>
								</div>
							</div>
							<div class="row mb-3">
								<label for="routeId" class="col-sm-4 col-form-label">Route</label>
								<div class="col-sm-8">
									<form:select path="routeId" id="routeId" class="form-control"
										required="true">
										<%
										int index = 1;
										%>
										<c:forEach var="route" items="${routeList}">
											<form:option check="true" value="${route.routeId}">
												<%=index++%>.${route.departurePoint}/${route.destinationPoint}
											   </form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="row mb-3">
								<label for="busId" class="col-sm-4 col-form-label">Bus </label>
								<div class="col-sm-8">
									<form:select path="busId" id="busId" class="form-control"
										required="true">
										<%
										int index = 1;
										%>
										<c:forEach var="availableBus" items="${availableBus}">
											<form:option check="true" value="${availableBus.busId}">
												<%=index++%>. BID-${availableBus.busId}-(${availableBus.busTypeName})
											   </form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="row mb-3">
								<label for="driverId" class="col-sm-4 col-form-label">Driver</label>
								<div class="col-sm-8">
									<form:select path="driverId" id="busId" class="form-control"
										required="true">
										<%
										int index = 1;
										%>
										<c:forEach var="availableDriver" items="${availableDriver}">
											<form:option check="true" value="${availableDriver.driverId}">
												<%=index++%>.${availableDriver.driverName}(DID-${availableDriver.driverId})
											   </form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="row mb-3 text-center">
								<div class="col-md-6">
									<a href="/NgweOoBusRouteControlManagementSystem/inUseListForm"><button
											type="button" class="btn modalbutton btn-primary"
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
			<div class="col-md-1"></div>
		</div>
	</div>

</main>

<!-- End #main -->
<!-- Jsp include tag for footer -->
<c:import url="../../layout/footer.jsp">
</c:import>
