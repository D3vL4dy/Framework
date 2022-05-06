package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dataSource.DataSource;
import com.jsp.vo.Member;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	
	private DataSource dataSource = DataSource.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/regist.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String url = request.getContextPath()+"/member/list";
		
		//처리
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		
		//memberService.regist(member); <-----DB저장
		
		dataSource.getMemberList().put(id, member);
		
		System.out.println(member);
		
		//출력
		
		response.sendRedirect(url);
		/*
		 * request.setAttribute("member", member);
		 * request.getRequestDispatcher(url).forward(request,response);
		 */
	}

}







