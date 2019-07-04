package com.kh.lgtw.common;

import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.SqlSession;

public class CommonUtils {
	// sqlQuery문 확인하는 메소드 
	// 전체 예시 ) SqlQuery.getSqlQuery(sqlSession, "Mail.searchList", listCondition);
	// 실행만 시키면 쿼리문과 넘긴 parameter값이 출력 
	public static void getSqlQuery(SqlSession sqlSession, String id, Map<String, Object> params) {
		BoundSql boundSql = sqlSession.getConfiguration().getMappedStatement(id).getBoundSql(params);
		String sql = boundSql.getSql();
		Object obj = boundSql.getParameterObject();
		System.out.println("sql : " + sql);
		System.out.println("obj : " + obj);
	}
	
	public static String getRandomString() {
		
		return UUID.randomUUID().toString().replaceAll("-", "");
		
	}
	
}
