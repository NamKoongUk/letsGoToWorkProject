package com.kh.lgtw.employee.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.util.ExcelRead;
import com.kh.lgtw.employee.model.util.ExcelReadOption;
import com.kh.lgtw.employee.model.vo.DeptVo;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.EmployeeResult;
import com.kh.lgtw.employee.model.vo.ExcelEmp;
import com.kh.lgtw.employee.model.vo.JobVo;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	// 로그인 확인
	@Override
	public Employee loginCheck(SqlSession sqlSession, Employee employee) throws LoginException {
		return sqlSession.selectOne("Employee.loginCheck", employee);
	}
	
	// 비밀번호 확인
	@Override
	public String selectEncPassword(SqlSession sqlSession, Employee employee) {
		return sqlSession.selectOne("Employee.selectEncPassword", employee);
	}
	
	// 사원추가
	@Override
	public int inSertEmpOne(SqlSession sqlSession, Employee employee) {
		return sqlSession.insert("Employee.insertEmpOne",employee);
	}

	@Override
	public int empExcelUpload(SqlSession sqlSession, File destFile) {
		
		
		ExcelReadOption excelReadOption = new ExcelReadOption();
		
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		
		excelReadOption.setOutputColums("아이디","비밀번호","이름","생년월일","성별","핸드폰번호","주소","이메일");
		
		excelReadOption.setStartRow(2);
		
		List<Map<String,String>>excelContent = ExcelRead.read(excelReadOption);
		
		Map<String,Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("excelContent", excelContent);
		
		System.out.println("엑셀:"+paramMap.toString());
		
		return sqlSession.insert("ExcelEmp.insertEmpExcel",paramMap);
	}

	@Override
	public List<ExcelEmp> excelEmpInsert(SqlSession sqlSession, List<ExcelEmp> list) {
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println("포문시작");
			sqlSession.insert("ExcelEmp.insertEmpExcel", list.get(i));
			
		}
		
		System.out.println("포문완료");
		
		return list;
	}

	// 사원이름으로 이메일 찾기 
	@Override
	public List<String> selectEmpEmailForName(SqlSession sqlSession, String sName) {
		return sqlSession.selectList("Employee.selectEmpEmailForName", sName);
	}

	@Override
	public ArrayList<DeptVo> selectDeptList(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("Employee.selectDeptList");
	}


	@Override
	public int insertEmpQuick(SqlSession sqlSession, Employee employee) {
		return sqlSession.insert("Employee.insertEmpQuick", employee);
	}

	@Override
	public int insertDeptHistory(SqlSession sqlSession, DeptVo dpVo, JobVo jobVo) {
		sqlSession.insert("Employee.insertJobHistory", jobVo);
		return sqlSession.insert("Employee.insertDeptHistory", dpVo);
	}

	@Override
	public ArrayList<EmployeeResult> selectEmpListAdmin(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("Employee.selectEmpListAdmin");
	}


	@Override
	public ArrayList<JobVo> selectJobAdmin(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("Employee.selectJobAdmin");
	}

	@Override
	public int insertEmpProfile(SqlSession sqlSession, Attachment attach) {
		return sqlSession.insert("Employee.insertEmpProfile", attach);
	}

	




//	@Override
//	public Employee loginEmpl(Employee employee, SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ArrayList<Employee> selectEmpList(SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Employee selectOneEmp(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int updateOneEmp(SqlSession sqlSession, Employee loginUser, Employee employee) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ArrayList<Employee> searchEmp(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int reqHoliday(SqlSession sqlSession, Employee loginUser) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Attendace selectAttend(SqlSession sqlSession, Employee loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int insertEmp(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int insertDuty(SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int updateLeave(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ArrayList<Employee> selectLeaveList(SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
