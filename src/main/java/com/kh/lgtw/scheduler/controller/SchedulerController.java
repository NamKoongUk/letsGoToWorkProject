package com.kh.lgtw.scheduler.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.scheduler.model.service.SchedulerService;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

@Controller
public class SchedulerController {
	@Autowired
	private SchedulerService ss;
	
	//전체 공통 조회용 컨트롤러
//	@RequestMapping("allSelectSchedule.sc")
//	public String allSelectSchedule(HttpSession session) {
//		Employee e =  (Employee) session.getAttribute("loginUser");
//		int eid = e.getEid();
//		
//		HashMap<String, ArrayList<Object>> allList = ss.allSelectSchedule(eid);
//		
//		return "";
//	}
	
	//개인스케쥴러 추가 (ModelAndView로 바뀔 수 있음)
//	@RequestMapping("insertMemberScheduler.sc")
//	public String insertMemberScheduler(HttpSession session, Scheduler sc) {
//		Employee e =  (Employee) session.getAttribute("loginUser");
//		int eid = e.getEid();
//		
//		sc.setCreateEmpNo(eid);
//		
//		int result = ss.insertMemberScheduler(sc);
//		
//		return "";
//	}
	
	//개인스케쥴러 수정
//	@RequestMapping("updateMemberScheduler.sc")
//	public String updateMemberScheduler() {
//		
//		int result = ss.updateMemberScheduler();
//		
//		return "";
//	}
	
	//개인스케쥴러 삭제
//	@RequestMapping("deleteMemberScheduler.sc")
//	public String deleteMemberScheduler() {
//		
//		int result = ss.deleteMemberScheduler();
//		
//		return "";
//	}
	
	//공유스케쥴러 생성
//	@RequestMapping("insertGroupScheduler.sc")
//	public String insertGroupScheduler() {
//		
//		int result = ss.insertGroupScheduler();
//		
//		return "";
//	}
	
//	//공유스케쥴러 수정
//	@RequestMapping("updateGroupScheduler.sc")
//	public String updateGroupScheduler() {
//		
//		int result = ss.updateGroupScheduler();
//		
//		return "";
//	}
	
	//공유스케쥴러 삭제
//	@RequestMapping("deleteGroupScheduler.sc")
//	public String deleteGroupScheduler() {
//		
//		int result = ss.deleteGroupScheduler();
//		
//		return "";
//	}
	
	//일정 추가
//	@RequestMapping("insertSchedule.sc")
//	public String insertSchedule() {
//		
//		int result = ss.insertSchedule();
//		
//		return "";
//	}
	
	//일정 상세정보 조회
//	@RequestMapping("selectScheduleDetail.sc")
//	public String selectScheduleDetail() {
//		
//		Schedule schedule = ss.selectScheduleDetail();
//		
//		return "";
//	}
	
	//일정 수정
//	@RequestMapping("updateSchedule.sc")
//	public String updateSchedule() {
//		
//		int reulst = ss.updateSchedule();
//		
//		return "";
//	}
	
	//일정 삭제
//	@RequestMapping("deleteSchedule.sc")
//	public String deleteSchedule() {
//		
//		int result = ss.deleteSchedule();
//		
//		return "";
//	}
	
	
	
	
	
}





































