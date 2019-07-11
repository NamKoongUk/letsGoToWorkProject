package com.kh.lgtw.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartFile;

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
	
	// multipartFile을 File객체로 변환해주는 메소드 
	public static File multipartToFile(MultipartFile multiFile) throws IllegalStateException, IOException {
		System.out.println("multipartToFile 메소드 실행");
		System.out.println("바꾸려는 파일 : " + multiFile.getOriginalFilename());
		File convFile = new File(multiFile.getOriginalFilename());
		multiFile.transferTo(convFile);
		System.out.println("conFile : " + convFile.getName());
		System.out.println("conFile : " + convFile.getPath());
		return convFile;
	}
	
	// 서버 시간 가져오기 
	public static long getServerTime() {
		return System.currentTimeMillis();
	}
	
	// 파일을 바이너리 형태로 변경하기 
	public static byte[] convertFileToByte(File file) throws IOException {
		byte[] byteFile = new byte[(int) file.length()];
		
		FileInputStream fis = new FileInputStream(file);
		fis.read(byteFile); // byteFile에 file을 읽어서 작성한다.
		fis.close();
		return byteFile;
	}
}

