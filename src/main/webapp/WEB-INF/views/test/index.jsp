<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3># DB Test Index</h3>
	
	<ul>
		<li><a href="./employees">employees 보러가기</a></li>
		<li><a href="./employees2">employees 보러가기 (Mybatis)</a></li>
		<li><a href="./board/get?board_id=10">글 하나 보기 (Mybatis)</a></li>
		<li><a href="./board/add?writer_id=mybatis&writer_pw=4321&write_title=Mybatis Test&write_content=Hello">글 쓰기 (Mybatis)</a></li>
		<li><a href="./board/list">글 전체 목록 보기</a></li>
	</ul>

</body>
</html>