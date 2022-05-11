package com.jsp.dataSource;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dto.MemberVO;

public class TestOracleMybatisSqlSessionFactory {// 단위테스트를 위한 클래스

	private OracleMybatisSqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();

	// 왜 밖에 선언하는걸까 : 편하게 사용하기위해
	private SqlSession session;

	@Before // before-test-after 가 한바퀴 도는게 단위 테스트
	public void init() throws Exception {
		session = sqlSessionFactory.openSession();
		// openSession :
	}

	@Test // 전체적인 구조테스트 : 오라클한테 정보를 보낼수 있는지 (팩토리가 연결되어있는지)
	public void testSqlSessionFactory() throws Exception {
		Assert.assertNotNull(sqlSessionFactory);
		// assertNotNull : 객체가 null이 아닌지 확인하는 메서드
	}

	@Test // 매퍼랑 연결되어있는지
	public void testSqlSession() throws Exception {
		// 세션에 getConfiguration하게되면 map에서 id들을 전부 꺼낼수 있음 -> getMappedStatementNames
		Collection<String> mapNames = (Collection<String>) session.getConfiguration().getMappedStatementNames();

		Assert.assertTrue(mapNames.contains("Member-Mapper.selectMemberList"));
		// contains 글자가 똑같으면 true가 나옴.
	}

	@Test // 데이터가 정확하게 가져왔는지 테스트
	public void testMemberList() throws Exception {
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");

		Assert.assertEquals(7, memberList.size());
		// Assert : 비교하기위한 함수
	}

	@After // 반드시 public , return 타입 없어야함
	public void close() throws Exception {
		if (session != null)
			session.close(); // 반환하는걸 만들어줌
	}

}
