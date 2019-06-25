package com.kh.lgtw.mail.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.mail.model.service.MailService;
import com.kh.lgtw.mail.model.vo.Mail;

@Controller
//@RestController
public class MailController {
	
	@Autowired private MailService ms; 
	
	// 전체 메일 리스트
	@RequestMapping("mail.ma")
	public String mailHome() {
		return "redirect:allList.ma";
	}
	 
	// 메일 전송포맷
	@RequestMapping("sendMailForm.ma")
	public String sendMailForm() {
		return "mail/sendMailForm";
	}
	
	// 메일 상세페이지
	@RequestMapping("mail/detail.ma")
	public String mailDetail() {
		// 파라미터 값으로 받아야 함
		
		return "mail/mailDetail";
	}
	 
	// 환경설정 페이지로 이동
	 @RequestMapping("setting.ma")
	 public String mailSettingHome() {
		 return "mail/settings";
	 }
	
	// 전체 메일함 조회
	@RequestMapping("allList.ma") // HomeController를 여기로 리다이렉트 시키기 
	public String selectMailList(HttpServletRequest request, Model model) {
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = ms.getMailListCount();
		// System.out.println("메일 갯수 조회 : " + listCount);
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Mail> list = ms.selectMailList(pi);
		// System.out.println("메일 리스트 조회  : " + list);

		if(list != null) {
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			
			return "mail/mailMain";
		}else {
			model.addAttribute("msg", "리스트 조회에 실패!");
			
			return "common/errorPage";
		}
	}
	
	// 하나로 합친다면 
	@RequestMapping("mail/mailList.ma")
	public String mailList(HttpServletRequest request) {
		
		String pageType = request.getParameter("pageType");
		// 비즈니스 로직 
		
		switch(pageType) {
			case "all" : return ""; 
			case "send" : return ""; 
			case "recieve" : return ""; 
			case "outBox" : return ""; 
			case "trash" : return ""; 
		}
		return null;
	}
	
	// 메일상태처리
	@RequestMapping(value="mail/updateStatus",  produces="application/json; charset=utf8")
	public String updateMailStatus(@RequestBody Map<String ,Object> map ) { 
		// 읽음처리할 메일의 id 값들을 배열로 받아서 처리한다. 
		// 페이징 처리도 잊지 말기 
		// request 페이지 이름값 받기
		
		System.out.println("넘어온다.");
		System.out.println(map);
		System.out.println(map.get("checkList"));
		System.out.println(map.get("type"));
		
		try {
			int result = ms.updateMailStatus(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// new ResponseEntity</*내가 보낼 타입*/>(success 에 들어가는 값, 3항연산자를 해서 값이 넘어 갔을때는 -> 내가 statsus를 지정 status);
		return null;
	}
	
	// 메일 - 삭제처리
	@RequestMapping("updateDelete.ma")
	public String updateDeleteMail(HttpServletRequest request) {
		// 페이징 처리도 잊지 말기 
		// 업데이트후 리스트 조회
		return "";
	}
	
	
	// 메일 작성
//	@RequestMapping("mailSearchList.ma")
//	public String mailSearchList(HttpServletRequest request) {
//		return "";
//	}
	
	// 환경설정
	@RequestMapping("settings.ma")
	public String settingMail() {
		return "";
	}
	
	// 메일쓰기페이지
	@RequestMapping("writeForm.ma")
	public String writeMailForm() {
		return "";
	}
	
	// 메일보내기
	@RequestMapping("send.ma")
	public String sendMail() {
		return "";
	}
	
	// 예약메일 보내기
	@RequestMapping("sendReserve.ma")
	public String sendReserveMail() {
		return "";
	}
	
	// 전체 메일함 검색
	@RequestMapping("searchList.ma") // HomeController를 여기로 리다이렉트 시키기 
	public String selectSearchMailList(int currentPage, Model model) {
		return null;
	}
	
	// 받은메일함
	@RequestMapping("receiveList.ma")
	public String selectReceiveMailList() {
		return null;
	}
	
	// 보낸메일함
	@RequestMapping("mail/sendList.ma")
	public String selectSencMailList() {
		return null;
	}
	
	// 임시보관함
	@RequestMapping("outBoxList.ma")
	public String selectOutBoxList() {
		return null;
	}
	
	// 휴지통
	@RequestMapping("trashList.ma")
	public String selectTrashMailList() {
		return null;
	}
	
	// 부재중 정보 조회
	@RequestMapping("absenceList.ma")
	public String selectAbsenceList() {
		return "";
	}
	
	// 부재중 추가
	@RequestMapping("put/absence.ma")
	public String insertAbsenceMail() {
		return "";
	}
	
	// 서명 추가
	@RequestMapping("put/sign.ma")
	public String insertSign() {
		return "";
	}
	
	// 서명정보 조회 
	@RequestMapping("sign.ma")
	public String selectSignList() {
		return "";
	}
}
