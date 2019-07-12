package com.kh.lgtw.community.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.community.model.dao.CommunityDao;
import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;
import com.kh.lgtw.employee.model.vo.Employee;

@Service
public class CommunityServiceImpl  implements CommunityService{
	
	  @Autowired SqlSessionTemplate sqlSession;
	 

	
	  @Autowired private CommunityDao cd;
	 

	  
	  //게시판 조회용 리스트 메소드
	  
	  @Override public ArrayList<Community> SelectCommunity() 
	  {
	 
	  return cd.SelectCommunity(sqlSession); 
	  }



	  //게시글 조회용 리스트
	@Override
	public ArrayList<CommunityPost> CommunityPostList(int bno) {
		// TODO Auto-generated method stub
		return cd.CommunityPostList(bno , sqlSession);
	}



	   //게시글 상세 조회
	@Override
	public ArrayList<CommunityPost> CommunityPostDetails(int contentNO) {
		
		return cd.CommunityPostDetails(contentNO,sqlSession);
	}


	 // 임시 저장 리스트 조회
	@Override
	public ArrayList<CommunityPost> SelectTemporaryList() {
		// TODO Auto-generated method stub
		return cd.SelectTemporaryList(sqlSession);
	}

	
    //게시판 생성 메소드
	@Override
	public int InsertCommunity(Community com) {
		
		return cd.InsertCommunity(sqlSession,com);
	}


	//게시판 관리 조회 메소드
	@Override
	public ArrayList<Community> SelectManagebulletinList() {
		// TODO Auto-generated method stub
		return cd.SelectManagebulletinList(sqlSession);
	}


	//게시글 생성 메소드
	@Override
	public int CommunityPostInsert(CommunityPost cp) {
		// TODO Auto-generated method stub
		return cd.CommunityPostInsert(sqlSession ,cp);
	}


	//게시판 수정폼 메소드
	@Override
	public Community communityUpdateForm(int bno) {
		
		return cd.communityUpdateForm(sqlSession,bno);
	}


	//게시판 수정 메소드
	@Override
	public int communityUpdate(Community com) {
		// TODO Auto-generated method stub
		
		System.out.println("service Community 값:"+com);
		return cd.communityUpdate(com,sqlSession);
	}


	//게시글 수정폼 메소드
	@Override
	public CommunityPost communityPostUpdateForm(int contentno) {
		
		return cd.communityPostUpdateForm(sqlSession,contentno);
	}


	//게시글 수정
	@Override
	public int communityPostUpdate(CommunityPost cp) {
		// TODO Auto-generated method stub 
		System.out.println("CommunityPost 서비스 :"+cp);
		return cd.communityPostUpdate(sqlSession,cp);
	}


    //게시글 삭제
	@Override
	public int communityPostDelete(int contentno) {
		
		return cd.communityPostDelete(sqlSession,contentno);
	}


	//게시판 삭제
	@Override
	public int communityDelete(int bno) {
		// TODO Auto-generated method stub
		return cd.communityDelete(sqlSession,bno);
	}


    //게시판 임시저장 insert 메소드
	@Override
	public int temporayInsert(CommunityPost cp) {
		// TODO Auto-generated method stub
		return cd.temporayInsert(sqlSession,cp);
	}


    //댓글리스트 조회 메소드 
	@Override
	public ArrayList<CommunityComment> commentlist(int contentNO) {
		// TODO Auto-generated method stub
		return cd.commentlist(sqlSession,contentNO);
	}


    //댓글 생성 메소드 
	@Override
	public int InsertComment(CommunityComment cc) {
		// TODO Auto-generated method stub
		return cd.InsertComment(sqlSession,cc);
	}


	//댓글 수정 메소드
	@Override
	public int UpdateComment(CommunityComment cc) {
		// TODO Auto-generated method stub
		return cd.UpdateComment(sqlSession,cc);
	}


	//댓글 삭제 메소드
	@Override
	public int DeleteReply(CommunityComment cc) {
		// TODO Auto-generated method stub
		return cd.DeleteReply(sqlSession,cc);
	}


	//임시 저장 상세 
	@Override
	public CommunityPost TemporaryDetails(int contentNO) {
		// TODO Auto-generated method stub
		return cd.TemporaryDetails(sqlSession,contentNO);
	}







	


	@Override
	public int commentListcount(int contentno) {
		// TODO Auto-generated method stub
		return cd.commentListcount(contentno ,sqlSession);
	}



	@Override
	public ArrayList<HashMap<String, java.lang.Object>> selectcommentList(PageInfo pi, Integer contentno) {
		// TODO Auto-generated method stub
		return cd.selectcommentList(pi,contentno,sqlSession );
	}






	


	










	







	



	




	
	 
	
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
