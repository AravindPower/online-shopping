<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


<title>Online-Prototype -${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Bootstrap theme CSS -->
<link href="${css}/bootstrap.theme.css" rel="stylesheet">

<!-- Data Table Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<!-- Navigation page -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>
		</nav>


		<!-- Page Content -->

		<div class="content">

			<div class="container">
			<!-- This will be displayed if the details are wrong -->
			<c:if test="${not empty message}">
			
			 <div class="row">
					<div class="col-md-offset-3 col-md-6">
					
					 <div class="alert alert-danger">${message}</div>
					 
					
					
					</div>
			</div>
			
			
			</c:if>
			
			
			<!-- This will displayed when user logged out -->
			<c:if test="${not empty logout}">
			
			 <div class="row">
					<div class="col-md-offset-3 col-md-6">
					
					 <div class="alert alert-success">${logout	}</div>
					 
					
					
					</div>
			</div>
			
			
			</c:if>
			
			

				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Login</h4>
							</div>
							<div class="panel-body">
								<form action="${contextRoot}/login" method="post"
									class="form-horizontal" id="loginForm">
									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									
									<div class="col-md-offset-4 col-md-8">
									 <input type="submit" value="Login" class="btn btn-primary"/>
									 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      							 </div>
      							
      							</form>
		      			<div class="panel-footer">
					       	<div class="text-right">
					       		New User - <a href="${contextRoot}/register">Register Here</a>
					       	</div>
      				   </div>

							</div>
							
						</div>


					</div>
				</div>

			</div>

		</div>








		<!-- Footer page -->

		<%@include file="./shared/footer.jsp"%>

		<!-- JavaScript -->
		<script src="${js}/jquery.js"></script>


		<!-- jquery validation -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap core Java script -->
		<script src="${js}/bootstrap.js"></script>



		<!-- Bootbox -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- user defined java script code -->
		<script src="${js}/myapp.js"></script>
	
</body>

</html>
