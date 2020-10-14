<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Coders and related Teams</title>
</head>
<body>
    
    <h1>All coders and related Teams</h1>  
    	<table>
	    		<tr>
	    			<th>Team</th>
	    			<th>Leader</th>
	    		</tr>
	    	<c:forEach var = "team"  items = "${teams}" >
				<tr>
	    			<td>${team.name}</td>
	    			<td>${team.leader.firstName}  ${team.leader.lastName}</td>
	    		</tr>
	    		<c:forEach   var="coder" items= "${teams.coders}">
	    				<tr>
	    					<td>${coder.firstName} ${coder.lastName}</td>
	    				</tr>	
	    		</c:forEach>
	    	</c:forEach>	
    	</table>
    	
    <p>Back to <a href="/simple/">home</a></p>

</body>
</html>
