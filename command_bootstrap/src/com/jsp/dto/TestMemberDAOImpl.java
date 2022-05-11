package com.jsp.dto;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dataSource.OracleMybatisSqlSessionFactory;


public class TestMemberDAOImpl {
	private SqlSessionFactory factory = new OracleMybatisSqlSessionFactory();
	
	// test시 필요한 MemberDAO 인스턴스를 받음
	private MemberDAO memberDAO = new MemberDAOImpl();
	
	private SqlSession session;
	
	@Before
	public void init()throws Exception{
		session = factory.openSession();
	}
	
	@After
	public void close() throws Exception{
		if(session != null) session.close();
	}
	
	@Test
	public void testSelectMemberList() throws Exception{
		List<MemberVO> memberList = memberDAO.selectMemberList(session);
		
		Assert.assertEquals(7, memberList.size());
	}
}
