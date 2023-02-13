<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	
	<form action="./write" method="POST">	
		글쓴이 : <input type="text" name="writer_id" />
		비밀번호 : <input type="password" name="writer_pw" /> <br>
		글 제목 : <input type="text" name="write_title" size="60"/> <br>
		글 내용 : <br>
		<textarea name="write_content" cols="60" rows="10"></textarea> <br>
		<input type="submit" value="글쓰기"/>
	</form>
	
	<script src="<%=request.getContextPath()%>/resources/script/board.js"></script>
	
	
</body>
</html>