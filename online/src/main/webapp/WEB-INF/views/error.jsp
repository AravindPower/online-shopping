<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />



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

				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>

				</div>


			</div>

		</nav>

		<div class="content">

			<div class="container">

				<div class="row">
					<div class="col-xs-12">
					 <div class="jumbotron">
					  <h1>${errorTitle}</h1>
					  <hr/>
					  
					  <blockquote>
					   ${errorDescription}
					  </blockquote>
					 
					 </div>
					 
					</div>

				</div>

			</div>


		</div>
         <%@include file="./shared/footer.jsp" %>
	</div>
</body>

</html>
