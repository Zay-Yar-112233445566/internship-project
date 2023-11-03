<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<%@ page import="com.java.beans.Manager"%>
<c:import url="../layout/header.jsp">
	<c:param name="title" value="Manager Page" />
</c:import>
<%
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


	<!-- End Search Bar -->

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
					class="d-none d-md-block dropdown-toggle ps-2">My Profile</span>
			</a> <!-- End Profile Iamge Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li class="dropdown-header">
						<h6></h6> <span>System Manager</span>
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
			href="signOut" onClick="myFunction();"> <i class="fa fa-arrow-right" ></i> <span>Log
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

    <div class="pagetitle">
      <h1>Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="managerForm">Home</a></li>
          <li class="breadcrumb-item active">Profile</li>
        </ol>
      </nav>
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
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-lg-5">

          <div class="card">	
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
              <h2>${manager.managerName}</h2>
              <h3>System Manager</h3>
            </div>
          </div>

        </div>

        <div class="col-lg-7">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change Password</button>
                </li>

              </ul>
              <div class="tab-content pt-4">

                <div class="tab-pane fade show active profile-overview" id="profile-overview">

                  <h5 class="card-title">Profile Details</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Full Name</div>
                    <div class="col-lg-9 col-md-8">${manager.managerName}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${manager.managerEmail}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Educational Background</div>
                    <div class="col-lg-9 col-md-8">${manager.educationalBackground}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone</div>
                    <div class="col-lg-9 col-md-8">${manager.managerPhone}</div>
                  </div>

                </div>

                <div class="tab-pane fade profile-edit pt-4" id="profile-edit">

                  <!-- Profile Edit Form -->
                  
              <form:form method="post" modelAttribute="manager1" action="/NgweOoBusRouteControlManagementSystem/managerUpdate">  										
                   <div class="row mb-3" >
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="managerId" class="form-control" value="${manager.managerId}" hidden="true"/>
                        <form:input path="managerName" class="form-control" value="${manager.managerName}"/>
                      </div>
                   </div>

                     <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input type="email" path="managerEmail"  class="form-control" value="${manager.managerEmail}"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Country" class="col-md-4 col-lg-3 col-form-label">Educational Background</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="educationalBackground" class="form-control"  value="${manager.educationalBackground}"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Phone</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="managerPhone" class="form-control"  value="${manager.managerPhone}"/>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                  </form:form><!-- End Profile Edit Form -->

                </div>


                <div class="tab-pane fade pt-4" id="profile-change-password">
                  <!-- Change Password Form -->
                  
                  <form:form action="/NgweOoBusRouteControlManagementSystem/updateManagerPassword"  modelAttribute="managerUpdate" method="post">
                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="managerPassword" type="password" class="form-control" id="managerPassword" required="true"/>
                        <form:input path="managerId"  class="form-control"  value="${manager.managerId}" hidden="true"/>
                        <form:input type="email" path="managerEmail"  class="form-control" value="${manager.managerEmail}" hidden="true"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                       <div class="col-md-8 col-lg-9">
                        <form:input path="newPassword" type="password" class="form-control" id="newPassword" required="true"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                     <div class="col-md-8 col-lg-9">
                        <form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" required="true"/>                  
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Change Password</button>
                    </div>
                  </form:form><!-- End Change Password Form -->

                </div>

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

  <!-- Jsp include tag for footer -->
<jsp:include page="../layout/footer.jsp" />