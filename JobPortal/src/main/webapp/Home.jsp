<%@ page import="java.util.List"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DB.DBConnection"%>
<%@ page import="com.dao.JobDAO"%>
<%@ page import="com.entity.Jobs"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User : View Jobs</title>
<%@include file="Components/CSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userObj}">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>
	<%@include file="Components/Navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<br>
				<h5 class="text-center text-primary">All Jobs</h5>

				<c:if test="${not empty succMsg }">
					<h4 class="text-center text-danger">${succMsg}</h4>
					<c:remove var="succMsg" />
				</c:if>

				<br>
				<div class="card">
					<div class="card-body">

						<form class="form-inline" action="MoreView.jsp" method="get">
							<div class="form-group col-md-5 mt-1">
								<h5>Location</h5>
							</div>

							<div class="form-group col-md-4 mt-1">
								<h5>Category</h5>
							</div>

							<div class="form-group col-md-5">
								<select name="location" class="custom-select"
									id="inlineFormCustomSelectPref">
									<option value="lo" selected>Choose...</option>
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

							<div class="form-group col-md-5">
								<select name="category" class="custom-select"
									id="inlineFormCustomSelectPref">
									<option value="ca" selected>Choose...</option>
									<option value="IT">IT</option>
									<option value="Developer">Developer</option>
									<option value="Banking and Finance">Banking and
										Finance</option>
									<option value="Engineer">Engineer</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>
							<button class="btn btn-success">Submit</button>
						</form>
					</div>
				</div>
			</div>

		</div>

		<%
			JobDAO dao = new JobDAO(DBConnection.getConn());
			List<Jobs> list = dao.getAllJobsForUser();
			for (Jobs j : list) {
		%>

		<div class="card mt-2">
			<div class="card-body">
				<div class="text-center text-primary">
					<i class="far fa-clipboard fa-2x"></i>
				</div>

				<h6>
					<%=j.getTitle()%>
				</h6>
				<%
					if (j.getDescription().length() > 0 && j.getDescription().length() < 120)

						{
				%>
				<p>
					<%=j.getDescription()%>.
				</p>
				<%
					} else {
				%>
				<p>
					<%=j.getDescription().substring(0, 120)%>...
				</p>
				<%
					}
				%>

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
				</div>
				<h6>
					Publish Date :
					<%=j.getPublishDate().toString()%></h6>

				<div class="text-center">
					<a href="OneView.jsp?id=<%=j.getId()%>"
						class="btn btn-sm bg-success text-white">View More</a>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>
