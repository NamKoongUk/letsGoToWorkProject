package com.kh.lgtw.community.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;

public class CommunityDaoImpl implements CommunityDao {

	//게시판 조회용 메소드
	public Community SelectCommunity(SqlSessionTemplate sqlSession, Community cm) {
		
		Community com =sqlSession.selectOne("",cm);
		
		
			
		return com;
	}

	
	//게시판 수정용 메소드
	@Override
	public int UpdateCommunity(SqlSessionTemplate sqlSession, Community cm) {
		
		
		return sqlSession.update("",cm);
	}


	//게시판 삭제용 메소드 
	@Override
	public int DelectCommunity(SqlSessionTemplate sqlSession, Community cm) {
		
		return sqlSession.delete("",cm);
	}

	//게시판 생성용 메소드
	@Override
	public int InsertCommunity(SqlSessionTemplate sqlSession, Community cm) {
		// TODO Auto-generated method stub
		return sqlSession.insert("",cm);
	}

	//게시글 조회용 메소드 
	@Override
	public CommunityPost SelectCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp) {
		
		CommunityPost cps =sqlSession.selectOne("", cp);
		
		return cps;
	}

	//게시글 생성 메소드 
	@Override
	public int InsertCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp) {
		// TODO Auto-generated method stub
		return sqlSession.insert("", cp);
	}

	//게시글 첨부 파일 생성 메소드
	@Override
	public int InsertCommunityPostAtt(SqlSessionTemplate sqlSession, CommunityAttachment ca) {
		// TODO Auto-generated method stub
		return sqlSession.insert("", ca);
	}

	//게시글 삭제 메소드
	@Override
	public int DelectCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp) {
		
		return sqlSession.delete("", cp);
	}

	//게시글  첨부파일 삭제 메소드 
	@Override
	public int DelectCommunityPostAtt(SqlSessionTemplate sqlSession, CommunityAttachment ca) {
		
		return sqlSession.delete("", ca);
	}

	//게시글 수정 메서드
	@Override
	public int UpdateCommunityPost(SqlSessionTemplate sqlSession, CommunityPost cp) {
		// TODO Auto-generated method stub
		return sqlSession.update("", cp);
	}

	//게시글 첨부파일 수정 메소드
	@Override
	public int UpdateCommunityPostAtt(SqlSessionTemplate sqlSession, CommunityAttachment ca) {
		// TODO Auto-generated method stub
		return sqlSession.update("", ca);
	}

	//게시글 댓글 조회 메소드 
	@Override
	public CommunityComment SelectCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc) {
		CommunityComment cct =sqlSession.selectOne("", cc);
		
		return cct;
	}

	//게시글 댓글 생성 메소드 
	@Override
	public int insertCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc) {
		
		return sqlSession.insert("", cc);
	}

	//게시글 댓글 삭제 메소드 
	@Override
	public int DeleteCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc) {
		// TODO Auto-generated method stub
		return sqlSession.delete("", cc);
	}

	//게시글 댓긓 수정 메소드 
	@Override
	public int UpdateCommunityComment(SqlSessionTemplate sqlSession, CommunityComment cc) {
		// TODO Auto-generated method stub
		return sqlSession.update("", cc);
	}







	

	
	
}
