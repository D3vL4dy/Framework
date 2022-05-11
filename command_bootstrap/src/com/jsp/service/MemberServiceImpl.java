package com.jsp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dataSource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSessionFactory factory = new OracleMybatisSqlSessionFactory();

	// test시 필요한 MemberDAO 인스턴스를 받음
	private MemberDAO memberDAO = new MemberDAOImpl();

	public List<MemberVO> getMemberList() throws Exception {
		// commit을 못하도록 openSession에 false를 줌
		SqlSession session = factory.openSession(false);
		List<MemberVO> memberList = null;

		try {
			memberList = memberDAO.selectMemberList(session);

			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}
		return memberList;
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		// commit을 못하도록 openSession에 false를 줌
		SqlSession session = factory.openSession(false);
		List<MemberVO> memberList = null;

		try {
			memberList = memberDAO.selectMemberList(session, cri);

			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}
		return memberList;
	}

}
