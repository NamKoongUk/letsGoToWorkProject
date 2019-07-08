package com.kh.lgtw.employee.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.dao.EmployeeDao;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.DeptHistory;
import com.kh.lgtw.employee.model.vo.DeptVo;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.EmployeeResult;
import com.kh.lgtw.employee.model.vo.ExcelEmp;
import com.kh.lgtw.employee.model.vo.JobVo;
import com.kh.lgtw.employee.model.vo.PromotionHistory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired SqlSession sqlSession; 
	@Autowired private EmployeeDao empDao;
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	
	// 로그인 확인용
	@Override
	public Employee loginCheck(Employee employee) throws LoginException {
		Employee loginEmp = null;
		
		String encPassword = empDao.selectEncPassword(sqlSession, employee);
		
		System.out.println("비밀번호 : " + encPassword);
		System.out.println("암호 2 : " + employee.getEmpPwd());	
		String pass =  passwordEncoder.encode(employee.getEmpPwd());
		System.out.println(pass);
		
		if(passwordEncoder.matches(employee.getEmpPwd(), encPassword)) {
			loginEmp = empDao.loginCheck(sqlSession, employee);
		}else {
			throw new LoginException("로그인실패!");
		}
		
		return loginEmp;
	}
	
//	@Override
//	public Member loginMember(Member m) throws LoginException {
//		Member loginUser = null;
//		
//		String encPassword = md.selectEncPassword(sqlSession, m);
//		
//		
//		if(!passwordEncoder.matches(m.getUserPwd(), encPassword)) {
//			throw new LoginException("로그인실패!");
//		}else {
//			loginUser = md.selectMember(sqlSession, m);
//		}
//		
//		return loginUser;
//	}

	@Override
	public int insertEmpOne(Employee employee, Attachment attach, DeptVo dpVo, JobVo jobVo) {
		
		int result = 0;
		
		 int empInsert = empDao.inSertEmpOne(sqlSession, employee);
		
		 if(empInsert > 0) {
			 int deptHistory = empDao.insertDeptHistory(sqlSession, dpVo, jobVo);
			 int empPro = empDao.insertEmpProfile(sqlSession, attach);
		 }
		
		return result;
	}

	@Override
	public int empExcelUpload(File destFile) {
		return empDao.empExcelUpload(sqlSession, destFile);
	}

	@Override
	public List<ExcelEmp> xlsEmpInsert(MultipartHttpServletRequest request, MultipartFile excelFile) {
		System.out.println("엑셀 XLS");
		return null;
	}
	
	//Emp 엑셀 insert
	@Override
	public List<ExcelEmp> xlsxEmpInsert(MultipartHttpServletRequest request, MultipartFile excelFile, Attachment attach) {
		
		System.out.println("엑셀 XLSX");
		
		List<ExcelEmp> list = new ArrayList<>();
		
		MultipartFile file = request.getFile("excelFile");
		
		XSSFWorkbook workbook = null;
		
		try {
			
			workbook = new XSSFWorkbook(file.getInputStream());
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			ExcelEmp excelEmp;
			
			String filePath = "스트링"+file.getOriginalFilename();
			
			System.out.println("서비스 엑셀파일 확인" + filePath);
			
		for(int sheetIndex = 0; sheetIndex<workbook.getNumberOfSheets(); sheetIndex++) {
			System.out.println("시트 확인"+workbook.getNumberOfSheets());
			System.out.println(sheetIndex);
			System.out.println(workbook.getNumberOfSheets());
			
			curSheet =workbook.getSheetAt(sheetIndex);
			
			for(int rowIndex = 0; rowIndex<curSheet.getPhysicalNumberOfRows(); rowIndex++) {
				System.out.println("로우 확인"+curSheet.getPhysicalNumberOfRows());
				if(rowIndex!=0) {
					curRow=curSheet.getRow(rowIndex);
					
					excelEmp = new ExcelEmp();
					
					String value;
					
					if(curRow.getCell(0)!=null) {
						for(int cellIndex=0; cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
							curCell = curRow.getCell(cellIndex);
							
							System.out.println("셀타입 확인:"+curCell.getCellType());
							
							if(true) {
								value="";
								
								switch (curCell.getCellType()) {
								case FORMULA: value = curCell.getCellFormula(); break;
								case NUMERIC:
									if (HSSFDateUtil.isCellDateFormatted(curCell)){ 
										SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
									value= formatter.format(curCell.getDateCellValue());  break;
									}else{
									 value = curCell.getNumericCellValue() + "";
									 break;
									}
								case STRING: value = curCell.getStringCellValue() + ""; break;
								case BLANK: value = curCell.getBooleanCellValue() + ""; break;
								case ERROR: value = curCell.getErrorCellValue() + ""; break;
								default: value = new String(); break;
								} // end switch
								
								switch(cellIndex) {
								case 0 : excelEmp.setEmpId(value); break;
								case 1 : excelEmp.setEmpPwd(passwordEncoder.encode(value)); break;
								case 2 : excelEmp.setEmpName(value); break;
								case 3 : excelEmp.setEmpPhone(value); break;
								case 4 : excelEmp.setStatus(value); break;
								case 5 : excelEmp.setEnrollDate(Date.valueOf(value));break;
								default: break;
								}
							}
						}
						
						list.add(excelEmp);
					}
				}
			}
			
		}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<ExcelEmp> daoList = new ArrayList<>();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println("서비스 리스트 확인 : " +list.get(i).getEmpName());
			
		}
		
		daoList = empDao.excelEmpInsert(sqlSession, list, attach);
		
		return daoList;
	}

	// 이름으로 사원 이메일 찾기 
	@Override
	public List<String> selectEmpEamilForName(String sName) {
		return empDao.selectEmpEmailForName(sqlSession, sName);
	}
  
	@Override
	public ArrayList<DeptVo> selectDeptList() {
		return empDao.selectDeptList(sqlSession);
	}

	@Override
	public int insertEmpQuick(Employee employee, DeptVo dpVo, JobVo jobVo, Attachment attach) {
		int result=0;
		
		int empNum = empDao.insertEmpQuick(sqlSession, employee);
		
		if(empNum>0) {
			int deptHistory = empDao.insertDeptHistory(sqlSession, dpVo, jobVo);
			int profile = empDao.insertEmpProfile(sqlSession, attach);
			
			result=1;
		}
		
		return result;
	}

	@Override
	public ArrayList<EmployeeResult> selectEmpListAdmin(PageInfo pi) {
		return empDao.selectEmpListAdmin(sqlSession,pi);
	}

	@Override
	public HashMap<String, Object> selectJopDeptAdmin() {
		
		HashMap<String, Object> hmap = null;
		
		ArrayList<DeptVo> deptList = empDao.selectDeptList(sqlSession);
		ArrayList<JobVo> jobList = empDao.selectJobAdmin(sqlSession);
		
		hmap = new HashMap<String, Object>();
		hmap.put("deptList", deptList);
		hmap.put("jobList", jobList);
		
		return hmap;
	}

	@Override
	public int getEmpListCount() {
		return empDao.getEmpListCount(sqlSession);
	}

	@Override
	public int deleteEmpList(int empNo) {
		return empDao.deleteEmpList(sqlSession,empNo);
	}

	@Override
	public int insertEmpOneNoAttach(Employee employee, DeptVo dpVo, JobVo jobVo) {
		int empNum = empDao.inSertEmpOne(sqlSession, employee);
		int result = 0;
		
		if(empNum>0) {
			int deptHistory = empDao.insertDeptHistory(sqlSession, dpVo, jobVo);
			result=1;
		}
		
		
		return result;
	}

	@Override
	public void dbEmpList(HttpServletResponse response) {
		ArrayList<EmployeeResult> list = empDao.dbEmpList(sqlSession);
		
		SXSSFWorkbook wb = new SXSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		sheet.setColumnWidth(0, 3000);
		sheet.setColumnWidth(1, 5000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 7000);
		sheet.setColumnWidth(6, 7000);
		sheet.setColumnWidth(7, 3000);
		
		Row row = null;
		Cell cell = null;
		
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("사번");
		cell = row.createCell(1);
		cell.setCellValue("아이디");
		cell = row.createCell(2);
		cell.setCellValue("직원 이름");
		cell = row.createCell(3);
		cell.setCellValue("부서");
		cell = row.createCell(4);
		cell.setCellValue("직급");
		cell = row.createCell(5);
		cell.setCellValue("내선번호");
		cell = row.createCell(6);
		cell.setCellValue("휴대전화");
		cell = row.createCell(7);
		cell.setCellValue("상태(근무:Y/휴직:H/퇴사:N)");
		
		for(int i = 0; i<list.size(); i++) {
			row = sheet.createRow(i+1);
				cell = row.createCell(0);
				cell.setCellValue(list.get(i).getEmpNo());
				cell = row.createCell(1);
				cell.setCellValue(list.get(i).getEmpId());
				cell = row.createCell(2);
				cell.setCellValue(list.get(i).getEmpName());
				cell = row.createCell(3);
				cell.setCellValue(list.get(i).getDeptName());
				cell = row.createCell(4);
				cell.setCellValue(list.get(i).getJobName());
				cell = row.createCell(5);
				cell.setCellValue(list.get(i).getOfficeTel());
				cell = row.createCell(6);
				cell.setCellValue(list.get(i).getEmpPhone());
				cell = row.createCell(7);
				cell.setCellValue(list.get(i).getStatus());
		}
		
		try {
			response.setHeader("Set-Cookie", "fileDownload=true; path=/");
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"dataEmp.xlsx\""));
			wb.write(response.getOutputStream());
			wb.dispose();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<EmployeeResult> xlsEmpUpdate(MultipartHttpServletRequest request, MultipartFile excelFile) {
		return null;
	}

	@Override
	public List<EmployeeResult> xlsxEmpUpdate(MultipartHttpServletRequest request, MultipartFile excelFile) {
		//System.out.println("엑셀 XLSX");
		
		List<EmployeeResult> list = new ArrayList<>();
		
		MultipartFile file = request.getFile("excelFile");
		
		XSSFWorkbook workbook = null;
		
		try {
			
			workbook = new XSSFWorkbook(file.getInputStream());
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			EmployeeResult employeeResult;
			
			String filePath = "스트링"+file.getOriginalFilename();
			
			//System.out.println("서비스 엑셀파일 확인" + filePath);
			
		for(int sheetIndex = 0; sheetIndex<workbook.getNumberOfSheets(); sheetIndex++) {
			//System.out.println("시트 확인"+workbook.getNumberOfSheets());
			//System.out.println(sheetIndex);
			//System.out.println(workbook.getNumberOfSheets());
			
			curSheet =workbook.getSheetAt(sheetIndex);
			
			for(int rowIndex = 0; rowIndex<curSheet.getPhysicalNumberOfRows(); rowIndex++) {
				//System.out.println("로우 확인"+curSheet.getPhysicalNumberOfRows());
				if(rowIndex!=0) {
					curRow=curSheet.getRow(rowIndex);
					
					employeeResult = new EmployeeResult();
					
					String value;
					
					if(curRow.getCell(0)!=null) {
						for(int cellIndex=0; cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
							curCell = curRow.getCell(cellIndex);
							
							//System.out.println("셀타입 확인:"+curCell.getCellType());
							
							if(true) {
								value="";
								
								switch (curCell.getCellType()) {
								case FORMULA: value = curCell.getCellFormula(); break;
								case NUMERIC:
									if (HSSFDateUtil.isCellDateFormatted(curCell)){ 
										SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
									value= formatter.format(curCell.getDateCellValue());  break;
									}else{
									 value = (int)curCell.getNumericCellValue() + "";
									 break;
									}
								case STRING: value = curCell.getStringCellValue() + ""; break;
								case BLANK: value = curCell.getBooleanCellValue() + ""; break;
								case ERROR: value = curCell.getErrorCellValue() + ""; break;
								default: value = new String(); break;
								} // end switch
								
								switch(cellIndex) {
								case 0 : employeeResult.setEmpNo(Integer.valueOf(value)); break;
								case 1 : employeeResult.setEmpId(value); break;
								case 2 : employeeResult.setEmpName(value); break;
								case 3 : employeeResult.setDeptName(value); break;
								case 4 : employeeResult.setJobName(value); break;
								case 5 : employeeResult.setOfficeTel(value); break;
								case 6 : employeeResult.setEmpPhone(value); break;
								case 7 : employeeResult.setStatus(value); break;
								default: break;
								}
							}
						}
						
						list.add(employeeResult);
						
					}
				}
			}
			
		}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<EmployeeResult> daoList = new ArrayList<>();
		
		daoList = empDao.excelEmpUpdate(sqlSession, list);
		
		
		return daoList;
	}

	@Override
	public HashMap<String, Object> selectEmpDeptJob(Employee employee) {
		HashMap<String, Object> hmap = null;
		
		PromotionHistory jobHistory = empDao.selectEmpJob(sqlSession, employee);
		DeptHistory dpHistory = empDao.selectEmpDept(sqlSession, employee);
		
		hmap = new HashMap<String, Object>();
		hmap.put("jobHistory", jobHistory);
		hmap.put("dpHistory", dpHistory);
		
		return hmap;
	}

	@Override
	public Attachment selectProfile(Employee employee) {
		return empDao.selectProfile(sqlSession, employee);
	}

	@Override
	public int updatePwdCheck(EmployeeResult employee) {
		int result =0;
		String encPassword = empDao.selectUpCheckPwd(sqlSession, employee);
		
		System.out.println(employee.getEmpId());
		
		System.out.println("비밀번호 : " + encPassword);
		System.out.println("암호 2 : " + employee.getEmpPwd());	
		String pass =  passwordEncoder.encode(employee.getEmpPwd());
		System.out.println(pass);
		
		if(passwordEncoder.matches(employee.getEmpPwd(), encPassword)) {
			result=1;
		}else {
			result=0;
		}
		
		
		return result;
	}




	//	@Override
//	public Employee loginEmpl(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.loginEmpl(employee,sqlSession);
//	}
//
//	@Override
//	public ArrayList<Employee> selectEmlList() {
//		// TODO Auto-generated method stub
//		return empDao.selectEmpList(sqlSession);
//	}
//
//	@Override
//	public Employee selectOneEmp(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.selectOneEmp(sqlSession, employee);
//	}
//
//	@Override
//	public int updateOneEmp(Employee loginUser, Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.updateOneEmp(sqlSession, loginUser, employee);
//	}
//
//	@Override
//	public ArrayList<Employee> searchEmp(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.searchEmp(sqlSession, employee);
//	}
//
//	@Override
//	public int reqHoliday(Employee loginUser) {
//		// TODO Auto-generated method stub
//		return empDao.reqHoliday(sqlSession, loginUser);
//	}
//
//	@Override
//	public Attendace selectAttend(Employee loginUser) {
//		// TODO Auto-generated method stub
//		return empDao.selectAttend(sqlSession, loginUser);
//	}
//
//	@Override
//	public int insertEmp(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.insertEmp(sqlSession, employee);
//	}
//
//	@Override
//	public int insertDuty() {
//		// TODO Auto-generated method stub
//		return empDao.insertDuty(sqlSession);
//	}
//
//	@Override
//	public int updateLeave(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.updateLeave(sqlSession, employee);
//	}
//
//	@Override
//	public ArrayList<Employee> selctLeaveList() {
//		// TODO Auto-generated method stub
//		return empDao.selectLeaveList(sqlSession);
//	}

}
