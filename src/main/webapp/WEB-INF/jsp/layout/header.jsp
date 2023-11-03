<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="util.common"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>${param.title}</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Link Group for data table -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" rel="stylesheet"/>



<!-- Favicons -->
<link href="<%=common.url%>/assets/img/icon1.jpg" rel="icon">
<link href="<%=common.url%>/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
	
<!-- Vendor CSS Files -->
<link
	href="<%=common.url%>/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=common.url%>/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="<%=common.url%>/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="<%=common.url%>/assets/vendor/quill/quill.snow.css"
	rel="stylesheet">
<link href="<%=common.url%>/assets/vendor/quill/quill.bubble.css"                                                                                         endor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="<%=common.url%>/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="<%=common.url%>/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${common.url}/assets/css/style.css" rel="stylesheet"
	type="text/css">
	
	
	<!-- Template Main Font Asesome  File -->
<link href="${common.url}/assets/css/fontawesome.css" rel="stylesheet"
	type="text/css">
<link href="${common.url}/assets/css/fontawesome.min.css" rel="stylesheet"
	type="text/css">
	    <!-- font awesome cdn link  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	
	<!-- for table start-->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
    color: #566787;
    background: #f5f5f5;
    font-family: 'Varela Round', sans-serif;
    font-size: 13px;
}
.table-responsive {
    margin: 10px 0px;
    width:100%;
}
.table-responsive .modalbox .modalbutton{
  background:#3366ff;
  color:white;
}
.table-responsive .modalbox .modalbutton:hover{
  background:#668cff;
  color:white;
}

.table-wrapper {
    min-width: 870px;
    background: #fff;
    padding: 20px 25px;
    border-radius: 3px;
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {
    padding-bottom: 15px;
    background: #64a2fa;
    color: #fff;
    padding: 16px 30px;
    margin: -20px -25px 10px;
    border-radius: 3px 3px 0 0;
}
.table-title h2 {
    margin: 5px 0 0;
    font-size: 24px;
}
.table-title .btn {
    color: #566787;
    float: right;
    font-size: 13px;
    background: #fff;
    border: none;
    min-width: 50px;
    border-radius: 2px;
    border: none;
    outline: none !important;
    margin-left: 10px;
}
.table-title .btn:hover, .table-title .btn:focus {
    color: #566787;
    background: #f2f2f2;
}
.table-title .btn i {
    float: left;
    font-size: 21px;
    margin-right: 5px;
}
.table-title .btn span {
    float: left;
    margin-top: 2px;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
    padding: 12px 15px;
    vertical-align: middle;
}

table.table tr th:first-child {
    width: 60px;
}

table.table tr th:last-child {
    width: 100px;
}
table.table-striped tbody tr:nth-of-type(odd) {
    background-color: #fcfcfc;
}
table.table-striped.table-hover tbody tr:hover {
    background: #f5f5f5;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}	
table.table td:last-child i {
    opacity: 0.9;
    font-size: 22px;
    margin: 0 5px;
}
table.table td a {
    font-weight: bold;
    color: #566787;
    display: inline-block;
    text-decoration: none;
}
table.table td a:hover {
    color: #2196F3;
}
table.table td a.settings {
    color: #2196F3;
}
table.table td a.delete {
    color: #F44336;
}
table.table td i {
    font-size: 19px;
}
table.table .avatar {
    border-radius: 50%;
    vertical-align: middle;
    margin-right: 10px;
}
#myTable .s_asc, .s_dsc{
  display:none;
}
.status {
    font-size: 30px;
    margin: 2px 2px 0 0;
    display: inline-block;
    vertical-align: middle;
    line-height: 10px;
}
.text-success {
    color: #10c469;
}
.text-info {
    color: #62c9e8;
}
.text-warning {
    color: #FFC107;
}
.text-danger {
    color: #ff5b5b;
}
.pagination {
    float: right;
    margin: 0 0 5px;
}
.pagination li a {
    border: none;
    font-size: 13px;
    min-width: 30px;
    min-height: 30px;
    color: #999;
    margin: 0 2px;
    line-height: 30px;
    border-radius: 2px !important;
    text-align: center;
    padding: 0 6px;
}
.pagination li a:hover {
    color: #666;
}	
.pagination li.active a, .pagination li.active a.page-link {
    background: #03A9F4;
}
.pagination li.active a:hover {        
    background: #0397d6;
}
.pagination li.disabled i {
    color: #ccc;
}
.pagination li i {
    font-size: 16px;
    padding-top: 6px
}
.hint-text {
    float: left;
    margin-top: 10px;
    font-size: 13px;
}
<!-- For Error Message -->
	#main .modal-confirm {		
		color: #636363;
		width: 400px;
		margin: 30px auto;
	}
	#main  .modal-confirm .modal-content {
		padding: 20px;
		border-radius: 5px;
		border: none;
        text-align: center;
		font-size: 14px;
	}
	#main  .modal-confirm .modal-header {
		border-bottom: none;   
        position: relative;
	}
	#main  .modal-confirm h4 {
		text-align: center;
		font-size: 26px;
		margin: 30px 0 -10px;
	}
	#main  .modal-confirm .close {
        position: absolute;
		top: -5px;
		right: -2px;
	}
	#main  .modal-confirm .modal-body {
		color: #999;
	}
	#main  .modal-confirm .modal-footer {
		border: none;
		text-align: center;		
		border-radius: 5px;
		font-size: 13px;
		padding: 10px 15px 25px;
	}
	#main  .modal-confirm .modal-footer a {
		color: #999;
	}		
	#main  .modal-confirm .icon-box {
		width: 80px;
		height: 80px;
		margin: 0 auto;
		border-radius: 50%;
		z-index: 9;
		text-align: center;
		border: 3px solid #f15e5e;
	}
	#main  .modal-confirm .icon-box i {
		color: #f15e5e;
		font-size: 46px;
		display: inline-block;
		margin-top: 13px;
	}
   #main  .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
		background: #60c7c1;
		text-decoration: none;
		transition: all 0.4s;
        line-height: normal;
		min-width: 120px;
        border: none;
		min-height: 40px;
		border-radius: 3px;
		margin: 0 5px;
		outline: none !important;
    }
	#main  .modal-confirm .btn-info {
        background: #c1c1c1;
    }
   #main  .modal-confirm .btn-info:hover, .modal-confirm .btn-info:focus {
        background: #a8a8a8;
    }
   #main  .modal-confirm .btn-danger {
        background: #f15e5e;
    }
   #main  .modal-confirm .btn-danger:hover, .modal-confirm .btn-danger:focus {
        background: #ee3535;
    }
	#main .trigger-btn {
		display: inline-block;
	}
<!-- For Error Message End -->
</style>
<script>
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
});
</script>
    <!-- for table end -->
</head>

<body>