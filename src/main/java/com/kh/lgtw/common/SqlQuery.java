package com.kh.lgtw.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlQuery {
	// sqlQuery문 확인하는 메소드 
	// 매개변수  
	// sqlSession : dao에서 select메소드 호출하는 sqlSession
	// id : ex. "Mail.selectList"와 같은 mapper내부의 id
	// params : parameter로 넘겨주는 값 
	// 전체 예시 ) SqlQuery.getSqlQuery(sqlSession, "Mail.searchList", listCondition);
	// 실행만 시키면 쿼리문과 넘긴 parameter값이 출력됩니다. 
	
	public static void getSqlQuery(SqlSession sqlSession, String id, Map<String, Object> params) {
		System.out.println("쿼리문 시작!!");
		BoundSql boundSql = sqlSession.getConfiguration().getMappedStatement(id).getBoundSql(params);
		String sql = boundSql.getSql();
		Object obj = boundSql.getParameterObject();
		System.out.println("sql : " + sql);
		System.out.println("obj : " + obj);
	}
	
	public static void getSqlQuery(SqlSession sqlSession, String id, Object obj) {
		System.out.println("쿼리문 시작!!");
		BoundSql boundSql = sqlSession.getConfiguration().getMappedStatement(id).getBoundSql(obj);
		String sql = boundSql.getSql();
		Object obj2 = boundSql.getParameterObject();
		System.out.println("sql : " + sql);
		System.out.println("obj : " + obj2);
	}
}
