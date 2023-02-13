<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
</head>
<body>

	<h3>All Employees</h3>
	
	<ul>
		<c:forEach items="${employees}" var="employee">
			<li>${employee}</li>
		</c:forEach>
	</ul>

</body>
</html>