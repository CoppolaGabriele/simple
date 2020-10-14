<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Coders</title>
</head>
<body>
    
    <h1>All coders</h1>  
    	
    	<table>
	    		<tr>
	    			<th>ID</th>
	    			<th>First Name</th>
	    			<th>Last Name</th>
	    			<th>Team Name</th>
	    		</tr>
	    	<c:forEach var = "coder"  items = "${coders}" >
				<tr>
	    			<td>${coder.id}</td>
	    			<td>${coder.firstName}</td>
	    			<td>${coder.lastName}</td>
	    			<td>${coder.leadingTeam.name}</td>
	    		</tr>
			</c:forEach>	
    	</table>
   
    <p>Back to <a href="/simple/">home</a></p>

</body>
</html>
