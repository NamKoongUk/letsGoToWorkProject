package com.kh.lgtw.community.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.community.model.dao.CommunityDao;
import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;

@Service
public class CommunityServiceImpl  implements CommunityService{
//	@Autowired
//	SqlSessionTemplate sqlSession; 
//	
//	@Autowired 
//	private CommunityDao cd;
//	
//	//게시판 조회 메소드
//	@Override
//	public Community SelectCommunity(Community cm) {
//		Community com = null;
//		com=cd.SelectCommunity(sqlSession,cm);
//		
//		return com;
//	}
//	
//	//게시판 수정메소드
//	@Override
//	public int UpdateCommunity(Community cm) {
//		return cd.UpdateCommunity(sqlSession,cm);
//	}
//
//	//게시판 삭제 메소드
//	@Override
//	public int DelectCommunity(Community cm) {
//		return cd.DelectCommunity(sqlSession,cm);
//	}
//
//
//	//게시판 생성메소드
//	@Override
//	public int InsertCommunity(Community cm) {
//		// TODO Auto-generated method stub
//		return cd.InsertCommunity(sqlSession, cm);
//	}
//
//
//
//
//	//게시글 조회 메소드
//	@Override
//	public CommunityPost SelectCommunityPost(CommunityPost cp) {
//	
//		
//		
//		return cd.SelectCommunityPost(sqlSession,cp);
//	}
//
//
//
//
//	//게시글 생성 메소드
//	@Override
//	public int InsertCommunityPost(CommunityPost cp, CommunityAttachment ca) {
//		
//		int result = 0; 
//		int result1 = cd.InsertCommunityPost(sqlSession,cp);
//		int result2 = cd.InsertCommunityPostAtt(sqlSession,ca);
//		
//		if(result1 > 0 && result2 >0) {
//			result= 1 ;
//		}else {
//			result=0;
//		}
//		
//		
//		return result;
//	}
//
//	//게시글 삭제 메소드 
//	@Override
//	public int DelectCommunityPost(CommunityPost cp, CommunityAttachment ca) {
//		
//		int result = 0 ;
//		
//		int result1 =cd.DelectCommunityPost(sqlSession,cp);
//		int result2 =cd.DelectCommunityPostAtt(sqlSession,ca); 
//		
//		
//		if(result1 > 0 && result2 >0) {
//			result= 1 ;
//		}else {
//			result=0;
//		}
//		return result;
//	}
//
//
//	//게시글 수정메소드
//	@Override
//	public int UpdateCommunityPost(CommunityPost cp, CommunityAttachment ca) {
//		
//		int result = 0 ;
//		
//		int result1 =cd.UpdateCommunityPost(sqlSession,cp);
//		int result2 =cd.UpdateCommunityPostAtt(sqlSession,ca); 
//		
//		
//		if(result1 > 0 && result2 >0) {
//			result= 1 ;
//		}else {
//			result=0;
//		}
//		
//		return result;
//	}
//
//
//	//게시글 댓글 조회 메소드 
//	@Override
//	public CommunityComment SelectCommunityComment(CommunityComment cc) {
//		// TODO Auto-generated method stub
//		return cd.SelectCommunityComment(sqlSession,cc);
//	}
//
//	//게시글 댓글 생성 메소드 
//	@Override
//	public int insertCommunityComment(CommunityComment cc) {
//		// TODO Auto-generated method stub
//		return cd.insertCommunityComment(sqlSession, cc);
//	}
//
//	//게시글 댓글 삭제 메소드
//	@Override
//	public int DeleteCommunityComment(CommunityComment cc) {
//		// TODO Auto-generated method stub
//		return cd.DeleteCommunityComment(sqlSession,cc);
//	}
//
//	@Override
//	public int UpdateCommunityComment(CommunityComment cc) {
//		// TODO Auto-generated method stub
//		return cd.UpdateCommunityComment(sqlSession,cc);
//	}


}
