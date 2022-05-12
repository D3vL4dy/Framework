package com.jsp.service;

import java.util.List;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberService {
	List<MemberVO> getMemberList() throws Exception;

	List<MemberVO> getMemberList(Criteria cri) throws Exception; // 잘라준 것
	
	public Map<String, Object> getMemberListForPage(Criteria cri) throws Exception;
}