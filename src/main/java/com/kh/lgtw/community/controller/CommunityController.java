package com.kh.lgtw.community.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.lgtw.community.model.service.CommunityService;
import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityPost;
import com.kh.lgtw.employee.model.vo.Employee;
@SessionAttributes("loginEmp")
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
	//게시판 생성 양식폼 
	
	  @RequestMapping("insertCommunityForm.co") 
	  public String selectCommunityForm()
	  {
	  
		  return "community/communityInsert"; 
	  }
	 
	
	
	// 게시판 생성용 메소드 
	@RequestMapping("communityInsert.co")
	public String InsertCommunity(Community com ,HttpSession session) 
	{
		Employee loginUser =(Employee)session.getAttribute("loginEmp");
		
		System.out.println("loginUser:"+loginUser.getEmpNo());	
		System.out.println("Community:" +com);
		com.setCreateUser(loginUser.getEmpNo()); 
		
		
		int result =cs.InsertCommunity(com);
		
		
		
		
		
		return "redirect:communityList.co";	
	}
	
	// 임시저장  리스트 메소드 
	@RequestMapping("temporaryList.co")
	public String TemporaryList(Model model) {
		ArrayList<CommunityPost> list = cs.SelectTemporaryList();
		model.addAttribute("list",list);
		
		return "community/temporaryList";	
	} 
	// 게시판 관리용 메소드
	@RequestMapping("managebulletinList.co")
	public String ManagebulletinList (Model model) {
		ArrayList<Community> list = cs.SelectManagebulletinList();
		model.addAttribute("list",list);
		
		return "community/managebulletinList";
	} 
	//게시글 생성 폼 메소드  
	@RequestMapping("communityPostInsertForm.co")
	public String CommunityPostInsertForm(Model model) {
		ArrayList<Community> list = cs.SelectCommunity();
		model.addAttribute("list",list);
		return "community/insertCommunityFormPS";
	}
	
	// 개시글 생성용 매소드
	@RequestMapping("communityPostInsert.co")
	public String CommunityPostInsert(Community com,CommunityPost cp ,HttpSession session ){
		
		 Employee loginUser =(Employee)session.getAttribute("loginEmp"); 
		
		 
		 System.out.println("Community:" + com);
		 System.out.println("CommunityPost : " +cp);
		 
		  
		 cp.setBno(com.getBno()); 
		 cp.setBwriter(loginUser.getEmpNo());
		 
		 int result = cs.CommunityPostInsert(cp); 
		 
		 
		 
		 
		
		
		return "redirect:communityList.co";
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
	public String CommunityPostDetails(Model model, int contentNO) {
		
		System.out.println("게시글 상세  contentNO 값:"+contentNO);
		ArrayList<CommunityPost> list = cs.CommunityPostDetails(contentNO);
		model.addAttribute("list",list);
		return "community/communityPostDetails";
	}
	
	//게시판 수정폼  메소드
	@RequestMapping("communityUpdateForm.co")
	public String communityUpdateForm(Model model ,HttpServletRequest request) 
	{
		 
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		System.out.println("request" +bno);
		 
		Community com = cs.communityUpdateForm(bno);  
		
		
		model.addAttribute("com",com);
		
		
		  
		return "community/communityupdate";
	}
	//게시판 수정 메소드
	@RequestMapping("communityUpdate.co")
	public String communityUpdate(Community com ,HttpSession session, HttpServletRequest request) {
		Employee loginUser =(Employee)session.getAttribute("loginEmp"); 
	
		System.out.println("controller Community 값:"+ com);
		com.setCreateUser(loginUser.getEmpNo()); 
		System.out.println("crewate 성공");
		int result = cs.communityUpdate(com); 
		System.out.println("controller Result : " + result);
		
		if(result >0) {
			return "redirect:index.jsp";
		}else {
			System.out.println("잘못된 접근 입니다");
			return "redirect:index.jsp";
		}
		
		
		 
		
	}   
	
	@RequestMapping("communityUpdateCencel.co")
	public String communityUpdateCencel() {
		
	
		return "redirect:managebulletinList.co";
	}
	
	
	

}
