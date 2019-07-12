package com.kh.lgtw.employee.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
			return "redirect:index.jsp";
			
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
	
	// ------------------------직원--------------------------
	//직원목록페이지
		@RequestMapping("showEmployeeList.em")
		public String showEmployeeList(Model model, HttpServletRequest request) {
			
			int currentPage = 1;
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			int listCount = empService.getEmpListCount();
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<EmployeeResult> list = empService.selectEmpList(pi);
			ArrayList<Attachment> attach = empService.selectAttachList();
			HashMap<String, Object> hmap = empService.selectJopDeptAdmin();
			
			model.addAttribute("hmap", hmap);
			model.addAttribute("empList",list);
			model.addAttribute("attachList", attach);
			model.addAttribute("pi",pi);
			
			
			return "employee/employeeList";
		}
		
		//내 정보 페이지
		@RequestMapping("showMyPage.em")
		public String showEmpPage(Model model, HttpSession session) {
			
			Employee employee = (Employee)session.getAttribute("loginEmp");
			
			
			HashMap<String, Object> deptJob = empService.selectEmpDeptJob(employee);
			HashMap<String, Object> hmap = empService.selectJopDeptAdmin();
			
			Attachment attach = new Attachment();
			
			attach = empService.selectProfile(employee);
			
			if(employee.getAddress() != null) {
				String[] addArr = employee.getAddress().split("\\|");
				
				for(int i=0; i<addArr.length; i++) {
					System.out.println(addArr[i]);
				}
				
				model.addAttribute("address",addArr);
			}else {
				employee.setAddress("");
			}
			
			model.addAttribute("hmap", hmap);
			model.addAttribute("deptJob",deptJob);
			model.addAttribute("attach",attach);
			
			
			return "employee/myEmpPage";
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
		public String insertEmpQuick(Employee employee, DeptVo dpVo, JobVo jobVo, Model model, HttpServletRequest request) {
			
			System.out.println("퀵등록 emp:" + employee);
			System.out.println("부서:" + dpVo.getDeptCode());
			System.out.println("직급:" +jobVo.getJobCode());
			
			
			Attachment attach = new Attachment();
			
			String root =request.getSession().getServletContext().getRealPath("resources");
			String imgfilePath = root+"\\images\\profile";
			String origin = "users.jpg";
			String change = CommonUtils.getRandomString();
			
			attach.setFilePath(imgfilePath);
			attach.setOriginName(origin);
			attach.setChangeName(change);
			
			
			employee.setEmpPwd(passwordEncoder.encode(employee.getEmpPwd()));
			
			int result = empService.insertEmpQuick(employee, dpVo, jobVo,attach);
			
			if(result>0) {
				return "redirect:showEmployeeAdmin.em";
			}else {
				return "employee/empOneRegister";
			}
		}
		
		//직원일괄등록 페이지 전환
		@RequestMapping("showEmpClctvRegister.em")
		public String showEmpClctvRegister() {
			return "employee/empClctvRegister";
		}
		
		//직원 상세 등록 페이지
		@RequestMapping("showEmpOneRegister.em")
		public String showEmpOneRegister(Model model) {
			
			HashMap<String, Object> hmap = empService.selectJopDeptAdmin();
			
			model.addAttribute("hmap", hmap);
			
			
			return "employee/empOneRegister";
		}
		
		//직원 일괄 수정
		@RequestMapping("showUpdateEmpClctv.em")
		public String showUpdateEmpClctv() {
			return "employee/updateEmpClctv";
		}
		
		//직급,팀장 추가
		@RequestMapping("showlevelCaptain.em")
		public String showlevelCaptain(Model model) {
			
			HashMap<String, Object> hmap = empService.selectLevelCaptain();
			ArrayList<EmployeeResult> empList = empService.allEmpList();
			
			model.addAttribute("hmap", hmap);
			model.addAttribute("empList",empList);
			
			return "employee/levelCaptainAdmin";
		
		//인사관리자
		}
		@RequestMapping("showPrsnlManager.em")
		public String showPrsnlManager(Model model) {
			
			ArrayList<EmployeeResult> empPrnl = empService.selectPrnlEmp();
			
			model.addAttribute("empPrnl", empPrnl);
			
			return "employee/prsnlManagerAdmin";
		}
		
		//사원 검색
		@RequestMapping("searchEmpUser.em")
		public String searchEmployee(EmployeeResult employee, Model model, HttpServletRequest request) {
			System.out.println("검색 출력 :" + employee);
			System.out.println("부서"+employee.getDeptName());
			System.out.println("직급"+employee.getJobName());
			System.out.println("이름"+employee.getEmpName().equals(""));
			
			if(employee.getEmpName().equals("")) {
				employee.setEmpName(null);
			}
			
			System.out.println("이름 호출 두번째 : " + employee.getEmpName());
			
			
			int currentPage = 1;
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int listCount = empService.getSearchEmpCount(employee);
			
			if(listCount == 0) {
				
				model.addAttribute("msg","조건에 맞는 직원이 없습니다.");
				model.addAttribute("url","showEmployeeList.em");
				
				return "employee/checkPwd";
			}
			
			System.out.println("리스트 카운트" + listCount);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<EmployeeResult> empList = empService.searchEmpUser(pi, employee);
			
			ArrayList<Attachment> attach = empService.selectAttachList();
			HashMap<String, Object> hmap = empService.selectJopDeptAdmin();
			
			model.addAttribute("hmap", hmap);
			model.addAttribute("empList",empList);
			model.addAttribute("attachList", attach);
			model.addAttribute("pi",pi);
			
			
			return "employee/employeeList";
		}
		
		//사원 한명 추가 
		@RequestMapping("insertOneEmpl.em")
		public String insertEmployee(Employee employee, DeptVo dpVo, JobVo jobVo, String zipCode, String address1, String address2, Model model, HttpServletRequest request, 
									@RequestParam(name="profile",required=false) MultipartFile profile){
//			System.out.println("주소:" +address1+address2+zipCode);
			
			String address = address1 + "|" + address2 + "|" +zipCode;
			employee.setAddress(address);
			employee.setEmpPwd(passwordEncoder.encode(employee.getEmpPwd()));
			
			String type = profile.getOriginalFilename();
			
			System.out.println(profile);
			System.out.println("없을때 이름"+profile.getOriginalFilename());
			
			if(!type.equals("")) {
				try {
					String root =request.getSession().getServletContext().getRealPath("resources");
					
					System.out.println("루트확인:"+root);
					
					String filePath = root +"\\images\\profile";
					
					System.out.println(filePath);
					
					String originFileName = profile.getOriginalFilename();
					String ext = originFileName.substring(originFileName.lastIndexOf("."));
					String changeName = CommonUtils.getRandomString()+ext;
					profile.transferTo(new File(filePath+"\\"+changeName+ext));
					
					Attachment attach = new Attachment();
					attach.setOriginName(originFileName);
					attach.setChangeName(changeName);
					attach.setFilePath(filePath);
					
					
					int result = empService.insertEmpOne(employee, attach, dpVo, jobVo);
					
					if(result > 0) {
						return "redirect:showEmployeeAdmin.em";
					}else {
						return "employee/empOneRegister";
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
					return "employee/empOneRegister";
				}
			}else {
				
				//프로필 생성용 attachment
				Attachment attach = new Attachment();
				
				String root =request.getSession().getServletContext().getRealPath("resources");
				String imgfilePath = root+"\\images\\profile";
				String origin = "users.jpg";
				String change = CommonUtils.getRandomString();
				
				attach.setFilePath(imgfilePath);
				attach.setOriginName(origin);
				attach.setChangeName(change);
				
				
				int result = empService.insertEmpOne(employee, attach, dpVo, jobVo);
				
				if(result > 0) {
					return "redirect:showEmployeeAdmin.em";
				}else {
					return "employee/empOneRegister";
				}
				
			}
		}
		
		//내 정보 수정
		@RequestMapping("updateMyInfo.em")
		public String updateMyInfo(Model model, HttpSession session, EmployeeResult employee, String zipCode, String address1, String address2,HttpServletRequest request,
								String updatePwd1, String updatePwd2, @RequestParam(name="profile",required=false) MultipartFile profile, HttpServletResponse response) {
			
			Employee loginEmp =(Employee)session.getAttribute("loginEmp");
			
			System.out.println("입사일 : " + employee.getEnrollDate());
			System.out.println("생일 : " + employee.getEmpBirth());
			
			if(address1 != null) {
				String address = address1 + "|" + address2 + "|" +zipCode;
				employee.setAddress(address);
			}
			System.out.println("employee확인 "+employee);
			
			if(employee.getEmpPwd().equals("")) {
				model.addAttribute("msg","현재 비밀번호를 입력해주세요.");
				model.addAttribute("url","showMyPage.em");
				return "employee/checkPwd";
			}
			
			
			int pwdCheck = empService.updatePwdCheck(employee);
			
			
			if(pwdCheck>0) {
				if(updatePwd1.equals(updatePwd2)) {
					
					if(profile.getOriginalFilename().equals("")) {
						model.addAttribute("msg","프로필 사진을 등록하세요.");
						model.addAttribute("url","showMyPage.em");
						return "employee/checkPwd";
					}
					
					try {
						String root =request.getSession().getServletContext().getRealPath("resources");
						
						System.out.println("루트확인:"+root);
						
						String filePath = root +"\\images\\profile";
						
						System.out.println(filePath);
						
						String originFileName = profile.getOriginalFilename();
						String ext = originFileName.substring(originFileName.lastIndexOf("."));
						String changeName = CommonUtils.getRandomString()+ext;
						profile.transferTo(new File(filePath+"\\"+changeName+ext));
						Attachment attach = new Attachment();
						attach.setOriginName(originFileName);
						attach.setChangeName(changeName);
						attach.setFilePath(filePath);
						attach.setEmpNo(employee.getEmpNo());
						
						
						if(updatePwd1 != null && updatePwd2 != null) {
							employee.setEmpPwd(passwordEncoder.encode(updatePwd1));
						}
						//System.out.println(employee.getEmpPwd());
						
						int updateEmp = empService.updateEmpOne(employee, attach);
						
						if(updateEmp>0) {
							
							model.addAttribute("msg","회원정보가 수정되었습니다. 다시 로그인 하세요");
							model.addAttribute("url","logout.em");
							
							return "employee/checkPwd";
						}
						
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					//int updateEmp = empService.updateEmpInfo(employee);
					
					
				}else {
					model.addAttribute("msg","변경할 비밀번호가 일치하지 않습니다.");
					model.addAttribute("url","showMyPage.em");
					
					return "employee/checkPwd";
				}
				
			}else {
				model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
				model.addAttribute("url","showMyPage.em");
				
				return "employee/checkPwd";
			}
			
			return "redirect:showMyPage.em";
		}
		
		//직원 삭제
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
		
		//인사관리자 추가
		@RequestMapping(value="/employee/insertPrsnlManager", produces="application/text; charset=utf8")
		@ResponseBody
		public String insertPrsnlManaer(@RequestBody Map<String, Object> map) {
			
			System.out.println(map.get("empArr").getClass());
			
			ArrayList<Object> empList = (ArrayList)map.get("empArr");
			
			int result = empService.insertPrsnlManager(empList);
			
			return result+"";
		}
		
		@RequestMapping(value="/employee/deletePrsnlManager", produces="application/text; charset=utf8")
		@ResponseBody
		public String deletePrsnlManager(@RequestBody Map<String, Object> map) {
			
			System.out.println(map.get("empArr"));
			
			ArrayList<Object> empList = (ArrayList)map.get("empArr");
			
			int result = empService.deletePrsnlManager(empList);
			
			System.out.println("삭제인원"+result);
			
			return result+"";
		}
		
		@RequestMapping(value="/employee/goToWork",produces="application/text; charset=utf8")
		@ResponseBody
		public String goToWork(@RequestBody Map<String, Object> map) throws ParseException {
			System.out.println("넘어가니~"+map.get("workArr"));
			ArrayList<Object> info = (ArrayList)map.get("workArr");
			String status = null;
			
			int empNo = Integer.parseInt(info.get(0).toString());
			String workTime = info.get(1).toString();
			long nowTime = Long.parseLong(info.get(2).toString());
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss",Locale.KOREA);
			
			Date d1 = sdf.parse("09:00:00");
			Date d2 = sdf.parse("18:00:00");
			
			System.out.println("출근시간"+d1);
			System.out.println("퇴근시간"+d2);
			
			System.out.println(nowTime);
			
			
			
		/* int[] lateCheck= */
			
			
			System.out.println(empNo+5);
			System.out.println("우어크 타임:"+workTime);
			
			//int checkWork = empService.checkEmpWork(empNo);
			
//			if(checkWork==0) {
//				//int work = empService.insertEmpWork(empNo,workTime);
//			}else {
//				status="출근은 아까 찍었습니다";
//			}
			
			
			
			return status;
		}
		
		
		
	// ------------------------조직도--------------------------
	
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
		
		//조직도등록
		@RequestMapping("insertDept.em")
		public String insertDept(Model model) {
			return "";
		}
		
	
	
	//------------------------휴가 ---------------------------------------

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
		
		//휴가관리
			@RequestMapping("showHolidayTotal.em")
			public String showHolidayTotal() {
				return "employee/holidayTotalAdmin";
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
	
	//-------------------------------근태 --------------------------------
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
		
		
		//근태관리
		@RequestMapping("showAttendTotal.em")
		public String showAttendTotal() {
			return "employee/attendTotalAdmin";
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
		
		//근태수정
		@RequestMapping("updateAttend.em")
		public String updateAttend(Employee employee, Model model) {
			return "";
		}
		
		
		@RequestMapping("showLeaveEmpAdmin.em")
		public String showLeaveEmpAdmin() {
			
			
			return "employee/leaveEmpAdmin";
		}
	
	// --------------------엑셀 파트-----------------
	//엑셀 직원 업로드
		@RequestMapping("empExcelUpload.em")
		public ModelAndView empExcelUpload(MultipartHttpServletRequest request) {
			System.out.println("업로드 진행");
			
			//엑셀로 등록시 프로필 생성용 attachment
			Attachment attach = new Attachment();
			
			String root =request.getSession().getServletContext().getRealPath("resources");
			String imgfilePath = root+"\\images\\profile";
			String origin = "users.jpg";
			String change = CommonUtils.getRandomString();
			
			attach.setFilePath(imgfilePath);
			attach.setOriginName(origin);
			attach.setChangeName(change);
			
			
			System.out.println("루트 확인"+root);
			
			MultipartFile excelFile = request.getFile("excelFile");
			String filePath = excelFile.getOriginalFilename();
			
			System.out.println("파일 패스 확인"+filePath);
			
			List<ExcelEmp> list = new ArrayList<>();
			
			if(filePath.toUpperCase().endsWith(".XLS")) {
				
				list = empService.xlsEmpInsert(request, excelFile);
			
			}else if(filePath.toUpperCase().endsWith(".XLSX")) {
				list = empService.xlsxEmpInsert(request, excelFile, attach);
			}
			
			System.out.println("파일패스:" + filePath);
			
			
			ModelAndView view = new ModelAndView();
			
			
			view.setViewName("redirect:showEmpClctvRegister.em");
			
			return view;
		}
	
	
	
	//DB에 있는 직원 다운로드
		@RequestMapping("dbEmpList.em")
		public void dbEmpList(Model model, HttpServletRequest request, HttpServletResponse response) {
			empService.dbEmpList(response);
		}
		
		//직원 일괄 수정
		@RequestMapping("empUpdateExcelUpload.em")
		public ModelAndView empUpdateExcelUpload(MultipartHttpServletRequest request) {
			MultipartFile excelFile = request.getFile("excelFile");
			
			String filePath = excelFile.getOriginalFilename();
			
			List<EmployeeResult> list = new ArrayList<>();
			
			if(filePath.toUpperCase().endsWith(".XLS")) {
				
				list = empService.xlsEmpUpdate(request, excelFile);
			
			}else if(filePath.toUpperCase().endsWith(".XLSX")) {
				list = empService.xlsxEmpUpdate(request, excelFile);
			}
			
			
			ModelAndView view = new ModelAndView();
			
			view.setViewName("redirect:showUpdateEmpClctv.em");
			
			return view;
			
		}
		
		//샘플 엑셀 다운로드
		@RequestMapping("empSample.em")
		public void empSample(Model model, HttpServletRequest request, HttpServletResponse response) {
				
				Workbook wb = new XSSFWorkbook();
				
				Sheet sheet1 = wb.createSheet("sampleEmp");
				
				sheet1.setColumnWidth(0, 5000);
				sheet1.setColumnWidth(1, 5000);
				sheet1.setColumnWidth(2, 5000);
				sheet1.setColumnWidth(3, 5000);
				sheet1.setColumnWidth(4, 5000);
				sheet1.setColumnWidth(5, 5000);
				sheet1.setColumnWidth(6, 5000);
				sheet1.setColumnWidth(7, 5000);
				sheet1.setColumnWidth(8, 5000);
				sheet1.setColumnWidth(9, 5000);
				sheet1.setColumnWidth(10, 5000);
				sheet1.setColumnWidth(11, 5000);
				
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
				cell.setCellValue("이메일");
				cell = row.createCell(4);
				cell.setCellValue("전화번호");
				cell = row.createCell(5);
				cell.setCellValue("입사일");
				cell = row.createCell(6);
				cell.setCellValue("생년월일(ex:1991-03-02)");
				cell = row.createCell(7);
				cell.setCellValue("성별(남자:F/여자:M)");
				cell = row.createCell(8);
				cell.setCellValue("기타정보");
				cell = row.createCell(9);
				cell.setCellValue("부서");
				cell = row.createCell(10);
				cell.setCellValue("직급");
				cell = row.createCell(11);
				cell.setCellValue("상태(Y:근무중/H:휴직)");
				
				row = sheet1.createRow(1);
				
				cell = row.createCell(0);
				cell.setCellValue("kh0101");
				cell = row.createCell(1);
				cell.setCellValue("1234");
				cell = row.createCell(2);
				cell.setCellValue("홍길동");
				cell = row.createCell(3);
				cell.setCellValue("hong@lgtw.ga");
				cell = row.createCell(4);
				cell.setCellValue("010-1234-1234");
				cell = row.createCell(5);
				cell.setCellValue("2019-01-01");
				cell = row.createCell(6);
				cell.setCellValue("1991-03-02");
				cell = row.createCell(7);
				cell.setCellValue("남자");
				cell = row.createCell(8);
				cell.setCellValue("신입사원임 잘해주시길");
				cell = row.createCell(9);
				cell.setCellValue("영업1팀");
				cell = row.createCell(10);
				cell.setCellValue("사원");
				cell = row.createCell(11);
				cell.setCellValue("Y");
				
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
				response.setHeader("Content-Disposition","attachment;filename=Empsample.xlsx");
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






















