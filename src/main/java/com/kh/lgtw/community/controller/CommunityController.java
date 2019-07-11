package com.kh.lgtw.community.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.CommonUtils;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.community.model.service.CommunityService;
import com.kh.lgtw.community.model.vo.Community;
import com.kh.lgtw.community.model.vo.CommunityAttachment;
import com.kh.lgtw.community.model.vo.CommunityComment;
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
	@RequestMapping(value="communityPostInsert.co")
	public String CommunityPostInsert(Model model,Community com,CommunityPost cp,HttpServletRequest request ,HttpSession session ,@RequestParam(name="files" ,required = false) MultipartFile files ,CommunityAttachment ca){
		
		 Employee loginUser =(Employee)session.getAttribute("loginEmp"); 
		
		 
		 System.out.println("Community:" + com);
		 System.out.println("CommunityPost : " +cp);
		 
		  
		 cp.setBno(com.getBno()); 
		 cp.setBwriter(loginUser.getEmpNo());
		 
		 
		 String root = request.getSession().getServletContext().getRealPath("resources");
		 String filePath = root +"\\uploadFiles";
		 
		 System.out.println(filePath);
		 
		 
		 int result = cs.CommunityPostInsert(cp); 
		 
		 String originFileName = files.getOriginalFilename();
		 System.out.println("originFileName값:" +originFileName);
		 String ext = originFileName.substring(originFileName.lastIndexOf("."));
		 System.out.println("ext값:" +ext);
		 String changeName = CommonUtils.getRandomString();
		 System.out.println("changeName:" +changeName); 
		 
		 ca.setOriginName(originFileName);
		 ca.setChangName(changeName);
		 ca.setFilePath(filePath); 
		 ca.setFileType(ext); 
		 ca.setPsno(cp.getContentNO()); 
		 
		 System.out.println("ca값 :" +ca); 
		 
		 HashMap<String ,Object> file = new HashMap<String,Object>();
		 
		 
		 
		 
		 
		 
		 
		 
	
		 
		 try {
			 files.transferTo(new File(filePath + "\\" + changeName + ext));
			 return "redirect:communityList.co";
		 }catch(Exception e) {
			 new File(filePath + "\\" + changeName + ext).delete();
			 return "redirect:communityList.co";
		 }
		 
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
		ArrayList<CommunityComment>commentlist = cs.commentlist(contentNO); 
		model.addAttribute("list",list);
		model.addAttribute("commentlist",commentlist );
		
		System.out.println("comentComment" +commentlist );
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
			return "redirect:managebulletinList.co";
		}else {
			System.out.println("잘못된 접근 입니다");
			return "redirect:managebulletinList.co";
		}
		
		
		 
		
	}   
	
	//게시판 수정 취소 메소드
	@RequestMapping("communityUpdateCencel.co")
	public String communityUpdateCencel(HttpServletRequest request) {
		
	
		return "redirect:managebulletinList.co";
	} 
	
	//게시글 수정폼
	@RequestMapping("communityPostUpdateForm.co")
	public String communityPostUpdateForm (HttpServletRequest request , Model model) {
		
		int contentno = Integer.parseInt(request.getParameter("contentno")); 
		
		System.out.println("CommunityPostUpdate request 값:" + contentno);
		
		CommunityPost cp = cs.communityPostUpdateForm(contentno);
		
		model.addAttribute("cp", cp);
		
		System.out.println("게시글 수정폼 cp 값: " +cp);
		
		
		return "community/updateCommunityFormPS";
	} 
	
	//게시글 수정 메소드
	@RequestMapping("communityPostUpdate.co") 
	public String  communityPostUpdate (CommunityPost cp ,HttpServletRequest request ) 
	{  
		
		 int result = cs.communityPostUpdate(cp); 
		 
		 System.out.println("게시글 수정 성공 유무 : " +result); 
		 System.out.println("게시글 정보 컨트롤러:" +cp);
		 
		
		  if(result >0) 
		  {
		   return "redirect:/communityPostDetails.co?contentNO="+cp.getContentNO(); 
			  }
		  else {
		  System.out.println("잘못된 접근 입니다"); 
		  return "redirect:/communityPostDetails.co?contentNO="+cp.getContentNO();  
		  }
		 
		 
		 
		
		
	} 
	
	//게시글 삭제
	@RequestMapping("communityPostDelete.co")
	
	public String communityPostDelete (HttpServletRequest request) 
	{
		int contentno = Integer.parseInt(request.getParameter("contentno")); 
		System.out.println("contentno 게시글 삭제 값 :" +contentno); 
		int bno       = Integer.parseInt(request.getParameter("bno")); 
		System.out.println("bno값 출력 :"+bno );
		
		int result = cs.communityPostDelete(contentno); 
		
		System.out.println("게시글 삭제 유무:" +result);
		

		  if(result >0) 
		  { 
		   return "redirect:/communityPostList.co?bno="+bno; 
			  }
		  else {
		  System.out.println("잘못된 접근 입니다"); 
		  return "redirect:/communityPostList.co?bno="+bno; 
		  }
		
		
		
		
		
		
	} 
	
	//게시판 삭제
	@RequestMapping("communityDelete.co")
	public String communityDelete (HttpServletRequest request) {
		
		int bno = Integer.parseInt(request.getParameter("bno")); 
		
		System.out.println("게시판 삭제 :bno 값" +bno);
		
		int result = cs.communityDelete(bno);
		
		

		  if(result >0) 
		  { 
		   return "redirect:managebulletinList.co"; 
			  }
		  else {
		  System.out.println("잘못된 접근 입니다"); 
		  return "redirect:managebulletinList.co"; 
		  }
		
		
	} 
	//게시판 생성 취소
	@RequestMapping("communityInsertCansel.co")  
		public String communityInsertCansel (HttpServletRequest request) {
		
		return "redirect:index.jsp";
	}
	
	//게시글 임시 저장  insert
	@RequestMapping("temporayInsert.co") 
		public String temporayInsert (Community com,CommunityPost cp ,HttpSession session) {
		
		Employee loginUser =(Employee)session.getAttribute("loginEmp"); 
		
		 
		 System.out.println("임시 저장 :Community:" + com);
		 System.out.println("임시 저장 :CommunityPost : " +cp);
		 
		  
		 cp.setBno(com.getBno()); 
		 cp.setBwriter(loginUser.getEmpNo());
		 
		 
		 int result = cs.temporayInsert(cp);
		
		return "redirect:temporaryList.co";
	} 
	
	/*
	 * //게시판 댓글 생성
	 * 
	 * @RequestMapping(value="/community/InsertComment.co")
	 * 
	 * @ResponseBody public String
	 * ajax_addComment(@ModelAttribute("CommunityComment")CommunityComment ccm
	 * ,HttpServletRequest request) {
	 * 
	 * 
	 * 
	 * return "success"; }
	 */ 
	
	@RequestMapping("insertComment.co")
	@ResponseBody
	public String InsertComment (HttpServletRequest request ,CommunityComment cc) {
		
		int writer = Integer.parseInt(request.getParameter("writer")); 
		int contentno = Integer.parseInt(request.getParameter("contentno")); 
		String ccontent = request.getParameter("ccontent"); 
		
		
		
		System.out.println("writer 값 :" +writer); 
		System.out.println("contentno 값:"+contentno );
		System.out.println("ccontent 값:" +ccontent);
		
		
		cc.setPsno(contentno);
		cc.setCcontent(ccontent);
		cc.setCwriter(writer);
		
		System.out.println(cc); 
		
		
		
		 int result = cs.InsertComment(cc); 
		/*
		 * ArrayList<CommunityPost> list = cs.CommunityPostDetails(contentno);
		 * ArrayList<CommunityComment>commentlist = cs.commentlist(contentno);
		 */
		
		 if(result > 0) {
			 System.out.println("댓글 작성 성공 : " + result);
			 
			/* HashMap<String, Object> hmap = new HashMap<String, Object>(); */
			 
			 
			
		 }
		 
		 
		
		return "ok";
		
		
		
		
	}
	
	@RequestMapping("updateComment.co")
	@ResponseBody
	public String  UpdateComment(HttpServletRequest request ,CommunityComment cc) {
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		String ccontent =request.getParameter("ccontent");
		int contentno =  Integer.parseInt(request.getParameter("contentno"));
		
		
		System.out.println("cno :" + cno);
		System.out.println("ccontent :" +ccontent); 
		System.out.println("contentno:" +contentno);
		
		
		cc.setCno(cno);
		cc.setCcontent(ccontent);
		cc.setPsno(contentno);
		
		System.out.println("cc 값 확인 :" +cc);
		
		
		int result = cs.UpdateComment(cc);
		
		
		
		return "ok";
	} 
	
	
	@RequestMapping("deleteReply.co")
	@ResponseBody
	
	public String DeleteReply (HttpServletRequest request ,CommunityComment cc) 
	{
		int cno = Integer.parseInt(request.getParameter("cno"));
		int contentno =  Integer.parseInt(request.getParameter("contentno")); 
		
		cc.setCno(cno);
		cc.setPsno(contentno);
		
		int result = cs.DeleteReply(cc);
		
		
		
		return "ok";
	}
	
	//임시저장 상세 페이지
	@RequestMapping("communityPostTemporaryDetails.co") 
	
	public String  TemporaryDetails (Model model, int contentNO) {
		
		CommunityPost cp = cs.TemporaryDetails(contentNO);
		model.addAttribute("cp", cp);
		
		return "community/communityPostTemporary";
	}
	
	
	/*
	 * @GetMapping(value="/selectComment/{currentPage}") public @ResponseBody
	 * ResponseEntity<HashMap<String,Object>>selectComment(@PathVariable Map<String
	 * ,Object> params , HttpServletRequest request){
	 * 
	 * System.out.println(params);
	 * 
	 * int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	 * 
	 * System.out.println(currentPage);
	 * 
	 * int listCount = cs.selectCommentCount(params); PageInfo pi = new PageInfo();
	 * pi =
	 * Pagination.getPageInfo(Integer.parseInt(params.get("currentPage").toString())
	 * , listCount);
	 * 
	 * ArrayList<HashMap<String,Object>> list = cs.selectComment(params);
	 * 
	 * HashMap<String,Object> hmap = new HashMap<String ,Object> ();
	 * 
	 * hmap.put("pi", (Object) pi); hmap.put("list", (Object) list);
	 * 
	 * return new ResponseEntity<HashMap<String,Object>>(hmap,HttpStatus.OK);
	 * 
	 * }
	 */	
	
	
	 @RequestMapping("commentList.co")  
	 public  ModelAndView  commentList(@RequestParam Integer contentno , @RequestParam Integer curPage) 
	 {
		int listcount = cs.commentListcount(contentno);
	   
		System.out.println("listcount 값 :" +listcount);
	   System.out.println("contentno 값:"+contentno); 
	   System.out.println("curPage 값:"+curPage);
	  
	   PageInfo pi = Pagination.getPageInfo(curPage, listcount);
		 
	   
	   System.out.println("pi:"+ pi);
	   
	   ArrayList<CommunityComment> list = cs.selectcommentList(contentno);
	   HashMap<String,Object> hmap = new HashMap<String,Object>();
	   
		/*
		 * hmap.put("pi",pi); hmap.put()"list" )
		 */
	  
	   
		 
		 return null; 
	 }
	

}
