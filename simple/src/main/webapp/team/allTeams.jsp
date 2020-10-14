<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GetAll Teams</title>
	</head>
	<body>
		<c:forEach var = "team"  items = "${teams}" >
			<p> ${team} </p>
		</c:forEach>
		
		<p>Back to <a href="/simple/">home</a></p>
	</body>
</html>