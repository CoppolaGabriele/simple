<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Team Created</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${teams==true}">
				<p> Team Created! </p>
			</c:when>
			<c:otherwise>
				<p> Error occurred! </p>
			</c:otherwise>
		</c:choose>
		<p>Back to <a href="/simple/">home</a></p>
	</body>
</html>