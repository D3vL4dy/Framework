package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberDAO {

	// 서비스로부터 세션을 받아 멤버리스트를 List<MemberVO>로 넘겨라
	List<MemberVO> selectMemberList(SqlSession session) throws Exception;

	// 오버로딩 : 기능의 확장
	List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception; // 잘라준 것

}
