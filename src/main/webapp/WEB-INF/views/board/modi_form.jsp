<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 수정하기</title>
</head>
<body>

	<form action="./modify/do" method="POST">	
		글쓴이 : <input type="text" name="writer_id" value="${board.writer_id}" readonly /> <br>
		글 제목 : <input type="text" name="write_title" size="60" value="${board.write_title}" /> <br>
		글 내용 : <br>
		<textarea name="write_content" cols="60" rows="10">${board.write_content}</textarea> <br>
		<input type="hidden" name="board_id" value="${board.board_id}" />
		<input type="submit" value="Modify"/>
	</form>
	
</body>
</html>