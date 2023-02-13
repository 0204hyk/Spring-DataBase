<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	
	<div>
		<c:forEach items="${boards}" var="board">
			<div>${board}</div>
			<div><a href="./modify?board_id=${board.board_id}&write_title=modify test&write_content=modify test content">수정</a></div>
			<div><a href="./delete?board_id=${board.board_id}">삭제</a></div>
		</c:forEach>
	</div>
	
</body>
</html>