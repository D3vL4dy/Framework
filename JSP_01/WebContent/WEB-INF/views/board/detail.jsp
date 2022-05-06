<%@page import="java.util.List"%>
<%@page import="com.jsp.vo.Board"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글상세</h1>
		<button type="button" onclick="location.href='<%=request.getContextPath()%>/board/modify?bno=${board.bno }';" >수정</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='<%=request.getContextPath()%>/board/remove?bno=${board.bno }';">삭제</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='list';">목록</button>
	<hr/>
	<table>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>내용</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<%--<% 
		List<Board> boardList = (List<Board>)request.getAttribute("boardList");
		
		if (boardList!=null) for(Board board : boardList){
			SimpleDateFormat mimi = new SimpleDateFormat("yyyy-MM-dd");
// 			pageContext.setAttribute("board",board);
		%> --%>
		<tr>
			<td>${board.bno }</td>
			<td>${board.title }</td>
			<td>${board.writer }</td>
			<td>${board.content }</td>
			<td>${board.regDate }</td>
			
			<td>${board.viewCnt }</td>
		</tr>
	</table>
</body>
</html>