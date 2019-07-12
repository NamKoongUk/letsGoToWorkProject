package com.kh.lgtw.mail.controller;

import static com.kh.lgtw.common.CommonUtils.getServerTime;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.employee.model.service.EmployeeService;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.mail.aws.AwsS3;
import com.kh.lgtw.mail.aws.JavaMailSender;
import com.kh.lgtw.mail.model.service.MailService;
import com.kh.lgtw.mail.model.vo.Absence;
import com.kh.lgtw.mail.model.vo.Mail;
import com.kh.lgtw.mail.model.vo.Sender;

@Controller
//@RestController
public class MailController {
	@Autowired private MailService ms;
	@Autowired private EmployeeService es;
	@Autowired private JavaMailSender mailSender; 

	private AwsS3 s3;

	private HttpStatus httpStatus;
	private SimpleMailMessage simpleMailMessage;
	
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
	@RequestMapping(value="/mail/send", method=RequestMethod.POST, headers="Content-Type=multipart/form-data")
	public String sendMail(Mail mail, Model model, HttpServletRequest request,
					@RequestParam(name="mailAttachment", required=false) MultipartFile mailAttachment) {
		System.out.println("controller에서 받은 mail : " + mail);
		System.out.println("controller에서 받은 mailAttachment : " + (mailAttachment.getOriginalFilename()).equals(""));
		
		// 전송 메시지 정보를 sender 객체에 담는다.  -> 내가 정의한 VO와 다른 형태이므로 하나씩 옮겨준다.
		// sender클래스는 하나의 메일을 여러명에게 전송하는 형태로 구성되어 있다.
		Sender sender = new Sender();
		List<String> toList = new ArrayList<>();
		toList.add(mail.getReciveMail());
		sender.setTo(toList);
		sender.setFrom(mail.getSendMail());
		sender.setSubject(mail.getmTitle());
		sender.setContent(mail.getmContent());
		
		// SimpleMailMessage라고해서 mail API에서 제공하는 메시지 포멧에 데이터를 넣어준다.
		simpleMailMessage = new SimpleMailMessage();	
		simpleMailMessage.setFrom(sender.getFrom());
		simpleMailMessage.setTo(sender.getTo().get(0));
		simpleMailMessage.setSubject(sender.getSubject());
		simpleMailMessage.setText(sender.getContent());
		
		System.out.println("simpleMailMessage : " + simpleMailMessage);
		System.out.println("mailSender " + mailSender);

		// 전송요청 
		if(!(mailAttachment.getOriginalFilename()).equals("")) { // 첨부파일이 존재하면
			System.out.println("mailAttachment : " + mailAttachment);
			mail.setmSize((int) mailAttachment.getSize());  // mail의 파일 사이즈 지정해주기 원래는 long형
			
			// 첨부파일 저장 처리
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			// 파일 저장 위치 
			String filePath = root + "\\uploadFiles\\mail\\sendFiles";
			
			String originFileName = mailAttachment.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			
			// System.currentTimeMillis()는 서버 시간 -> getServerTime
			String changeName = mail.getSendMail() + "_" + getServerTime();
			
			
			System.out.println("첨부파일 있는 메일 전송 시작!");
			File attachment;
			try {
				mailAttachment.transferTo(new File(filePath + "\\" + changeName + ext));
				attachment = new File(filePath + "\\" + changeName + ext);
				mailSender.send(simpleMailMessage, attachment);
			} catch (IllegalStateException | IOException e) {
				// new File(filePath + "\\" + changeName + ext).delete(); 
				model.addAttribute("msg", "파일 첨부 실패!");
				return "common/errorPage";		
			}
		}else { // 첨부파일이 존재하지 않으면
			System.out.println("첨부파일 없는 메일 전송시작!");
			mailSender.send(simpleMailMessage);
		}
		// 메일 전송 메소드 호출 
		// sendMailMessage(sender); // 아래에 있는 메소드로 테스트 하는 방식  // 에러남
		System.out.println("JavaMailSender를 이용한 메일 발송 완료!");
		
		// 전송이 완료되었을 때 데이터 베이스에 정보 저장 
		ms.sendMail(mail);
		
		/*-------------------------------------------------------------------------------*/
		// s3테스트를 위한 코드들 
		// 메일 전송이 완료되면 저장들어온 메일리스트를 불러온다.
		// 버킷 리스트 가져오기 
		
		return "redirect:/mail";
	}
	
	// 메일 보내기의 메소드  // aws가 아닌 일반적으로 mailAPI에서 첨부파일을 전송하는 방식
	public void sendMailMessage(Sender sender) {   // 매개변수로 첨부파일 받기   // 테스트 해보고 다르면 메소드 두개 만들기 
		// 첨부파일 메일 전송 
		// MessageSenderImpl에 존재하는 send메소드 호출
		System.out.println("mailsender.send시작");
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				System.out.println("prepare 시작");
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
				helper.addTo(sender.getTo().get(0));
				helper.setFrom(sender.getFrom());
				// helper.addAttachment(attachmentFilename, file); // 첨부파일 추가하기 // 파일 추가해서 검토하기
				helper.setSubject(sender.getSubject());
				helper.setText(sender.getContent(), false);   // false뭔지 확인하기 
			}
		});
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
	
	// s3 버킷으로 들어오 메시지를 DB에 넣어주는 메소드
	@RequestMapping("mail/s3")
	public String runS3Method() {
		// **** 프로세스  **** 
		// 리스트를 조회할때 버킷을 조회해서 받은 파일이 존재하면 -> eml파일로 복사후 삭제과정
		// eml파일로 복사후 eml형식을 받아와 메시지 객체에 저장한다. 
		List<S3ObjectSummary> objects = s3.getObjects("lgtw-mail");
		System.out.println("버킷 객체 리스트 가져오기 : " + objects);
		
		if(objects.size() <= 0) {
			System.out.println("버킷에 객체가 존재하지 않습니다.");
			return "redirect:/allList.ma";
		}
		
		for(S3ObjectSummary object : objects) {
			// 객체의 내용을 출력
			s3.downloadObject(object.getBucketName(), object.getKey());
			
			// eml파일로 복사 
			s3.updateObjectForEmlExt(object.getKey());
			
			// 확인을 완료하면 버킷에서 삭제한다. 
			s3.deleteObject(object.getBucketName(), object.getKey());
		}
		
		List<S3ObjectSummary> emlObjects = s3.getObjects("lgtw-mail-eml");
		System.out.println("eml 리스트 가져오기 : " + emlObjects);
		
		for(S3ObjectSummary object : emlObjects) {
			// 객체의 내용을 출력
			s3.downloadObject(object.getBucketName(), object.getKey());
			
			// eml파일 처리하는 메소드 
			Message message= s3.getEmlFile(object.getKey());
			
			Mail reciveMail = new Mail();
			try {
				reciveMail.setMailType("받은메일");
				reciveMail.setObjContent(message.getContent());
				reciveMail.setmTitle(message.getSubject());
				reciveMail.setmSize(message.getSize());
				reciveMail.setSendStringDate(message.getSentDate());
				reciveMail.setSendMail(message.getFrom()[0].toString());
				reciveMail.setReciveMail(message.getAllRecipients()[0].toString());
			} catch (IOException | MessagingException e) {
				e.printStackTrace();
			}

			// 메시지 객체에 저장해서 데이터를 불러온 후에 데이터베이스에 맞춰서 저장
			ms.insertReciveMail(reciveMail);
			
			// eml파일 삭제
			s3.deleteObject(object.getBucketName(), object.getKey());
		}
		
		// 리스트 조회
		return "redirect:/allList.ma";
	}
}
