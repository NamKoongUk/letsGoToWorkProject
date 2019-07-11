package com.kh.lgtw.community.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.Object;

import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;
import com.kh.lgtw.employee.model.vo.Employee;

public interface CommunityService   
{
    //게시판 조회
	ArrayList<Community> SelectCommunity();

	ArrayList<CommunityPost> CommunityPostList(int bno);

	ArrayList<CommunityPost> CommunityPostDetails(int contentNO);

	ArrayList<CommunityPost> SelectTemporaryList();

	int InsertCommunity(Community com);

	ArrayList<Community> SelectManagebulletinList();

	int CommunityPostInsert(CommunityPost cp);

	//게시판 수정폼 메소드
	Community communityUpdateForm(int bno);

	//게시판 수정 메소드
	int communityUpdate(Community com);

	//게시글 수정폼 메소드
	CommunityPost communityPostUpdateForm(int contentno);

	//게시글 수정 메소드
	int communityPostUpdate(CommunityPost cp);

	//게시글 삭제 메소드
	int communityPostDelete(int contentno);

	//게시판 삭제 메소드
	int communityDelete(int bno);

	//게시판  임시 저장 Insert 메소드 
	int temporayInsert(CommunityPost cp);

    //댓글 목록 리스트 	
	ArrayList<CommunityComment> commentlist(int contentNO);

	 //댓글 생성
	int InsertComment(CommunityComment cc);

	//댓글 수정 
	int UpdateComment(CommunityComment cc);

	//댓글 삭제
	int DeleteReply(CommunityComment cc);

	CommunityPost TemporaryDetails(int contentNO);

	

	int selectCommentCount(Map<String, Object> params);

	ArrayList<HashMap<String, Object>> selectCommentList(Map<String, Object> params);

	ArrayList<HashMap<String, Object>> selectComment(Map<String, Object> params);

	int commentListcount(int contentno);

	ArrayList<CommunityComment> selectcommentList(Integer contentno);


	




	

	

	

//	Community SelectCommunity(Community cm);
//
//	int UpdateCommunity(Community cm);
//
//	int DelectCommunity(Community cm);
//
//	int InsertCommunity(Community cm);
//
//	
//
//	CommunityPost SelectCommunityPost(CommunityPost cp);
//
//	int InsertCommunityPost(CommunityPost cp, CommunityAttachment ca);
//
//	int DelectCommunityPost(CommunityPost cp, CommunityAttachment ca);
//
//	int UpdateCommunityPost(CommunityPost cp, CommunityAttachment ca);
//
//	
//	CommunityComment SelectCommunityComment(CommunityComment cc);
//
//	int insertCommunityComment(CommunityComment cc);
//
//	int DeleteCommunityComment(CommunityComment cc);
//
//	int UpdateCommunityComment(CommunityComment cc);

	

	

}
