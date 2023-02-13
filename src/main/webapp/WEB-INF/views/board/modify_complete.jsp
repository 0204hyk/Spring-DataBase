<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 수정 완료</title>
</head>
<body>
	<h3>수정이 완료되었습니다.</h3>
	<button onclick="location.href='<%=request.getContextPath()%>/board/contents?board_id=${board_id}'">확인</button>
</body>
</html>