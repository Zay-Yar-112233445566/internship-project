<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<%@ page import="com.java.beans.Driver"%>
<c:import url="../layout/header.jsp">
         <c:param name="title" value="Driver Page"/>
</c:import>
<%
     if(session.getAttribute("driverSession")==null){
    	 response.sendRedirect("driverSignOut");
     }  
    Driver driverSession=(Driver) session.getAttribute("driverSession");
%>
  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="<%=common.url%>/assets/img/icon1.jpg" alt="">
        <span class="d-none d-lg-block">Diver Panel</span>
      </a>
       <i class="fas fa-bars toggle-sidebar-btn"></i>
    </div><!-- End Logo -->


	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">

			<li class="nav-item d-block d-lg-none"><a
				class="nav-link nav-icon search-bar-toggle " href="#"> <i
					class="fa fa-chevron-down ms-auto"></i>
			</a></li>
			<!-- End Search Icon-->

			<li class="nav-item dropdown pe-3"><a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown"> <span class="d-none d-md-block dropdown-toggle ps-2">${driverInfo.driverName} </span>
			</a>
				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li class="dropdown-header">
					  <span >Bus Driver</span>
					</li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="driverProfile"> <i class="fas fa-person"></i> <span>My
								Profile</span>
					</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="driverProfile"> <i class="fas fa-gear"></i> <span>Account
								Settings</span>
					</a></li>
				</ul>
			</li>                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		</ul>
	</nav>
	<!-- End Icons Navigation -->
  </header><!-- End Header -->
  
  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">		
      	<li class="nav-item">
      	    <a class="nav-link collapsed" href="driverSignOut" onClick="myFunction();"> <i class="fa fa-arrow-right" ></i> <span>Log Out</span></a>
		</li>
    </ul>
<script>
  function myFunction() {
     alert("Sure to Log out!");
     }
</script>
  </aside><!-- End Sidebar-->

<!-- End Sidebar-->
<main id="main" class="main">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="pagetitle">
					<h1>Dashboard</h1>
					 <nav>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
						</ol>
					</nav>
				</div>
			</div>
         <c:if test="${resultFlag==1}">
			  <div class="alert alert-success alert-dismissible fade show" role="alert">
                   ${message}
                  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>
         </c:if>
         
			<div class="col-md-12">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-5">
									<h2>
										Assigned Trip <b>View</b>
									</h2>
								</div>
								<div class="col-sm-7 modalbox">
				                     <form:form modelAttribute="driver" action="/NgweOoBusRouteControlManagementSystem/availableAssignedListForm" method="post" >
										<div class="row mb-3">										   
											<div class="col-md-6 ">		
												    <form:input  path="driverId" class="form-control"  value="<%=driverSession.getDriverId() %>" hidden="true" />						
											       <c:if test="${flag==0}">																															                       
							                           <form:input type="date" class="form-control" id="inputText" path="desiredDate" min="2022-07-16" value="${currentDate}" required="true" />
							                     	</c:if>				                       
							                        <c:if test="${flag==1}">
							                           	<form:input type="date" class="form-control" id="inputText" path="desiredDate" min="2022-07-16"  value="${desiredDate}" required="true" />
							                       </c:if>												
											</div>
											<div class="col-md-3">											
											     <button type="submit" class="form-control"style="width: 100%;">
											              <i class="fas fa-search"></i>
											     </button>
											</div>
											
											<div class="col-md-3">										    
											      <button type="submit" class="form-control" style="width: 100%;">
										                  <a href="/NgweOoBusRouteControlManagementSystem/allAssignedListForm">All</a>
											      </button>  
											</div>
										</div>
									</form:form>
								</div>
							</div>
						</div>
						<table class="table table-striped table-hover" id="myTable">
							<thead>
								<tr align="center">
									<th>#No</th>
									<th>From</th>
									<th>To</th>
									<th>Bus No</th>
									<th>Bus Type</th>
									<th>Departure Date</th>
									<th>Departure Time</th>
									<th>Duration</th>
									<th>Fee</th>	
								</tr>
							</thead>
							<tbody>
							  <% int index=1; %>
								<c:forEach var="driverTripList" items="${driverTripList}">
									<tr align="center">
										<td>#<%=index++ %></td>
										<td>${driverTripList.departurePoint}</td>
										<td>${driverTripList.destinationPoint}</td>
										<td>BID-${driverTripList.busId }</td>
										<td>${driverTripList.busTypeName}</td>
										<td>${driverTripList.departureDate}</td>
										<td>${driverTripList.departureTime }</td>
										<td>${driverTripList.timeRequired}-hours</td>
										<td>${driverTripList.fare}mmk</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						

<script>
      //when the document is ready
     $(document).ready(function() {
    
    $("#myTable").dataTable();
});
</script>
					</div>
				</div>
			</div>
		</div>

	</div>
</main>
<!-- End #main -->

 <!-- Jsp include tag for footer -->
<jsp:include page="../layout/footer.jsp" />