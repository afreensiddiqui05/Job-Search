<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Profile</title>
<%@include file="Components/CSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userObj}">
		<c:redirect url="Login.jsp"></c:redirect>
	</c:if>
	<%@include file="Components/Navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Edit Profile</h5>
						</div>

						<form action="Update_Profile" method="post">

							<input type="hidden" name="id" value="${userObj.id}">

							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									required="required" class="form-control" id="inputName"
									aria-describedby="emailHelp" name="name"
									value="${userObj.name}">
							</div>

							<div class="form-group">
								<label>Enter Qualification</label> <input type="text"
									required="required" class="form-control"
									id="inputQualification" aria-describedby="qualHelp" name="qualification"
									value="${userObj.qualification}">
							</div>

							<div class="form-group">
								<label>Enter Email</label> <input type="text"
									required="required" class="form-control" id="inputEmail"
									aria-describedby="emailHelp" name="email"
									value="${userObj.email}">
							</div>

							<div class="form-group">
								<label>Enter Password</label> <input required="required"
									type="password" class="form-control" id="inputPassword"
									name="password" value="${userObj.password}">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>