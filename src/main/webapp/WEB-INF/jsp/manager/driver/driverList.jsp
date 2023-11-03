<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<c:import url="../../layout/header.jsp">
	<c:param name="title" value="Manager Page" />
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
							<li class="breadcrumb-item">
							      <a href="managerForm">Home</a>
							</li>
							<li class="breadcrumb-item active">
							     Driver List
							</li>
						</ol>
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
					</nav>
				</div>
			</div>
			<div class="col-md-12">
				<div class="table-responsive">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-5">
									<h2>
										Driver <b>list</b>
									</h2>
								</div>
								<div class="col-sm-7 modalbox">
									<form:form modelAttribute="driver" action="availableDriverForm" method="post" >
										<div class="row mb-3">										   
											<div class="col-md-6">										
							                       <c:if test="${flag==0}">
							                       	<form:input type="date" class="form-control" id="inputText"
										                     	path="desiredDate" min="2022-07-16"
											                    value="${currentDate}" required="true" />
							                       </c:if>							                       
							                        <c:if test="${flag==1}">
							                       	<form:input type="date" class="form-control" id="inputText"
										                     	path="desiredDate" min="2022-07-16"
											                    value="${desiredDate}" required="true" />
							                       </c:if>												
											</div>
											
											 <div class="col-md-2">											
												<button type="submit" class="form-control" style="width: 100%;">
												     <i class="fas fa-search"></i>
											  </button>
											</div>

											<div class="col-md-2">										    
											         <button type="submit" class="form-control" style="width: 100%;">
											             <a href="allDriverListForm">All</a>
											         </button>  
											</div>
											<div class="col-md-2">										    
											         <button type="submit" class="form-control"  style="width: 100%;">
											              <a href="/NgweOoBusRouteControlManagementSystem/driverForm">Add</a>
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
									<th style="width:80px;" onclick="sortTable(0)">
									     #No 
									     <i class="fa fa-sort-amount-asc s_asc" ></i>
						        	     <i class="fa fa-sort-amount-desc s_dsc" ></i>
									</th>
									
									<th style="width:200px;" onclick="sortTable(1)">
								     	Name
								     	 <i class="fa fa-sort-amount-asc s_asc"></i>
						        	     <i class="fa fa-sort-amount-desc s_dsc" ></i>
									</th>
									
									<th onclick="sortTable(2)">
									     Phone
									     <i class="fa fa-sort-amount-asc s_asc"></i>
						        	     <i class="fa fa-sort-amount-desc s_dsc"></i>
									</th>
									<th style="width:120px;" onclick="sortTable(3)">
									     Email
									     <i class="fa fa-sort-amount-asc s_asc"></i>
						        	     <i class="fa fa-sort-amount-desc s_dsc"></i>
									</th>
									<th style="width:250px;" onclick="sortTable(4)">
									      Address
									     <i class="fa fa-sort-amount-asc s_asc"></i>
						        	     <i class="fa fa-sort-amount-desc s_dsc"></i>
									 </th>
									<th>
									     Action
									</th>
								</tr>
							</thead>
							<tbody>
								<%
								int index = 1;
								%>
								<c:forEach var="driver" items="${driverList}">

									<tr align="center">
									
										<td>#<%=index++%></td>
										<td>${driver.driverName}</td>
										<td>${driver.driverPhone }</td>
										<td>${driver.driverEmail }</td>
										<td>${driver.driverAddress }</td>
										<td><a href="viewDriver/${driver.driverId}"
											class="settings" title="view"> <i class="fa fa-eye"></i>
										</a> <a href="deleteDriver/${driver.driverId}" class="delete"
											title="Delete"><i class="fa fa-remove"> </i></a> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<script>
						// start of the sort process
						function sortTable(n) {
						  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0, ascTag, dscTag;
						  table = document.getElementById("myTable");
						  switching = true;
						  //Set the sorting direction to ascending:
						  dir = "asc"; 
						  /*Make a loop that will continue until
						  no switching has been done:*/
						  while (switching) {
						    //start by saying: no switching is done:
						    switching = false;
						    rows = table.rows;
						    /*Loop through all table rows (except the
						    first, which contains table headers):*/
						    for (i = 1; i < (rows.length - 1); i++) {
						      //start by saying there should be no switching:
						      shouldSwitch = false;
						      /*Get the two elements you want to compare,
						      one from current row and one from the next:*/
						      x = rows[i].getElementsByTagName("TD")[n];
						      y = rows[i + 1].getElementsByTagName("TD")[n];
						      /*check if the two rows should switch place,
						      based on the direction, asc or desc:*/
						      if (dir == "asc") {
						      	rows[0].getElementsByClassName("s_asc")[n].style.display = "inline";
						      	rows[0].getElementsByClassName("s_dsc")[n].style.display = "none";
						        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
						          //if so, mark as a switch and break the loop:
						          shouldSwitch= true;
						          break;
						        }
						      } else if (dir == "desc") {
						      	rows[0].getElementsByClassName("s_asc")[n].style.display = "none";
						      	rows[0].getElementsByClassName("s_dsc")[n].style.display = "inline";
						        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
						          //if so, mark as a switch and break the loop:
						          shouldSwitch = true;
						          break;
						        }
						      }
						    }
						    if (shouldSwitch) {
						      /*If a switch has been marked, make the switch
						      and mark that a switch has been done:*/
						      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
						      switching = true;
						      //Each time a switch is done, increase this count by 1:
						      switchcount ++;      
						    } else {
						      /*If no switching has been done AND the direction is "asc",
						      set the direction to "desc" and run the while loop again.*/
						      if (switchcount == 0 && dir == "asc") {
						        dir = "desc";
						        switching = true;
						      }
						    }
						  }
						}
						// end of the sort process
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>
<!-- End #main -->
<!-- Jsp include tag for footer -->
<jsp:include page="../../layout/footer.jsp" />
