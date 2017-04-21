<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Maven + Spring MVC</title>

	<spring:url value="/resources/core/css/hello.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<p>
			<c:if test="${not empty student.name}">
				${student.name}
			</c:if>

			<c:if test="${not empty student.surname}">
				${student.surname}
			</c:if>
		</p>
	</div>
</div>


<div class="container">

	<div class="row">
		<div class="col-md-2">
			<h2>University</h2>
			<p>${student.univercity}</p>
		</div>
		<div class="col-md-2">
			<h2>Faculty</h2>
			<p>${student.faculty}</p>
		</div>
		<div class="col-md-2">
			<h2>Group</h2>
			<p>${student.group}</p>
		</div>
		<div class="col-md-2">
			<h2>Floor</h2>
			<p>${student.room.floor}</p>
		</div>
		<div class="col-md-2">
			<h2>Room Number</h2>
			<p>${student.room.number}</p>
		</div>
	</div>


	<hr>
	<footer>
		<p>&copy; Dzmitry Beinya</p>
	</footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>