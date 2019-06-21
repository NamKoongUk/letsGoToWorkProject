package com.kh.lgtw.employee.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.service.EmployeeService;
import com.kh.lgtw.employee.model.vo.Employee;

@Controller
@SessionAttributes("loginEmp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService emplService;
	
	//화면전환

	//로그인
	@RequestMapping(value="login.em", method=RequestMethod.POST)
	public String loginCheck(Employee employee, Model model) {
		
		try {
			Employee loginEmp = emplService.loginCheck(employee);
			
			model.addAttribute("loginEmp", loginEmp);
			return "main/main";
			
		} catch (LoginException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	//조직도
	@RequestMapping("employee.em")
	public String employeeHome() {
		return "employee/deptGroup";
	}
	//직원목록페이지
	@RequestMapping("showEmployeeList.em")
	public String showEmployeeList() {
		return "employee/employeeList";
	}
	//내 정보 페이지
	@RequestMapping("showMyPage.em")
	public String showEmpPage() {
		return "employee/myEmpPage";
	}

	//휴가신청
	@RequestMapping("showReqHoliday.em")
	public String showReqHolidayList() {
		return "employee/reqHoliday";
	}
	
	//휴가 현황 페이지
	@RequestMapping("showHolidayList.em")
	public String showHolidayList() {
		return "employee/holidayList";
	}
	//휴가 캘린더
	@RequestMapping("showHoliCalender.em")
	public String showHolidayCalender() {
		return "employee/holiCalendar";
	}
	//휴가 관리 페이지
	@RequestMapping("showHolidayAdmin.em")
	public String showHolidayAdminPage() {
		return "employee/holidayAdmin";
	}
	
	//근태 현황 페이지
	@RequestMapping("showAttendStatus.em")
	public String showAttendStatus() {
		return "employee/attendStatus";
	}
	
	//근태 수정 페이지
	@RequestMapping("showUpdateAttenStatus.em")
	public String showUpdateAttenStatus() {
		return "employee/updateAttendStatus";
	}
	
	//조직도 관리
	@RequestMapping("showdeptGroupAdmin.em")
	public String showdeptGroupAdmin() {
		return "employee/deptGroupAdmin";
	}
	
	//조직도 일괄등록
	@RequestMapping("showdpClctvRegister.em")
	public String showdpClctvRegister() {
		return "employee/deptClctvRegister";
	}
	
	
	
	//로그인
	/*
	 * @RequestMapping("login.em") public String loginCheck(Employee employee,
	 * HttpServletRequest request) {
	 * 
	 * //Employee loginUser = emplService.loginEmpl(employee);
	 * 
	 * return ""; }
	 */
	//사원 조회
	@RequestMapping("selectEmpl.em")
	public String selectEmployee(Model model) {
		//ArrayList<Employee> empList = emplService.selectEmlList();
		
		return "";
	}
	//사원 상세 조회
	@RequestMapping("selectOneEmpl.em")
	public String selectOneEmployee(Employee employee, Model model) {
		//Employee emp = emplService.selectOneEmp(employee);
		return "";
	}
	//사원 정보 수정
	@RequestMapping("updateEmpl.em")
	public String updateOneEmployee(HttpServletRequest request, Employee employee, Model model) {
		//Employee loginUser =(Employee)request.getSession().getAttribute("loginUser");
		
		//int result = emplService.updateOneEmp(loginUser,employee);
		
		
		return "";
	}
	//사원 검색
	@RequestMapping("searchEmpl.em")
	public String searchEmployee(Employee employee, Model model) {
		
		//ArrayList<Employee> list = emplService.searchEmp(employee);
		
		return "";
	}
	//조직도 조회
	@RequestMapping("selectDept.em")
	public String selectDept(Model model) {
		
		return "";
	}
	
	//휴가신청
	@RequestMapping("reqHoliday.em")
	public String reqHoliday(HttpServletRequest request, Model model) {
		Employee loginUser =(Employee)request.getSession().getAttribute("loginUser");
		//int result = emplService.reqHoliday(loginUser);
		
		return "";
	}
	
	//휴가 확인
	@RequestMapping("selectHoliday.em")
	public String selectHoliday(HttpServletRequest request, Model model) {
		return "";
	}
	//휴가 신청확인
	@RequestMapping("selectReqHoliday.em")
	public String selectReqHoliday(HttpServletRequest request, Model model) {
		return "";
	}
	
	//근태현황 ATTENDANCE
	@RequestMapping("selectAttend.em")
	public String selectAttend(HttpServletRequest request, Model model) {
		Employee loginUser =(Employee)request.getSession().getAttribute("loginUser");
		
		//Attendace attend = emplService.selectAttend(loginUser);
		
		return "";
	}
	
	//근태수정내역
	@RequestMapping("updateAttendList.em")
	public String updateAttendList(HttpServletRequest request, Model model) {
		return "";
	}
	
	
	
	//인사 관리자
	//근태수정
	@RequestMapping("updateAttend.em")
	public String updateAttend(Employee employee, Model model) {
		return "";
	}
	
	//조직도등록
	@RequestMapping("insertDept.em")
	public String insertDept(Model model) {
		return "";
	}
	
	//사원 한명 추가 
	@RequestMapping("insertOneEmpl.em")
	public String insertEmployee(Employee employee, Model model){
		//int result = emplService.insertEmp(employee);
		return "";
	}
	
	//직무추가
	@RequestMapping("insertDuty.em")
	public String insertDuty(Model model) {
		//int result = emplService.insertDuty();
		return "";
	}
	
	//휴직자 추가
	@RequestMapping("updateLeave.em")
	public String updateLeave(Employee employee, Model model) {
		//int result = emplService.updateLeave(employee);
		return "";
	}
	
	
	//휴직자 조회
	@RequestMapping("selectLeaveList.em")
	public String selectLeaveList(Model model) {
		
		//ArrayList<Employee> leaveList = emplService.selctLeaveList();
		
		return "";
	}
}






















