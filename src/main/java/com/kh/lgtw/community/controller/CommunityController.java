package com.kh.lgtw.community.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.community.model.service.CommunityService;
import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityPost;

@Controller
public class CommunityController { 
	
	 @Autowired private CommunityService cs;
	  
	 @Autowired SqlSession sqlSession;
	 

	// 게시판  main 조회 메소드
	@RequestMapping("community.co")
	public String communityHome() {
		
		return "community/communityMain";
	}
	
	
	// 게시판 리스트 조회용 메소드 
	@RequestMapping("communityList.co")
	public String SelectCommunity (Model model) {
		
		  ArrayList<Community> list; 
		  
		  list = cs.SelectCommunity();
		  System.out.println("list 값 ="+list);
		  
		   
		  for(int i=0 ; i <list.size();i++) {
			   System.out.println(list.get(i));
		  }
		  
		  model.addAttribute("list", list);
		  
		  
		return "community/communityList"; 
	}

	// 게시판 생성용 메소드 
	@RequestMapping("communityInsert.co")
	public String InsertCommunity() {
		return "community/communityInsert";	
	}
	
	// 임시저장  리스트 메소드 
	@RequestMapping("temporaryList.co")
	public String TemporaryList() {
		return "community/temporaryList";	
	} 
	// 게시판 관리용 메소드
	@RequestMapping("managebulletinList.co")
	public String ManagebulletinList () {
		return "community/managebulletinList";
	} 
	
	// 개시글 생성용 매소드
	@RequestMapping("communityPostInsert.co")
	public String CommunityPostInsert(){
		return "community/communityPostInsert";
	}
	// 게시글 조회용 매소드
	@RequestMapping("communityPostList.co")
	public String CommunityPostList(Model model ,int bno ) 
	{
		

		System.out.println("bno 값:"+bno);  
		
		ArrayList<CommunityPost> list = cs.CommunityPostList(bno);
		model.addAttribute("list",list); 
		
		System.out.println("CommunityPost="+list);
		
		
		return "community/communityPostList";
	}
	// 게시글 상세 조회 메소드
	@RequestMapping("communityPostDetails.co")
	public String CommunityPostDetails() {
		return "community/communityPostDetails";
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
