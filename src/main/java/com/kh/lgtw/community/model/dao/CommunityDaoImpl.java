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

	//게시글 조회 리스트
	@Override
	public ArrayList<CommunityPost> CommunityPostList(int bno, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub'
		System.out.println("DaoImpl bno : " + bno);
		return (ArrayList)sqlSession.selectList("Community.selectPostList", bno);
	}

	//게시글 상세 조회
	@Override
	public ArrayList<CommunityPost> CommunityPostDetails(int contentNO, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Community.selectPostDetails", contentNO );
	}
	//임시 저장글 조회 리스트
	@Override
	public ArrayList<CommunityPost> SelectTemporaryList(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Community.SelectTemporaryList");
	}

	//게시판 생성용 메소드
	@Override
	public int InsertCommunity(SqlSessionTemplate sqlSession, Community com) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Community.InsertCommunity", com);
	}
	//게시판 관리 조회용 메소드
	@Override
	public ArrayList<Community> SelectManagebulletinList(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Community.SelectManagebulletinList");
	}

	@Override
	public int CommunityPostInsert(SqlSessionTemplate sqlSession, CommunityPost cp) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Community.CommunityPostInsert", cp);
	}

	
	//게시판 수정
	@Override
	public Community communityUpdateForm(SqlSessionTemplate sqlSession, int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Community.communityUpdateForm", bno);
	}

	

	

	


	



	

	
	
}
