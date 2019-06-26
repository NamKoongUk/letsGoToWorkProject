package com.kh.lgtw.employee.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.lgtw.employee.model.dao.EmployeeDao;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.ExcelEmp;

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
	public int insertEmpOne(Employee employee) {
		return empDao.inSertEmpOne(sqlSession, employee);
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

	@Override
	public List<ExcelEmp> xlsxEmpInsert(MultipartHttpServletRequest request, MultipartFile excelFile) {
		
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
								case 0 : excelEmp.setEmpNo((int)Double.parseDouble(value)); break;
								case 1 : excelEmp.setEmpId(value); break;
								case 2 : excelEmp.setEmpPwd(value); break;
								case 3 : excelEmp.setEmpName(value); break;
								case 4 : excelEmp.setEmpPhone(value); break;
								case 5 : excelEmp.setStatus(value); break;
								case 6 : excelEmp.setEnrollDate(Date.valueOf(value));break;
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
		
		daoList = empDao.excelEmpInsert(sqlSession, list);
		
		
		return daoList;
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
