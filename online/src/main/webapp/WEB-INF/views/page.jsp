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
		<%@include file="./shared/navbar.jsp"%>


		<!-- Page Content -->

		<div class="content">

			<!-- Load the home page -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Loading when user clicks for about  -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Loading when user clicks for contact  -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts}">
				<%@include file="listProduct.jsp"%>
			</c:if>
			
			<!-- Load when user click for single product -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			
		</div>








		<!-- Footer page -->

		<%@include file="./shared/footer.jsp"%>

		<!-- JavaScript -->
		<script src="${js}/jquery.js"></script>
		<!-- Bootstrap core Java script -->
		<script src="${js}/bootstrap.js"></script>
		
		<!-- data table Jquery plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Bootstrap datable js -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- user defined java script code -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
