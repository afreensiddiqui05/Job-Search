<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<%@include file="Components/CSS.jsp"%>
<style type="text/css">
.back-img {
	background: url("Images/admin.jpg");
	width: 100%;
	height: 90vh;
	background-repeat: no-repeat;
	background-size: 100% 100%;
}
</style>
</head>
<body>
	<c:if test="${userObj.role ne 'admin'}">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>
	<%@include file="Components/Navbar.jsp"%>
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">WELCOME ADMIN</h1>
		</div>
	</div>
	<%@include file="Components/Footer.jsp"%>
</body>
</html>