package com.kh.lgtw.employee.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.DeptHistory;
import com.kh.lgtw.employee.model.vo.DeptVo;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.EmployeeResult;
import com.kh.lgtw.employee.model.vo.ExcelEmp;
import com.kh.lgtw.employee.model.vo.JobVo;
import com.kh.lgtw.employee.model.vo.PromotionHistory;

public interface EmployeeDao{

	Employee loginCheck(SqlSession sqlSession, Employee employee) throws LoginException;

	int inSertEmpOne(SqlSession sqlSession, Employee employee);

	String selectEncPassword(SqlSession sqlSession, Employee employee);

	int empExcelUpload(SqlSession sqlSession, File destFile);

	List<ExcelEmp> excelEmpInsert(SqlSession sqlSession, List<ExcelEmp> list, Attachment attach);

	List<String> selectEmpEmailForName(SqlSession sqlSession, String sName);
	
  ArrayList<DeptVo> selectDeptList(SqlSession sqlSession);

  int insertEmpQuick(SqlSession sqlSession, Employee employee);

  	int insertDeptHistory(SqlSession sqlSession, DeptVo dpVo, JobVo jobVo);

  	ArrayList<EmployeeResult> selectEmpListAdmin(SqlSession sqlSession, PageInfo pi);

	ArrayList<JobVo> selectJobAdmin(SqlSession sqlSession);	

	int insertEmpProfile(SqlSession sqlSession, Attachment attach);

	int getEmpListCount(SqlSession sqlSession);

	int deleteEmpList(SqlSession sqlSession, int empNo);

	ArrayList<EmployeeResult> dbEmpList(SqlSession sqlSession);

	List<EmployeeResult> excelEmpUpdate(SqlSession sqlSession, List<EmployeeResult> list);

	PromotionHistory selectEmpJob(SqlSession sqlSession, Employee employee);

	DeptHistory selectEmpDept(SqlSession sqlSession, Employee employee);

	Attachment selectProfile(SqlSession sqlSession, Employee employee);

	String selectUpCheckPwd(SqlSession sqlSession, EmployeeResult employee);

	int updateEmpOne(SqlSession sqlSession, EmployeeResult employee);

	int updateEmpOneDept(SqlSession sqlSession, EmployeeResult employee);

	int updateEmpOneJob(SqlSession sqlSession, EmployeeResult employee);

	void updateEmpAttach(SqlSession sqlSession, Attachment attach);

	ArrayList<EmployeeResult> selectEmpResult(SqlSession sqlSession);

	ArrayList<DeptVo> selectOrgDept(SqlSession sqlSession);

	ArrayList<Attachment> selectAttachList(SqlSession sqlSession);

	ArrayList<EmployeeResult> searchEmpUser(SqlSession sqlSession, PageInfo pi, EmployeeResult employee);

	int getSearchEmpCount(SqlSession sqlSession, EmployeeResult employee);

	ArrayList<EmployeeResult> allEmpList(SqlSession sqlSession);

	int insertPrsnlManager(SqlSession sqlSession, ArrayList<Object> empList);

	ArrayList<EmployeeResult> selectPrnlEmp(SqlSession sqlSession);

	int deletePrsnlManager(SqlSession sqlSession, ArrayList<Object> empList);

	ArrayList<EmployeeResult> selectEmpList(SqlSession sqlSession, PageInfo pi);

	int checkEmpWork(SqlSession sqlSession, int empNo);










//	Employee loginEmpl(Employee employee, SqlSession sqlSession);
//
//	ArrayList<Employee> selectEmpList(SqlSession sqlSession);
//
//	Employee selectOneEmp(SqlSession sqlSession, Employee employee);
//
//	int updateOneEmp(SqlSession sqlSession, Employee loginUser, Employee employee);
//
//	ArrayList<Employee> searchEmp(SqlSession sqlSession, Employee employee);
//
//	int reqHoliday(SqlSession sqlSession, Employee loginUser);
//
//	Attendace selectAttend(SqlSession sqlSession, Employee loginUser);
//
//	int insertEmp(SqlSession sqlSession, Employee employee);
//
//	int insertDuty(SqlSession sqlSession);
//
//	int updateLeave(SqlSession sqlSession, Employee employee);
//
//	ArrayList<Employee> selectLeaveList(SqlSession sqlSession);

}
