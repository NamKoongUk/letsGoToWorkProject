package com.kh.lgtw.approval.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.Security;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.employee.model.vo.Employee;

public interface ApprovalDao {

	SignForm selectSignForm(SqlSession session, SignForm sf);

	ArrayList<HashMap<String, Object>> showAllPrograssDocument(PageInfo pi, SqlSession session);
//
	ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi, SqlSession session);
//
	ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi, SqlSession session);
//
	ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi, SqlSession session);
//
//	ArrayList<HashMap<String, Object>> showFinishDcm(PageInfo pi, SqlSession session);
//
	ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi, SqlSession session);
//
	ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi, SqlSession session, String jobCode);
//
//	ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi, SqlSession session);
//
//	ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi, SqlSession session);
//
//	ArrayList<HashMap<String, Object>> showReceptionDcm(PageInfo pi, SqlSession session);
//
	ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi, SqlSession session);
//
//	ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi, SqlSession session);
//
//	ArrayList<Employee> showAppManager(SqlSession session);ㅁ
//
	int insertApprovalMng(SqlSession session, ArrayList<Object> empList);
//
	ArrayList<AppForm> showFormManagement(SqlSession session, PageInfo pi);
//
	int insertAppForm(SqlSession session, AppForm form);
//
	int deleteAppForm(SqlSession session, List<String> afNo);
//
	int updateAppForm(SqlSession session, AppForm form);
//
	int statusUpdateAppForm(SqlSession session, Map<String, Object> map);
//
//
//	ArrayList<AppForm> selectOfferDcm(SqlSession session);
//
	AppForm selectOneAppFormDcm(SqlSession session, int afNo);
//
//	int saveOfferDcm(SqlSession session, int[] afNo);
//
	ArrayList<HashMap<String, Object>> showAllDcm(SqlSession session, PageInfo pi);
//
	ArrayList<HashMap<String, Object>> showDeleteDcm(SqlSession session, PageInfo pi);
//
	HashMap<String, Object> showDetailDcm(SqlSession session, String adNo);
//
	int updateApproval(SqlSession session, HashMap<String, Object> map);
//
	int confirmDcm(SqlSession session, HashMap<String, Object> map);
//
//	int updateDcm(SqlSession session, int eid, String adNo);
//
	ArrayList<HashMap<String, Object>> selectFormList(SqlSession session);
//
//	AppForm selectDcmForm(SqlSession session, int afNo);
//
//	ArrayList<SignLine> selectApprovalLine(SqlSession session, int eid);
//
//	ArrayList<Employee> selectReferenceEmp(SqlSession session, String name);
//
//	int saveApprovalDcm(SqlSession session, AppDocument aDcm);
//
//	int insertApprovalDcm(SqlSession session, AppDocument aDcm);
//
//	int insertApprovalList(SqlSession session, AppDocument aDcm, int[] eid);
//
//	ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi, SqlSession session);

	int getFormManagementListCount(SqlSession session);

	ArrayList<Security> selectSecurity(SqlSession session);

	ArrayList<HashMap<String, Object>> selectJob(SqlSession session);

	int updateGrade(SqlSession session, Map<String, String> grade);

	HashMap<String, Object> selectWriteForm(int afNo, SqlSession session);

	List<HashMap<String, Object>> autocompleteCircle(String value, SqlSession session);

	ArrayList<HashMap<String, Object>> selectEmp(SqlSession session);

	ArrayList<HashMap<String, Object>> selectDept(SqlSession session);

	ArrayList<HashMap<String, Object>> selectDept(SqlSession session, String deptCode);

	ArrayList<HashMap<String, Object>> selectEmp(SqlSession session, String deptCode);

	int writeApproval(AppDocument appDocument, SqlSession session);

	int insertCircleList(Map<String, Object> appDcm, SqlSession session);

	int insertApprovalList(Map<String, Object> appDcm, SqlSession session);

	int insertReferenceList(Map<String, Object> appDcm, SqlSession session);

	int insertPayAgreeList(Map<String, Object> appDcm, SqlSession session);

	int insertApplyList(Map<String, Object> appDcm, SqlSession session);

	int insertProcessList(Map<String, Object> appDcm, SqlSession session);

	int insertSendList(Map<String, Object> appDcm, SqlSession session);

	int selectWaitCircleDcm(int empNo, SqlSession session);

	ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi, SqlSession session);

	int insertAgreeList(Map<String, Object> appDcm, SqlSession session);

	int selectWaitDcm(int empNo, SqlSession session);

	ArrayList<HashMap<String, Object>> selectApprovalList(SqlSession session, String adNo, String string);

	int selectIntendedDcm(int empNo, SqlSession session);

	int selectCircleDcm(HashMap<String, Object> map, SqlSession session);

	int selectProgressDcm(HashMap<String, Object> map, SqlSession session);

	int selectWaitReceptionDcm(int empNo, SqlSession session);

	int updateAdLevel(SqlSession session, HashMap<String, Object> map);

	String selectApprovalYN(SqlSession session, HashMap<String, Object> map);

	int updateAdStatus(SqlSession session, HashMap<String, Object> map, String string);

	String selectNormalApprovalYN(SqlSession session, HashMap<String, Object> map);

	int countAgreeMember(SqlSession session, HashMap<String, Object> map);

	int countPayAgreeMember(SqlSession session, HashMap<String, Object> map);

	int updateAdStatusAndLevel(SqlSession session, HashMap<String, Object> map, String string);

	String selectCircleEmp(SqlSession session, HashMap<String, Object> map);

	String selectAgreeApprovalYN(SqlSession session, HashMap<String, Object> map);

	String selectPayAgreeApprovalYN(SqlSession session, HashMap<String, Object> map);

	String selectApplyApprovalYN(SqlSession session, HashMap<String, Object> map);

	String selectProcessApprovalYN(SqlSession session, HashMap<String, Object> map);

	int selecAllFinishDcm(int empNo, String jobCode, SqlSession session);

	String selectEmpJobCode(Employee e, SqlSession session);

	int selectMyWriteDcm(int empNo, SqlSession session);

	ArrayList<HashMap<String, Object>> showMyWriteDcm(PageInfo pi, SqlSession session);

	int selectAllPrograssDcm(int empNo, SqlSession session);

	String selectSendEmp(SqlSession session, HashMap<String, Object> map);

	int selectFinApprovaldDcm(SqlSession session, String jobCode);

	ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi, String jobCode, SqlSession session);

	int selectWriteDcm(SqlSession session, Employee e);

	ArrayList<HashMap<String, Object>> showWriteDcm(SqlSession session, PageInfo pi);

	int selectRefuseDcm(SqlSession session, String jobCode);

	ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi, String jobCode, SqlSession session);

	int countAllDcm(SqlSession session);

	int deleteDcm(String[] adNoArr, SqlSession session);

	int deleteAppList(String[] adNoArr, SqlSession session);

	int countDeleteDcm(SqlSession session);

	int permanentlyDeleteDcm(String[] adNoArr, SqlSession session);

	int recoveryDcm(SqlSession session, String[] adNoArr);

	ArrayList<Employee> showApprovalManager(SqlSession session);

	int deleteManager(SqlSession session, ArrayList<Object> empList);

	int writeReply(HashMap<String, Object> map, SqlSession session);

	ArrayList<HashMap<String, Object>> selectAdReply(SqlSession session, String adNo);

}
