<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
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
							<h5>LOGIN PAGE</h5>
						</div>
						<c:if test="${not empty succMsg }">
							<h4 class="text-center text-danger">${succMsg}</h4>
							<c:remove var="succMsg" />
						</c:if>

						<form action="Login" method="post">

							<div class="form-group">
								<label>Enter EMAIL </label> <input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password </label> <input
									type="password" required="required" class="form-control"
									id="exampleInputPassword1" name="password">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">LOGIN</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="Components/Footer.jsp"%>
</body>
</html>