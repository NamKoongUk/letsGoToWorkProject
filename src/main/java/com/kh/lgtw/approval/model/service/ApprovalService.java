package com.kh.lgtw.approval.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.Security;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.employee.model.vo.Employee;

public interface ApprovalService {

	SignForm selectSignForm(SignForm sf);

	ArrayList<HashMap<String, Object>> showAllPrograssDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showFinishDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi, String jobCode);
//
//	ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showReceptionDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi);
//
//	ArrayList<Employee> showAppManager();
//
	int insertApprovalMng(ArrayList<Object> empList);
//
	ArrayList<AppForm> showFormManagement(PageInfo pi);
//
	int insertAppForm(AppForm form);
//
	int deleteAppForm(List<String> afNo);
//
	int statusUpdateAppForm(Map<String, Object> map);
//
	int updateAppForm(AppForm form);
//
//	ArrayList<AppForm> selectOfferDcm();
//
	AppForm selectOneAppFormDcm(int afNo);
//
//	int saveOfferDcm(int[] afNo);
//
	ArrayList<HashMap<String, Object>> showAllDcm(PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showDeleteDcm(PageInfo pi);
//
//	HashMap<String, Object> showDetailDcm(String adNo);
//
	int updateApproval(HashMap<String, Object> map);
//
	int confirmDcm(String adNo, int eid);
//
//	int updateDcm(String adNo, int eid);
//
	ArrayList<HashMap<String, Object>> selectFormList();
//
//	AppForm selectDcmForm(int afNo);
//
//	ArrayList<SignLine> selectApprovalLine(int eid);
//
//	ArrayList<Employee> selectReferenceEmp(String name);
//
//	int saveApprovalDcm(AppDocument ad);
//
//	int insertApprovalDcm(AppDocument ad, int []eid);
//
//	ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi);

	int getFormManagementListCount();

	ArrayList<Security> selectSecurity();

	ArrayList<HashMap<String, Object>> selectJob();

	int updateGrade(Map<String, String> grade);

	HashMap<String, Object> selectWriteForm(int afNo);

	List<HashMap<String, Object>> autocompleteCircle(String value);

	Map<String, ArrayList<HashMap<String, Object>>> selectEmp();

	Map<String, ArrayList<HashMap<String, Object>>> selectUnderDept(String deptCode);

	int writeApproval(Map<String, Object> appDcm);

	int selectWaitCircleDcm(int empNo);

	ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi);

	HashMap<String, Object> showDetailDcm(String adNo);

	int selectWaitDcm(int empNo);

	HashMap<String, ArrayList<HashMap<String, Object>>> selectAppList(String adNo);

	int selectIntendedDcm(int empNo);

	int selectCircleDcm(int empNo, String string);

	int selectProgressDcm(int empNo, String string);

	int selectWaitRecptionDcm(int empNo);

	int updateAgree(HashMap<String, Object> map);

	int updatePayAgree(HashMap<String, Object> map);

	int updateApply(HashMap<String, Object> map);

	int updateProcess(HashMap<String, Object> map);

	int selecAllFinishDcm(String jobCode, int i);

	String selectEmpJobCode(Employee e);

	int selectMyWriteDcm(int empNo, String string);

	ArrayList<HashMap<String, Object>> showMyWriteDcm(PageInfo pi);

	int updateSendApproval(HashMap<String, Object> map);

	int selectAllPrograssDcm(int empNo);

	int confirmSendDcm(String adNo, int empNo);

	int selectWriteDcm(Employee e);

	ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi);

	int selectFinApprovaldDcm(String jobCode);

	ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi, String jobCode);

	int selectRefuseDcm(String jobCode);

	ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi, String jobCode);

	HashMap<String, Object> selectDcmCount(int empNo);

	int countAllDcm();

	int deleteDcm(String[] adNoArr);

	int countDeleteDcm();

	int permanentlyDeleteDcm(String[] adNoArr);

	int recoveryDcm(String[] adNoArr);

	ArrayList<Employee> showApprovalManager();

	int deleteManager(ArrayList<Object> empList);

	int writeReply(HashMap<String, Object> map);

	

}
