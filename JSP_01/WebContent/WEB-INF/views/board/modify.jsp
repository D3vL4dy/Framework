<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="modify?bno=${board.bno}" method="post" >
		제목 : <input type="text" name="title" value="${board.title }"/><br/>
		작성자 : <input type="text" name="writer" value="${board.writer }"/><br/>
		내용 : <textarea rows="" cols="" name="content" value="${board.content }"></textarea>
		<input type="submit" value="수정완료" />
	</form>
</body>
</html>