<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP PAGE</title>
<%@include file="Components/CSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="Components/Navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fas fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>REGISTRATION PAGE</h5>
						</div>
						<c:if test="${not empty succMsg }">
							<h4 class="text-center text-success">${succMsg}</h4>
							<c:remove var="succMsg" />
						</c:if>

						<form action="addUser" method="post">
							<div class="form-group">
								<label>Enter Full Name </label> <input type="text"
									required="required" class="form-control"
									id="exampleInputFullName1" aria-describedby="fullNameHelp"
									name="name">
							</div>
							<div class="form-group">
								<label>Enter Qualification </label> <input type="text"
									required="required" class="form-control" id="exampleInputQual1"
									aria-describedby="fullNameHelp" name="qualification">
							</div>

							<div class="form-group">
								<label>Enter Email </label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="fullNameHelp"
									name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password </label> <input
									type="password" required="required" class="form-control"
									id="exampleInputPassword1" name="password">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">REGISTER</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="Components/Footer.jsp"%>
</body>
</html>