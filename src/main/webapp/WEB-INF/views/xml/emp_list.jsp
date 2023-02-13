<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>
	
	<h3>Employees</h3>
	
	<ul>
		<c:forEach items="${employees}" var="employee">
			<!-- jstl(el) 태그 내부에서 문자열 더하려면 += 사용해야함 -->
			<li>${employee.first_name += ' ' += employee.last_name} (${employee.salary})</li>
		</c:forEach>
	</ul>
	
</body>
</html>