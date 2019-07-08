package com.kh.lgtw.mail.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.employee.controller.EmployeeController;
import com.kh.lgtw.employee.model.service.EmployeeService;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.mail.model.service.MailService;
import com.kh.lgtw.mail.model.vo.Absence;
import com.kh.lgtw.mail.model.vo.ListCondition;
import com.kh.lgtw.mail.model.vo.Mail;
import com.kh.lgtw.mail.model.vo.Sender;

@Controller
//@RestController
public class MailController {
	@Autowired private MailService ms;
	private HttpStatus httpStatus;
	@Autowired private EmployeeService es;
	 
	// 전체 메일 리스트
	@RequestMapping("mail.ma")
	public String mailHome() {
		return "redirect:allList.ma";
	}	
	
	@RequestMapping("/mail")
	public String mailHome2() {
		return "redirect:allList.ma";
	}
	
	// 메일쓰기페이지
	@RequestMapping("mail/writeForm")
	public String writeMailForm() {
		return "mail/sendMailForm";
	}
	
	// 메일 상세페이지
	@RequestMapping("mail/detail.ma")
	public String mailDetail(int mailNo, Model model) {
		
		Mail mDetail = ms.selectMailDetail(mailNo);
		System.out.println("mDetail : " + mDetail);
		model.addAttribute("mail", mDetail);
		return "mail/mailDetail";
	}
	 
	// 전체 메일함 조회
	@RequestMapping("allList.ma") // HomeController를 여기로 리다이렉트 시키기 
	public String selectMailList(HttpServletRequest request, Model model) {
		
		// 페이징 처리 
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = ms.getMailListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Mail> list = ms.selectMailList(pi);

		if(list != null) {
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			
			return "mail/mailAllList"; 
		}else {
			model.addAttribute("msg", "리스트 조회에 실패!");
			
			return "common/errorPage";
		}
	}
	
	
	
	// 메일상태처리
	@RequestMapping(value="mail/updateStatus",  produces="application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity<String> updateMailStatus(@RequestBody Map<String, Object> map) { 
		int result = 0;
		String body = "";
		try {
			result = ms.updateMailStatus(map);
			
			body = String.valueOf(result);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			body = e.getMessage();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;  // error로 이동
		}
		// new ResponseEntity</*내가 보낼 타입*/>(success 에 들어가는 값, 3항연산자를 해서 값이 넘어 갔을때는 -> 내가 statsus를 지정 status);
		return new ResponseEntity<String>(body, httpStatus);
	}	
	
	// 메일보내기
	@RequestMapping(value="/mail/send", method=RequestMethod.POST)
	public String sendMail(Mail mail, Model model/*, MultipartHttpServletRequest request*//* @RequestParam("files") MultipartFile files*/) {
		mail.setmSize(12345);
		System.out.println("mail : " + mail);
		
//		private int mailNo; 				// 메일번호
//		private String mTitle;				// 제목
//		private String mContent;			// 내용
//		private String sendMail;			// 보내는메일
//		private String reciveMail;			// 받는메일
//		private String dStatus;				// 삭제여부
//		private Date sendDate;				// 보낸날짜
//		private String rStatus;				// 읽음여부
//		private String mailType;			// 메일 종류
//		private int mSize;					// 용량
//		private String reservationCheck;	// 예약여부
//		private Date reservationDate;		// 예약일
//		private Date reservationTime;		// 예약시간
		
//		private String from;								// 보내는곳
//		private List<String> to = new ArrayList<>();		// 받는곳
//		private String subject;								// 제목
//		private String content;								// 내용
		Sender sender = new Sender();
		
		List<String> toList = new ArrayList<>();
		
		toList.add(mail.getReciveMail());
		sender.setTo(toList);
		sender.setFrom(mail.getSendMail());
		sender.setSubject(mail.getmTitle());
		sender.setContent(mail.getmContent());
		System.out.println("sender : "+ sender);
		
		// 전송요청 
		SendMail sendMail = new SendMail();
		sendMail.send(sender);
		
		int result = ms.sendMail(mail);
		
		return "redirect:/mail";
	}
	
	// 예약메일 보내기
	@RequestMapping("sendReserve.ma")
	public String sendReserveMail() {
		return "";
	}
	
	// 메일 검색
	@RequestMapping("mail/search") 
	public String selectSearchMailList(@RequestParam HashMap<String, Object> listCondition, 
				Model model, HttpServletRequest request) {
		// 페이징 설정
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount = ms.getMailSearchListCount(listCondition);
		System.out.println("검색 listCount : " + listCount);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		// 로그인 회원 메일 조회
		String empMail = ((Employee)request.getSession().getAttribute("loginEmp")).getEmail();
		listCondition.put("empMail", empMail);

		// 이름으로 검색했을 때 사원 메일 검색
		List<String> sMail = null;
		if(listCondition.get("sName") != null) {
			sMail = es.selectEmpEamilForName((String)listCondition.get("sName"));
			listCondition.put("sMail", sMail);
		}
		System.out.println("sMail : " + sMail);
		System.out.println("listConition : " + listCondition);
		
		// 검색한 메일 리스트 조회
		ArrayList<Mail> list = ms.selectSearchMailList(pi, listCondition);
		System.out.println("메일 리스트 조회  : " + list);

		if(list != null) {
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			model.addAttribute("listCondition", listCondition);
			
			return "mail/mailAllList";
		}else {
			model.addAttribute("msg", "리스트 조회에 실패!");
			
			return "common/errorPage";
		}
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
	
	// 환경설정 페이지로 이동
	@RequestMapping("setting.ma")
	public String mailSettingHome(HttpSession session, Model model) {

		int empNo = ((Employee) session.getAttribute("loginEmp")).getEmpNo();

		ArrayList<Absence> list = ms.selectAbcenceList(empNo);

		System.out.println("list : " + list);
		model.addAttribute("absenceList", list);

		return "mail/settings";
	}
		 
		 
	// 부재중 추가
	@RequestMapping("mail/put/absence")
	public String insertAbsenceMail(Absence absence, Model model, HttpSession session) {
		System.out.println("absence : " + absence);
		// 세션에 있는 로그인 user정보 absence에 추가
		int empNo = ((Employee) session.getAttribute("loginEmp")).getEmpNo();
		absence.setEmpNo(empNo);
		
		int result = ms.insertAbsenceMail(absence);
		System.out.println("result : " + result);
		
		if(result > 0) {
			return "redirect:/setting.ma";  // 부재중 조회 구현시 리다이렉트 
		}else {
			model.addAttribute("msg", "부재중 정보 추가 실패!");
			return "common/errorPage"; 
		}
	}
	
	// 부재중 정보 수정
	@RequestMapping(value="/mail/updateAbsence/{ aNo }", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String updateAbsence(@PathVariable int aNo) {
		int result ;// = ms.updateAbsence(aNo);
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
