<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="util.common"%>
<%@ page import="com.java.beans.Driver"%>
<c:import url="../layout/header.jsp">
         <c:param name="title" value="Profile Page"/>
</c:import>
<%
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

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="driverHome">Home</a></li>
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
              <h2>${driver.driverName}</h2>
              <h3>Bus Driver</h3>
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

                <div class="tab-pane fade show active profile-overview pt-4" id="profile-overview">

                  <h5 class="card-title">Profile Details</h5>
                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Full Name</div>
                    <div class="col-lg-9 col-md-8">${driver.driverName}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${driver.driverEmail}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Address</div>
                    <div class="col-lg-9 col-md-8">${driver.driverAddress}</div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Phone</div>
                    <div class="col-lg-9 col-md-8">${driver.driverPhone}</div>
                  </div>

                </div>

     <div class="tab-pane fade profile-edit pt-4" id="profile-edit">
          <!-- Profile Edit Form -->    
            <form:form action="/NgweOoBusRouteControlManagementSystem/driverProfileUpdate"  modelAttribute="driver" method="post" >  							
                    <div class="row mb-3" >
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="driverId" class="form-control" value="${driver.driverId}" hidden="true"/>
                        <form:input path="driverName" class="form-control" value="${driver.driverName}"/>
                      </div>
                    </div>

                     <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input type="email" path="driverEmail"  class="form-control" value="${driver.driverEmail}"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Country" class="col-md-4 col-lg-3 col-form-label">Address</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="driverAddress" class="form-control"  value="${driver.driverAddress}"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Phone</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="driverPhone" class="form-control"  value="${driver.driverPhone}"/>
                      </div>
                    </div>

                    <div class="text-center">
                      <button type="submit" class="btn btn-primary" style="float:right;">Save Changes</button>
                    </div>
        </form:form>
     </div>
     
      <div class="tab-pane fade pt-4" id="profile-change-password">
         <form:form action="/NgweOoBusRouteControlManagementSystem/updatePassword"  modelAttribute="driverUpdate" method="post">
                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="driverPassword" type="password" class="form-control" id="driverPassword" required="true"/>
                        <form:input path="driverEmail" type="password" class="form-control" id="driverEmail" value="${driver.driverEmail}" hidden="true"/>
                      </div>
                    </div>
                       <div class="row mb-3">
                        <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                         <div class="col-md-8 col-lg-9">
                        <form:input path="newPassword" type="password" class="form-control" id="newPassword" required="true"/>
                      </div>
                    </div>
                     <div class="row mb-3">
                          <label for="confirmPassword" class="col-md-4 col-lg-3 col-form-label">Confirm Password</label>
                          <div class="col-md-8 col-lg-9">
                        <form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" required="true"/>                  
                      </div>
                    </div>
                                        <form:input path="driverId"  class="form-control"  value="<%=driverSession.getDriverId() %>" hidden="true"/>
                    <div class="text-center">
                      <button type="submit" class="btn btn-primary" style="float:right;">Enter</button>
                    </div>
          </form:form>
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