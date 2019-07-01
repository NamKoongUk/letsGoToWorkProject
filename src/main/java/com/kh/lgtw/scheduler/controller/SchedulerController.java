package com.kh.lgtw.scheduler.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.messenger.model.vo.Messenger;
import com.kh.lgtw.scheduler.model.service.SchedulerService;
import com.kh.lgtw.scheduler.model.vo.Schedule;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

@Controller
public class SchedulerController {
	@Autowired
	private SchedulerService ss;
	
	@RequestMapping("scheduler.sc")
	public String schedulerHome() {
		return "scheduler/schedulerMain";
	}
	
	//온로드펑션 전체 조회용 메소드
	@GetMapping(value="/allSelectSchedule/sc")
	public @ResponseBody ResponseEntity<HashMap<String, ArrayList<Object>>> allSelectSchedule(HttpSession session) {
		/* System.out.println("컨트롤러 잘 들어왔음"); */
		Employee e =  (Employee) session.getAttribute("loginEmp");
		int empNo = e.getEmpNo();
		
		HashMap<String, ArrayList<Object>> allList = ss.allSelectSchedule(empNo);
		
		return new ResponseEntity<HashMap<String, ArrayList<Object>>>(allList, HttpStatus.OK);
	}

	//스케쥴러 목록 조회용
	@RequestMapping(value="selectSchedulerList.sc")
	public void selectSchedulerList(HttpSession session, HttpServletResponse response){
		/* System.out.println("컨트롤러 들어옴"); */
		Employee e = (Employee) session.getAttribute("loginEmp");
		int empNo = e.getEmpNo();
		
		ArrayList<Scheduler> list = ss.selectSchedulerList(empNo);
		/* System.out.println("컨트롤러 리턴 받은 list : " + list); */
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			new Gson().toJson(list, response.getWriter());
		} catch (JsonIOException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//개인스케쥴러 추가 (ModelAndView로 바뀔 수 있음)
	@RequestMapping("insertMemberScheduler.sc")
	public String insertMemberScheduler(Scheduler sc, HttpSession session, Model model) {
		Employee e =  (Employee) session.getAttribute("loginEmp");
		int empNo = e.getEmpNo();
		
		sc.setCreateEmpNo(empNo);
		
//		System.out.println(sc.getSchedulerColor());
//		System.out.println(sc);
		
		int result = ss.insertMemberScheduler(sc);
		
		if(result > 0) {
//			System.out.println("추가성공!!");
			return "redirect:scheduler.sc";
		}else {
//			System.out.println("추가 실패!");
			return "main/main";
		}
	}
	
	//개인스케쥴러 수정
	@RequestMapping("updateEmpScheduler.sc")
	public String updateEmpScheduler(Scheduler scheduler) {
//		System.out.println("컨트롤러 들어왔음!");
//		System.out.println(scheduler);
		int result = ss.updateEmpScheduler(scheduler);
		
		if(result > 0) {
			return "redirect:scheduler.sc";
		}else {
			return "main/mian";
		}
	}
	
	//개인스케쥴러 삭제
	@RequestMapping("deleteEmpScheduler.sc")
	public String deleteEmpScheduler(Scheduler scheduler) {
//		System.out.println("컨트롤러 진입 : " + scheduler);
		int result = ss.deleteEmpScheduler(scheduler);
		if(result > 0) {
			return "redirect:scheduler.sc";			
		}else {
			return "main/main";
		}
	}
	
	@RequestMapping("changeStatusN.sc")
	public String changeStatusN(Scheduler scheduler) {
		
		int result = ss.changeStatusN(scheduler);
		
		if(result > 0) {
			return "redirect:scheduler.sc";
		}else {
			return "main/main";
		}
	}
	
	@RequestMapping("changeStatusY.sc")
	public String changeStatusY(Scheduler scheduler) {
		
		int result = ss.changeStatusY(scheduler);
		
		if(result > 0) {
			return "redirect:scheduler.sc";
		}else {
			return "main/main";
		}
	}
	
	
	//공유스케쥴러 생성
	@RequestMapping("insertGroupScheduler.sc")
	public String insertGroupScheduler() {
		int result = ss.insertGroupScheduler();
		return "";
	}
	
	//공유스케쥴러 수정
	@RequestMapping("updateGroupScheduler.sc")
	public String updateGroupScheduler() {
		int result = ss.updateGroupScheduler();
		return "";
	}
	
	//공유스케쥴러 삭제
	@RequestMapping("deleteGroupScheduler.sc")
	public String deleteGroupScheduler() {
		int result = ss.deleteGroupScheduler();
		return "";
	}
	
	//일정 추가
	@RequestMapping("insertSchedule.sc")
	public String insertSchedule(HttpSession session, Schedule schedule) {
		Employee e = (Employee) session.getAttribute("loginEmp");
		int empNo = e.getEmpNo();
		
		schedule.setWriter(empNo);
		
//		System.out.println(schedule);
		
		int result = ss.insertSchedule(schedule);
		
		if(result > 0) {
			return "redirect:scheduler.sc";			
		}else {
			return "main/main";
		}
	}
	
	
	//일정 상세정보 조회
	@RequestMapping(value="selectScheduleDetail.sc")
	public void selectScheduleDetail(HttpSession session,@RequestParam int scheduleNo,
										HttpServletResponse response) {
		Employee e = (Employee) session.getAttribute("loginEmp");
		Schedule schedule = new Schedule();
		schedule.setWriter(e.getEmpNo());
		schedule.setScheduleNo(scheduleNo);
		  
		Schedule selectOne = ss.selectScheduleDetail(schedule);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
//		System.out.println(selectOne);
		
		try {
			new Gson().toJson(selectOne, response.getWriter());
		} catch (JsonIOException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//일정 수정
	@RequestMapping("updateSchedule.sc")
	public String updateSchedule(Schedule schedule) {
//		System.out.println("컨트롤러 진입");
//		System.out.println(schedule);
		
		int result = ss.updateSchedule(schedule);
		
		if(result > 0) {
			return "redirect:scheduler.sc";			
		}else {
			return "main/main";
		}
	}
	
	//일정 삭제
	@RequestMapping("deleteSchedule.sc")
	public String deleteSchedule(Schedule schedule) {
//		System.out.println("컨트롤러 들어옴!");
//		System.out.println(schedule);
		
		int result = ss.deleteSchedule(schedule);
		
		if(result > 0) {
//			System.out.println("성공!");
			return "redirect:scheduler.sc";
		}else {
//			System.out.println("실패!");
			return "main/main";
		}
	}
	
	
}





































