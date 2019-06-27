package com.kh.lgtw.community.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;
import com.kh.lgtw.employee.model.vo.Employee;

public interface CommunityDao {

	ArrayList<Community> SelectCommunity(SqlSessionTemplate sqlSession);

	ArrayList<CommunityPost> CommunityPostList(int bno, SqlSessionTemplate sqlSession);

	ArrayList<CommunityPost> CommunityPostDetails(int contentNO, SqlSessionTemplate sqlSession);

	ArrayList<CommunityPost> SelectTemporaryList(SqlSessionTemplate sqlSession);

	int InsertCommunity(SqlSessionTemplate sqlSession, Community com);

	

	
	
	//게시판 생성
	

	
	

	

		

}
