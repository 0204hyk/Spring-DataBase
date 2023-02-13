<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.write_title}</title>
</head>
<body>
	
	글 번호 : ${board.board_id} <br>
	글 제목 : ${board.write_title} <br>
	글쓴이 : ${board.writer_id} <br>
	글 내용 :  <br>
	<textarea cols="30" rows="10" readonly>${board.write_content}</textarea> <br>
	추천 수 : ${board.write_recommend} <br>
	비추 수 : ${board.write_not_recommend} <br>
	조회 수 : ${board.write_view} <br>
	
	<button onclick="location.href='./modify?board_id=${board.board_id}'">글 수정</button>
	<button onclick="location.href='./delete?board_id=${board.board_id}'">글 삭제</button>
	<button onclick="location.href='./list?page=1'">글 목록</button>
	
	<br>
	
	<button onclick="location.href='./recommend?board_id=${board.board_id}'">추천</button>
	<button onclick="location.href='./not_recommend?board_id=${board.board_id}'">비추천</button>
	
	<br>
	
	<form action="./write_reply?board_id=${board.board_id}" method="POST">
	아이디 : <input type="text" name="commenter_id" />
	패스워드 : <input type="password" name="commenter_pw"/> <br>
	댓글 : 
	<textarea name="reply_content" cols="60" rows="5"></textarea> <br> 
	<input type="submit" value="댓글 쓰기" />
	</form>
	
	<table style="width: 800px; text-align: center;" border="1">
			<tr>
			<th>작성자</th>
			<th>내용</th>
			<th>작성 시간</th>
			<th></th>
		</tr>
		<c:forEach items="${replys}" var="reply">
			<tr>
				<td>${reply.commenter_id}</td>
				<td>${reply.reply_content}</td>
				<td>${reply.creationDateTime}</td>
				<td style="width: 85px">
					<a href="">수정</a>
					<a href="">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>