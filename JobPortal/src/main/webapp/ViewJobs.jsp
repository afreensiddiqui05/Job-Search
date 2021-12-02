<%@ page import="com.DB.DBConnection"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.dao.JobDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.entity.Jobs"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : View Jobs</title>
<%@include file="Components/CSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${userObj.role ne 'admin'}">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>
	
	<%@include file="Components/Navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text-primary">All Jobs</h5>
				<c:if test="${not empty succMsg }">
					<div class="alert alert-success" role="alert">${succMsg}</div>
					<c:remove var="succMsg" />
				</c:if>
				<%
					JobDAO dao = new JobDAO(DBConnection.getConn());
					List<Jobs> list = dao.getAllJobs();
					for (Jobs j : list) {
				%>
				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>
						<h6><%=j.getTitle()%></h6>
						<p><%=j.getDescription()%></p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location : <%=j.getLocation()%>" readonly>
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category : <%=j.getCategory()%>" readonly>
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Status : <%=j.getStatus()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date :<%=j.getPublishDate()%></h6>
						<div class="text-center">
							<a href="EditJob.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">EDIT</a> 
								
								<a href="delete?id=<%=j.getId()%>" 
								class="btn btn-sm bg-danger text-white">DELETE</a>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>

	<%@include file="Components/Footer.jsp"%>
</body>
</html>