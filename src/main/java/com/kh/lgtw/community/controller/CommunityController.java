package com.kh.lgtw.community.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.community.model.service.CommunityService;
import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
import com.kh.lgtw.community.model.vo.CommunityPost;

@Controller
public class CommunityController { 
	
//	@Autowired
//	private CommunityService cs; 
	@Autowired SqlSession sqlSession;
    // 게시판 조회용 메소드
	
	
	@RequestMapping("community.co")
	public String communityHome() {
		return "community/communityMain";
	}
	
	
	@RequestMapping("communityList.co")
	public String SelectCommunity ( ) {
		return "community/communityList"; 
	}

	@RequestMapping("communityInsert.co")
	public String InsertCommunity() {
		return "community/communityInsert";	
		
	}
	
	@RequestMapping("temporaryList.co")
	public String TemporaryList() {
		return "community/temporaryList";	
	} 
	
	@RequestMapping("managebulletinList.co")
	public String ManagebulletinList () {
		return "community/managebulletinList";
	} 
	
	@RequestMapping("communityPostInsert.co")
	public String CommunityPostInsert(){
		return "community/communityPostInsert";
	}
	
	@RequestMapping("communityPostList.co")
	public String CommunityPostList() {
		return "community/communityPostList";
	}



}
//	
//	//게시판 수정메소드 뷰페이지 이동
//	public String showUpdateView() {
//		return "";
//	}
//	
//	
//	//게시판  수정 메소드 
//	
//	public String UpdateCommunity (Community cm) {
//		
//		int result = cs.UpdateCommunity(cm);
//	
//		if(result > 0) {
//			
//			return "";
//		}else {
//			
//			return ""; 
//		}
//		
//	}
//	
//	//게시판  삭제 메소드 
//		
//	public String DeleteCommunity (Community cm) {
//		int result = cs.DelectCommunity(cm);
//		
//		if(result >0) {
//			return "";
//		}else {
//			return "";
//		}
//		
//		
//		
//	}
//	
//	//게시판 생성 메소드 
//	
//	public String InsertCommunity(Community cm) {
//		int result = cs.InsertCommunity(cm);
//		
//		if(result >0) {
//			return "";
//		}else {
//			return "";
//		}
//		
//	}
//	//게시글 조회 메소드 
//	public String SelectCommunityPost(CommunityPost cp ) {
//		CommunityPost cps; 
//		
//		cps = cs.SelectCommunityPost(cp);
//		
//		return ""; 
//	}
//	
//	//게시글 생성 메소드 
//	
//	public String InsertCommunityPost(CommunityPost cp ,CommunityAttachment ca) {
//		
//		int result = cs.InsertCommunityPost(cp,ca);  
//		
//		if(result > 0) {
//			return "";
//		}
//		else {
//			return "";
//		}
//		
//	}
//	
//	//게시글 삭제 메소드 
//	
//	public String DeleteCommunityPost(CommunityPost cp , CommunityAttachment ca) {
//		int result = cs.DelectCommunityPost(cp,ca);
//		
//		if(result > 0) {
//			return "";
//		}else {
//			return "";
//		}
//		
//	}
//		
//	//게시글 수정 메소드 
//	public String UpdateCommunityPost(CommunityPost cp , CommunityAttachment ca) {
//			int result = cs.UpdateCommunityPost(cp,ca);
//			
//			if(result > 0) {
//				return "";
//			}else {
//				return "" ;
//			}
//			
//		
//		
//		
//	}
//		
//	//게시글 댓글 조회 메소드 
//		
//	public String SelectCommunityComment(CommunityComment cc) {
//			
//			CommunityComment cct; 
//			
//			
//			cct = cs.SelectCommunityComment(cc);
//			
//		return ""; 
//		
//	}
//		
//	//게시글 댓글 생성 메소드 
//		
//		public String insertCommunityComment(CommunityComment cc) {
//			int result = cs.insertCommunityComment(cc);
//			
//			if(result > 0) {
//				return "";
//			}else {
//				return "" ;
//			}
//			
//			
//		}
//		
//		//게시글 댓글 삭제 메소드 
//		
//		public String DeleteCommunityComment(CommunityComment cc) {
//					int result = cs.DeleteCommunityComment(cc);
//					
//					if(result > 0) {
//						return "";
//					}else {
//						return "" ;
//					}
//					
//					
//				}
//		
//		//게시글 댓글 수정 메소드 
//				
//		public String UpdateCommunityComment(CommunityComment cc) {
//			int result = cs.UpdateCommunityComment(cc);
//					
//			if(result > 0) {
//				return "";
//			}else {
//				return "" ;
//			}
//					
//					
//				}
//			
		

/* } */
