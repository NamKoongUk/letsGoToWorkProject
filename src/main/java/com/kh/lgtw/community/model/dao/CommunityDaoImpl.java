package com.kh.lgtw.community.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;
@Repository
public class CommunityDaoImpl implements CommunityDao {

	//게시판 조회 리스트
	@Override
	public ArrayList<Community> SelectCommunity(SqlSessionTemplate sqlSession) {
		
		
		return (ArrayList)sqlSession.selectList("Community.selectCommunityList");
	}

	@Override
	public ArrayList<CommunityPost> CommunityPostList(int bno, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub'
		System.out.println("DaoImpl bno : " + bno);
		return (ArrayList)sqlSession.selectList("Community.selectPostList", bno);
	}

	

	


	



	

	
	
}
