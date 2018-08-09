	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
	<spring:url var="homepagecss" value="/resources/css" />
	<spring:url var="css" value="/resources/vendor/bootstrap/css" />
	<spring:url var="js" value="/resources/vendor/bootstrap/js" />
	<spring:url var="jquery" value="/resources/vendor/jquery" />
	<spring:url var="images" value="/resources/images" />
	
	<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
	<!DOCTYPE html>
	<html lang="en">
	
	<head>
	
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Online Shopping- ${title}</title>
	<script>
	
	
	</script>
	<script type="text/javascript">
	    	window.menu = '${title}';
	    	window.contextRoot = '${contextRoot}'
	    </script>
	
	<!-- Bootstrap core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
	
	<!-- Bootstrap theme CSS -->
	<link href="${css}/bootstrap-theme.css" rel="stylesheet">
	
	<!-- Bootstrap data table -->
	<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="${homepagecss}/shop-homepage.css" rel="stylesheet">
	
	
	</head>
	
	<body>
		<div class="wrapper">
			<!-- Navigation -->
			<%@include file="./shared/navbar.jsp"%>
			<!-- Page content -->
	
			<div class="content">
				<c:if test="${userClickHome==true}">
					<!-- Loads home page here -->
					<%@include file="home.jsp"%>
				</c:if>
	
				<c:if test="${userClickAbout==true}">
					<!-- Loads about page here -->
					<%@include file="about.jsp"%>
				</c:if>
	
				<c:if test="${userClickContact==true}">
					<!-- Loads contact page here -->
					<%@include file="contact.jsp"%>
				</c:if>
				
				<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
					<!-- Loads only when user clicks  -->
					<%@include file="listProducts.jsp"%>
				</c:if>
				
				<c:if test="${userClickShowProduct==true}">
					<!-- Loads single Product page  -->
					<%@include file="singleProduct.jsp"%>
				</c:if>
				
				
				<c:if test="${userClickManageProducts==true}">
					<!-- Manage Products page  -->
					<%@include file="manageProducts.jsp"%>
				</c:if>
				
			</div>
			<!-- Footer here -->
			<%@include file="./shared/footer.jsp"%>
	
			<!-- Bootstrap core JavaScript -->
			<script src="${jquery}/jquery.js"></script>
			
			<script src="${js}/bootstrap.js"></script>
			<!-- Jquery DataTable -->
			<script src="${js}/jquery.dataTables.js"></script>
			
			<!-- Jquery Bootstrap DataTable -->
			<script src="${js}/dataTables.bootstrap.js"></script>
	
			<!-- Self coded js -->
			<script src="${js}/myapp.js"></script>
		</div>
	</body>
	
	
	</html>
