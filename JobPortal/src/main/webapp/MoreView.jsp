<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
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

				<%
					String location = request.getParameter("location");
					String category = request.getParameter("category");
					String msg = "";
					
					JobDAO dao = new JobDAO(DBConnection.getConn());
					List<Jobs> list = null;
					
					if("lo".equals(location) && "ca".equals(category))
					{
						list = new ArrayList<Jobs>();
						msg = "Please select atleast one criteria..";
					}
					else if("lo".equals(location) || "ca".equals(category))
					{
						list = dao.getJobsBasedOnLocOrCat(location, category);
					}
					else
					{
						list = dao.getJobsBasedOnLocAndCat(location, category);
					}
					
					if(list.isEmpty() && "lo".equals(location) && "ca".equals(category))
					{					
						%>
						<h4 class="text-center text-danger"><%=msg%></h4>
						<%
					}
					
					else if(list.isEmpty() && !"lo".equals(location) && !"ca".equals(category))
					{
						%>
							<h4 class="text-center text-danger">No jobs available for the selected criteria..</h4>
						<%
					}
					
					if(list != null)
					{
						for(Jobs j : list)
						{											
				%>

				<div class="card mt-2">
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
						<div class="text-center">
							<a href="OneView.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">View More</a>
						</div>
					</div>
				</div>
				<%
						}
					}	
					else
					{
						%>
						<h4 class="text-center text-danger"><%=msg%></h4>
						<%
					}
				%>
			</div>
		</div>
	</div>
	
</body>
</html>