package com.kh.lgtw.community.model.dao;


import static com.kh.lgtw.common.SqlQuery.*;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.common.SqlQuery;
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

	@Override
	public int communityUpdate(Community com, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		SqlQuery.getSqlQuery(sqlSession, "Community.communityUpdate", com);
		 int result =  sqlSession.update("Community.communityUpdate",com);
		 System.out.println("result : " + result);
		return sqlSession.update("Community.communityUpdate", com);
				
	}

	//게시글 수정폼 메소드
	@Override
	public CommunityPost communityPostUpdateForm(SqlSessionTemplate sqlSession, int contentno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Community.communityPostUpdateForm",contentno);
	}
	
	//게시글 수정메소드
	@Override
	public int communityPostUpdate(SqlSessionTemplate sqlSession, CommunityPost cp) {
		// TODO Auto-generated method stub
		System.out.println("CommunityPost Dao :"+cp);
		return sqlSession.update("Community.communityPostUpdate",cp);
	}
	//게시글 삭제 메소드
	@Override
	public int communityPostDelete(SqlSessionTemplate sqlSession, int contentno) {
		// TODO Auto-generated method stub
		return sqlSession.update("Community.communityPostDelete", contentno);
	}
    
	//게시판 삭제 메소드
	@Override
	public int communityDelete(SqlSessionTemplate sqlSession, int bno) {
		// TODO Auto-generated method stub
		return sqlSession.update("Community.communityDelete", bno);
	}

	@Override
	public int temporayInsert(SqlSessionTemplate sqlSession, CommunityPost cp) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Community.temporayInsert", cp);
	}

	@Override
	public ArrayList<CommunityComment> commentlist(SqlSessionTemplate sqlSession, int contentNO) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Community.commentlist", contentNO );
	}

	//댓글 생성 메소드 
	@Override
	public int InsertComment(SqlSessionTemplate sqlSession, CommunityComment cc) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Community.insertComment", cc);
	}

	//댓글 수정 메소드 
	@Override
	public int UpdateComment(SqlSessionTemplate sqlSession, CommunityComment cc) {
		// TODO Auto-generated method stub
		return sqlSession.update("Community.updateComment", cc);
		
	}
    
	//댓글 삭제 메소드
	@Override
	public int DeleteReply(SqlSessionTemplate sqlSession, CommunityComment cc) {
		// TODO Auto-generated method stub
		return sqlSession.update("Community.deleteReply", cc);
	}

	@Override
	public CommunityPost TemporaryDetails(SqlSessionTemplate sqlSession, int contentNO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Community.TemporaryDetails", contentNO);
		
	}

	@Override
	public int commentListcount(int contentno, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Community.commentListcount" , contentno);
	}

	
	

	

	


	



	

	
	
}
