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
<title>Admin : Edit Jobs</title>
<%@include file="Components/CSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${userObj.role ne 'admin'}">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>
	<%@include file="Components/Navbar.jsp"%>

	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>
						<c:if test="${not empty succMsg }">
							<div class="alert alert-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" />
						</c:if>

						<%
							int id = Integer.parseInt(request.getParameter("id"));
							JobDAO dao = new JobDAO(DBConnection.getConn());
							Jobs j = dao.getJobByID(id);
						%>

						<h5>EDIT JOBS</h5>
					</div>

					<form action="update" method="post">
					
					<input type="hidden" value="<%=j.getId()%>" name="id">
					
						<div class="form-group">
							<label>Enter Title </label> <input type="text" name="title"
								required="required" class="form-control"
								value="<%=j.getTitle()%>">
						</div>

						<div class="form-row">
							<div class="form-group col-md-4">
								<label>LOCATION </label> <select name="location"
									class="custom-select" id="inlineFormCustomSelectPref">
									<option value="<%=j.getLocation()%>"><%=j.getLocation()%></option>
									<option value="Mumbai">Mumbai</option>
									<option value="Pune">Pune</option>
									<option value="Bhopal">Bhopal</option>
									<option value="Bhubaneshwar">Bhubaneshwar</option>
									<option value="Delhi">Delhi</option>
									<option value="Bangalore">Bangalore</option>
									<option value="Chennai">Chennai</option>
									<option value="Hyderabad">Hyderabad</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label>CATEGORY </label> <select name="category"
									class="custom-select" id="inlineFormCustomSelectPref">
									<option value="<%=j.getCategory()%>"><%=j.getCategory()%></option>
									<option value="IT">IT</option>
									<option value="Developer">Developer</option>
									<option value="Banking and Finance">Banking and	Finance</option>
									<option value="Engineer">Engineer</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label>STATUS</label> <select class="form-control" name="status">
									<option class="Active" value="<%=j.getStatus()%>"><%=j.getStatus()%></option>
									<option class="Active" value="Active">ACTIVE</option>
									<option class="Inactive" value="Inactive">INACTIVE</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label>Enter Job Description</label>
							<textarea required rows="6" cols="" name="description"
								class="form-control"><%=j.getDescription()%></textarea>
						</div>
						<button class="btn btn-success">Update Job</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@include file="Components/Footer.jsp"%>
</body>
</html>