package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws Exception {
		List<MemberVO> memberList = null;
		try {
			memberList = session.selectList("Member-Mapper.selectMemberList");
		} catch (Exception e) {
			// 에러처리
			throw e;
		}
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit); // 시작~끝 까지 잘라서 리스트에 넣어줌

		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", null, rowBounds); //null은 검색 기능을 위한 자리
		return memberList;
	}

}
