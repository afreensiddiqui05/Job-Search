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
<title>User : View Job Details</title>
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

				<%
					int id = Integer.parseInt(request.getParameter("id"));
					JobDAO dao = new JobDAO(DBConnection.getConn());
					Jobs j = dao.getJobById(id);
				%>

				<div class="card mt-5">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=j.getTitle()%></h6>
						<p><%=j.getDescription()%>.
						</p>
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

					</div>
				</div>



			</div>
		</div>
	</div>

</body>
</html>