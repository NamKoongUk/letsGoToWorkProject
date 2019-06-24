package com.kh.lgtw.scheduler.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.lgtw.employee.model.vo.Employee;
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
	
	//전체 공통 조회용 컨트롤러
	@RequestMapping("allSelectSchedule.sc")
	public String allSelectSchedule(HttpSession session) {
		Employee e =  (Employee) session.getAttribute("loginUser");
		int empNo = e.getEmpNo();
		
		HashMap<String, ArrayList<Object>> allList = ss.allSelectSchedule(empNo);
		return "";
	}
	
	//스케쥴러 목록 조회용
	@RequestMapping(value="selectSchedulerList.sc")
	public void selectSchedulerList(HttpSession session, HttpServletResponse response){
		System.out.println("컨트롤러 들어옴");
		Employee e = (Employee) session.getAttribute("loginEmp");
		int empNo = e.getEmpNo();
		
		ArrayList<Scheduler> list = ss.selectSchedulerList(empNo);
		System.out.println("컨트롤러 리턴 받은 list : " + list);
		
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
		
		System.out.println(sc.getSchedulerColor());
		System.out.println(sc);
		
		int result = ss.insertMemberScheduler(sc);
		
		if(result > 0) {
			System.out.println("추가성공!!");
			return "scheduler/schedulerMain";
		}else {
			System.out.println("추가 실패!");
			return "main/main";
		}
	}
	
	//개인스케쥴러 수정
	@RequestMapping("updateMemberScheduler.sc")
	public String updateMemberScheduler() {
		int result = ss.updateMemberScheduler();
		return "";
	}
	
	//개인스케쥴러 삭제
	@RequestMapping("deleteMemberScheduler.sc")
	public String deleteMemberScheduler() {
		int result = ss.deleteMemberScheduler();
		return "";
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
		
		System.out.println(schedule);
		
		if(schedule.getStartTime() == null) {
			schedule.setStartTime("00:00");
			schedule.setEndTime("23:59");
		}
		
		int result = ss.insertSchedule(schedule);
		
		if(result > 0) {
			return "scheduler/schedulerMain";			
		}else {
			return "main/main";
		}
	}
	
	//일정 상세정보 조회
	@RequestMapping("selectScheduleDetail.sc")
	public String selectScheduleDetail() {
		Schedule schedule = ss.selectScheduleDetail();
		return "";
	}
	
	//일정 수정
	@RequestMapping("updateSchedule.sc")
	public String updateSchedule() {
		int reulst = ss.updateSchedule();
		return "";
	}
	
	//일정 삭제
	@RequestMapping("deleteSchedule.sc")
	public String deleteSchedule() {
		int result = ss.deleteSchedule();
		return "";
	}
}





































