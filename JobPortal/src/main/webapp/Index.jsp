<%@ page import="com.DB.DBConnection"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JOB PORTAL</title>
<%@include file="Components/CSS.jsp"%>
<style type="text/css">
.back-img {
	background: url("Images/coverpage.jpg");
	width: 100%;
	height: 90vh;
	background-repeat: no-repeat;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<%@include file="Components/Navbar.jsp"%>
<%-- 	<% Connection conn = DBConnection.getConn();
	out.println(conn);
	%> --%>
	<div class="container-fluid back-img">
		<!-- <div class="text-center">
			<h1 class="text-black p-4">
				<i class="fas fa-search mr-1"></i></i>ONLINE JOB PORTAL
			</h1>
		</div> -->
	</div>
	<%@include file="Components/Footer.jsp"%>
</body>
</html>