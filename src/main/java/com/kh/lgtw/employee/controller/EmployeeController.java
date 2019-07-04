package com.kh.lgtw.employee.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.CommonUtils;
import com.kh.lgtw.common.Pagination;
import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.service.EmployeeService;
import com.kh.lgtw.employee.model.vo.DeptVo;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.EmployeeResult;
import com.kh.lgtw.employee.model.vo.ExcelEmp;
import com.kh.lgtw.employee.model.vo.JobVo;
import com.kh.lgtw.employee.model.util.EmpExcelSample;
import com.kh.lgtw.employee.model.util.ExcelFileType;

@SessionAttributes("loginEmp")
@Controller
public class EmployeeController {
	
	@Autowired private EmployeeService empService;
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	//화면전환
	
	// empService getter
	public EmployeeService getEmpService() {
		return empService;
	}

	//로그인
	@RequestMapping(value="login.em", method=RequestMethod.POST)
	public String loginCheck(Employee employee, Model model) {
		
		try {
			Employee loginEmp = empService.loginCheck(employee);
			
			model.addAttribute("loginEmp", loginEmp);
			return "main/main";
			
		} catch (LoginException e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	// 로그아웃
	@RequestMapping(value="logout.em")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:index.jsp";
	}
	
	//조직도
	@RequestMapping("employee.em")
	public String employeeHome(Model model) {
		
		ArrayList<DeptVo> list;
		
		list = empService.selectDeptList();
		
		for(int i =0; i<list.size(); i++) {
			System.out.println("리스트 출력 : " + list.get(i));
		}
		
		model.addAttribute("list", list);
		
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
	
	//직원관리
	@RequestMapping("showEmployeeAdmin.em")
	public String showEmployeeAdmin(Model model, HttpServletRequest request) {
		
		
		int currentPage = 1;
		
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int listCount = empService.getEmpListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<EmployeeResult> list = empService.selectEmpListAdmin(pi);
		HashMap<String, Object> hmap = empService.selectJopDeptAdmin();
		
		
		System.out.println(hmap.get("deptList"));
		System.out.println(hmap.get("jobList"));
		
		model.addAttribute("pi",pi);
		model.addAttribute("hmap",hmap);
		model.addAttribute("list", list);
		
		
		return "employee/employeeAdmin";
	}
	
	//직원 빠르게 등록
	@RequestMapping("insertEmpQuick.em")
	public String insertEmpQuick(Employee employee, DeptVo dpVo, JobVo jobVo, Model model) {
		
		System.out.println("퀵등록 emp:" + employee);
		System.out.println("부서:" + dpVo.getDeptCode());
		System.out.println("직급:" +jobVo.getJobCode());
		
		employee.setEmpPwd(passwordEncoder.encode(employee.getEmpPwd()));
		
		int result = empService.insertEmpQuick(employee, dpVo, jobVo);
		
		if(result>0) {
			return "redirect:showEmployeeAdmin.em";
		}else {
			return "employee/empOneRegister";
		}
		
		
	}
	
	
	//직원일괄등록
	@RequestMapping("showEmpClctvRegister.em")
	public String showEmpClctvRegister() {
		return "employee/empClctvRegister";
	}
	
	//직원 상세 등록
	@RequestMapping("showEmpOneRegister.em")
	public String showEmpOneRegister() {
		return "employee/empOneRegister";
	}
	
	//직원 일괄 수정
	@RequestMapping("showUpdateEmpClctv.em")
	public String showUpdateEmpClctv() {
		return "employee/updateEmpClctv";
	}
	
	//직급,팀장 추가
	@RequestMapping("showlevelCaptain.em")
	public String showlevelCaptain() {
		return "employee/levelCaptainAdmin";
	
	//인사관리자
	}
	@RequestMapping("showPrsnlManager.em")
	public String showPrsnlManager() {
		return "employee/prsnlManagerAdmin";
	}
	
	//휴가관리
	@RequestMapping("showHolidayTotal.em")
	public String showHolidayTotal() {
		return "employee/holidayTotalAdmin";
	}
	
	//근태관리
	@RequestMapping("showAttendTotal.em")
	public String showAttendTotal() {
		return "employee/attendTotalAdmin";
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
	public String insertEmployee(Employee employee, String zipCode, String address1, String address2, Model model, HttpServletRequest request, @RequestParam(name="profile",required=false) MultipartFile profile){
//		System.out.println("주소:" +address1+address2+zipCode);
		
		String address = address1 + "|" + address2 + "|" +zipCode;
		
		employee.setAddress(address);
		
		if(profile != null) {
			try {
				String root =request.getSession().getServletContext().getRealPath("resources");
				
				String filePath = root +"\\images\\profile";
				
				System.out.println(filePath);
				
				String originFileName = profile.getOriginalFilename();
				String ext = originFileName.substring(originFileName.lastIndexOf("."));
				String changeName = CommonUtils.getRandomString();
				profile.transferTo(new File(filePath+"\\"+changeName+ext));
				
				employee.setEmpPwd(passwordEncoder.encode(employee.getEmpPwd()));
				
				Attachment attach = new Attachment();
				attach.setOriginName(originFileName);
				attach.setChangeName(changeName);
				attach.setFilePath(filePath);
				
				
				int result = empService.insertEmpOne(employee, attach);
				
				if(result > 0) {
					return "redirect:showEmpOneRegister.em";
				}else {
					return "employee/empOneRegister";
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				return "employee/empOneRegister";
			}
		}else {
			return "";
			
		}
		
		
		
		
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
	
	@RequestMapping("empExcelUpload.em")
	public ModelAndView empExcelUpload(MultipartHttpServletRequest request) {
		System.out.println("업로드 진행");
		
		MultipartFile excelFile = request.getFile("excelFile");
		
		if(excelFile == null || excelFile.isEmpty()) {
			throw new RuntimeException("엑셀파일을 선택해주세요");
		}
		
		String filePath = excelFile.getOriginalFilename();
		
		List<ExcelEmp> list = new ArrayList<>();
		
		if(filePath.toUpperCase().endsWith(".XLS")) {
			
			list = empService.xlsEmpInsert(request, excelFile);
		
		}else if(filePath.toUpperCase().endsWith(".XLSX")) {
			list = empService.xlsxEmpInsert(request, excelFile);
		}
		
		System.out.println("파일패스:" + filePath);
		
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("redirect:showEmpClctvRegister.em");
		
		return view;
	}
	
	@RequestMapping("deleteEmpList.em")
	public String deleteEmpList(HttpServletRequest request, Model model) {
		
		String srr[] = request.getParameterValues("empNo");
		
		int[] emprr = new int[srr.length];
		int result = 0;
		
		for(int i = 0; i<srr.length; i++) {
			emprr[i]=Integer.parseInt(srr[i]);
			result = empService.deleteEmpList(emprr[i]);
		}
		
		return "redirect:showEmployeeAdmin.em";
	}
	
	@RequestMapping("empSample.em")
	public void empSample(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
			
			Workbook wb = new HSSFWorkbook();
			
			Sheet sheet1 = wb.createSheet("sampleEmp");
			
			sheet1.setColumnWidth(0, 5000);
			sheet1.setColumnWidth(1, 5000);
			sheet1.setColumnWidth(2, 5000);
			sheet1.setColumnWidth(3, 5000);
			sheet1.setColumnWidth(4, 5000);
			sheet1.setColumnWidth(5, 5000);
			
			
			Row row = null;
			Cell cell = null;
			
			row = sheet1.createRow(0);
			
			cell = row.createCell(0);
			cell.setCellValue("아이디");
			cell = row.createCell(1);
			cell.setCellValue("비밀번호");
			cell = row.createCell(2);
			cell.setCellValue("이름");
			cell = row.createCell(3);
			cell.setCellValue("전화번호");
			cell = row.createCell(4);
			cell.setCellValue("상태");
			cell = row.createCell(5);
			cell.setCellValue("입사일");
			
			row = sheet1.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("kh0101");
			cell = row.createCell(1);
			cell.setCellValue("1234");
			cell = row.createCell(2);
			cell.setCellValue("홍길동");
			cell = row.createCell(3);
			cell.setCellValue("010-1234-1234");
			cell = row.createCell(4);
			cell.setCellValue("Y");
			cell = row.createCell(5);
			cell.setCellValue("2019-01-01");
			
			row = sheet1.createRow(2);
			cell = row.createCell(0);
			cell.setCellValue("kh1223");
			cell = row.createCell(1);
			cell.setCellValue("5678");
			cell = row.createCell(2);
			cell.setCellValue("세종대왕");
			cell = row.createCell(3);
			cell.setCellValue("010-5959-7979");
			cell = row.createCell(4);
			cell.setCellValue("Y");
			cell = row.createCell(5);
			cell.setCellValue("2019-01-02");
			
			System.out.println("엑셀생성");
			response.setHeader("Content-Type","text/html; charset=utf-8");
			response.setContentType("ms-vnd/excel");
			System.out.println("1확인");
			response.setHeader("Content-Disposition","attachment;filename=Empsample.xls");
			System.out.println("2확인");
			
			try {
				wb.write(response.getOutputStream());
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("3확인");
		
	}
	
}






















