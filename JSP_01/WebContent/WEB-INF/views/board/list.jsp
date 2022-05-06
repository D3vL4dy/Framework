<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.jsp.vo.Board"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="min-width:1200px;margin:0 auto;">
		 
		<h1 style="text-align:center;">게시판리스트</h1>
		<hr style="width:70%;margin:0 auto;"/>
		<br/>
		<div style="width:70%;margin:0 auto;position:relative;overflow:hidden;">
			<button onclick="location.href='regist';" type="button" style="display:block;float:right;">글쓰기</button>
		</div>
		<br/>
		<table border="1" style="width:70%;margin:0 auto;">
			<tr>
				<th style="width:10%;">번호</th>
				<th style="width:30%;">제목</th>
				<th style="width:30%;">작성자</th>
				<th style="width:30%;">작성일</th>
			</tr>
			<%
				List<Board> boardList = (List<Board>)request.getAttribute("boardList");
				
				//int count = 0;
				if (boardList!=null) for(Board board : boardList){
					SimpleDateFormat mimi = new SimpleDateFormat("yyyy-MM-dd");
 					pageContext.setAttribute("board",board);
					//pageContext.setAttribute("bno",count++);
			%>
			<tr style="text-align:center;cursor:pointer;" onclick="location.href='detail?bno=${board.bno}';";>
				<td>${board.bno }</td>
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td><%=mimi.format(board.getRegDate()) %></td>
			</tr>
			<%		
				}else{
			%>
			<tr >
				<td colspan="4">해당내용이 없습니다.</td>
				
			</tr>
			<%		
					
				}
			%>
		</table>
		
	</div>
</body>
</html>








