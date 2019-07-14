package com.kh.lgtw.approval.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.Security;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.vo.Employee;

@Repository
public class ApprovalDaoImpl implements ApprovalDao{

	@Override
	public SignForm selectSignForm(SqlSession session, SignForm sf) {
		
		return session.selectOne("Approval.selectSignForm",sf);
	}
	
	//진행중인 전체문서 조회
	@Override
	public ArrayList<HashMap<String, Object>> showAllPrograssDocument(PageInfo pi, SqlSession session) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showAllPrograssDocument", pi, rowBounds);
	}
	@Override
	public int selectAllPrograssDcm(HashMap<String, Object> map, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectAllPrograssDcmAndCategory", map);
	}
	
	@Override
	public int selectAllPrograssDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectAllPrograssDcm", empNo);
	}

	
	//결재 대기문서 조회
	@Override
	public ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi, SqlSession session) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showWaitDcm", pi, rowBounds);
	}
	@Override
	public int selectWaitDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectWaitDcm", empNo);
	}

	//처리예정 문서 조회
	@Override
	public ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi, SqlSession session) {
		// TODO Auto-generated method stub
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showIntendedDcm", pi, rowBounds);
	}

	@Override
	public int selectIntendedDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectIntendedDcm", empNo);
	}

	//처리중인문서 조회
	@Override
	public ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi, SqlSession session) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showProgressDcm", pi, rowBounds);
	}
	@Override
	public int selectProgressDcm(HashMap<String, Object> map, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.countProgressDcm", map);
	}
	//진행중인 기안한 문서
	@Override
	public int selectMyWriteDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectMyWriteDcm", empNo);
	}
	//진행중인 기안한 문서
	@Override
	public ArrayList<HashMap<String, Object>> showMyWriteDcm(PageInfo pi, SqlSession session) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showMyWriteDcm", pi, rowBounds);
	}


	
	//수신대기문서 조회
	@Override
	public ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi, SqlSession session) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showWaitCirculationDcm", pi, rowBounds);
	}
	@Override
	public int selectWaitReceptionDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectWaitCReceptionDcmList", empNo);
	}

	//회람대기문 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi, SqlSession session) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showWaitCirculationDcm", pi, rowBounds);
	}
	@Override
	public int selectWaitCircleDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectWaitCircleDcmList", empNo);
	}
	
//	//-------------------------완료문서-----------------------------
	//완료문서 - 전체보기
	@Override
	public ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi, SqlSession session, String jobCode) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		pi.setSort(jobCode);
		
		return (ArrayList)session.selectList("Approval.showAllFinishDcm", pi, rowBounds);		
	}
	@Override
	public int selecAllFinishDcm(int empNo, String jobCode, SqlSession session) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empNo", empNo);
		map.put("jobCode", jobCode);
		
		return session.selectOne("Approval.selecAllFinishDcm", map);
	}

//	//완료문서-기안한문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//완료문서-결재문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//완료문서-수신문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showReceptionDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	//완료문서-회람/참조 문서
	@Override
	public ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi, SqlSession session) {
		// TODO Auto-generated method stub
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		pi.setSort("circle");
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showFinDcm", pi, rowBounds);
	}
	@Override
	public int selectCircleDcm(HashMap<String, Object> map, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectCircleDcm", map);
	}
	//반려문서
	@Override
	public int selectRefuseDcm(SqlSession session, String jobCode) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectRefuseDcm", jobCode);
	}

	@Override
	public ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi, String jobCode, SqlSession session) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showRefuseDcm", jobCode, rowBounds);
	}
	//임시저장문서
	@Override
	public int selectSaveDcm(int empNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectSaveDcm", empNo);
	}

	@Override
	public ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi, SqlSession session) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		pi.setSort("circle");
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showSaveDcm", pi, rowBounds);
	}
//	//------------------------관리자설정-----------------------------
//	//전자결재 관리자
//	@Override
//	public ArrayList<Employee> showAppManager(SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	//관리자 추가
	@Override
	public int insertApprovalMng(SqlSession session, ArrayList<Object> empList) {
		
		int result = 0;
		
		for(int i = 0; i < empList.size(); i++) {
			
			int empNo = Integer.parseInt((String)empList.get(i));
			
			result += session.update("Approval.insertApprovalMng", empNo);
		}
		
		return result;
	}
	//관리자 삭제
	@Override
	public int deleteManager(SqlSession session, ArrayList<Object> empList) {
		int result = 0;
		
		for(int i = 0; i < empList.size(); i++) {
			
			int empNo = Integer.parseInt((String)empList.get(i));
			
			result += session.update("Approval.deleteManager", empNo);
		}
		
		return result;
	}
	
//	//양식관리
	@Override
	public ArrayList<AppForm> showFormManagement(SqlSession session, PageInfo pi) {
		
		ArrayList<AppForm> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.selectAppForm", null, rowBounds);
	}
	//양식관리 리스트카운트 조회
	@Override
	public int getFormManagementListCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectAppFormListCount");
	}
	
	//양식생성
	@Override
	public int insertAppForm(SqlSession session, AppForm form) {

		return session.insert("Approval.insertAppForm", form);
	}
	//양식 삭제
	@Override
	public int deleteAppForm(SqlSession session, List<String> afNo) {
		// TODO Auto-generated method stub
		int result = 0;
		
		for(int i = 0; i < afNo.size(); i++) {
			int afNumber = Integer.parseInt(afNo.get(i));
			session.delete("Approval.deleteAppForm", afNumber);
			result += 1;
		}
		
		return result;
	}
	//양식 수정
	@Override
	public int updateAppForm(SqlSession session, AppForm form) {
		// TODO Auto-generated method stub
		return session.update("Approval.updateAppForm", form);
	}
	
	//사용 미사용 전환
	@Override
	public int statusUpdateAppForm(SqlSession session, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.update("Approval.statusUpdateAppForm", map);
	}
//	//미사용 전환
//	@Override
//	public int updateNotUserForm(SqlSession session, AppForm form) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	//제공양식 보기
//	@Override
//	public ArrayList<AppForm> selectOfferDcm(SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	//양식상세
	@Override
	public AppForm selectOneAppFormDcm(SqlSession session, int afNo) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectOneAppFormDcm", afNo);
	}
//	//제공양식저장
//	@Override
//	public int saveOfferDcm(SqlSession session, int[] afNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	//전체문서목록
	@Override
	public ArrayList<HashMap<String, Object>> showAllDcm(SqlSession session, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showAllDcm", pi, rowBounds);
	}
	@Override
	public int countAllDcm(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.countAllDcm");
	}


	//삭제문서 전체
	@Override
	public ArrayList<HashMap<String, Object>> showDeleteDcm(SqlSession session, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showDeleteDcm", pi, rowBounds);
	}
	@Override
	public int countDeleteDcm(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.countDeleteDcm");
	}
	
	//보안등급 불러오기
	@Override
	public ArrayList<Security> selectSecurity(SqlSession session) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectSecurity");
	}
	//직급 불러오기
	@Override
	public ArrayList<HashMap<String, Object>> selectJob(SqlSession session) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectJob");
	}
	//문서 상세보기
	@Override
	public HashMap<String, Object> showDetailDcm(SqlSession session, String adNo) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.detailDcm", adNo);
	}
	//결재선 불러오기
	@Override
	public ArrayList<HashMap<String, Object>> selectApprovalList(SqlSession session, String adNo, String string) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", string);
		map.put("adNo", adNo);
		
		return (ArrayList)session.selectList("Approval.selectApprovalList", map);
	}
	
	//문서결재
	@Override
	public int updateApproval(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.update("Approval.updateApproval", map);
	}
	//adLevel수정
	@Override
	public int updateAdLevel(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.update("Approval.updateAdLevel", map);
	}
	//결재완료여부 체크
	@Override
	public String selectApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectApprovalYN", map);
	}
	//결재상태변환
	@Override
	public int updateAdStatus(SqlSession session, HashMap<String, Object> map, String status) {
		
		map.put("status", status);

		return session.update("Approval.updateAdStatus", map);
	}
	//결재상태 체크
	@Override
	public String selectNormalApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectNormalApprovalYN", map);
	}
	//회람 or 수신 확인
	@Override
	public int confirmDcm(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.update("Approval.confirmDcm", map);
	}
	//합의자조회
	@Override
	public int countAgreeMember(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.countAgreeMember", map);
	}
	//재무합의자 조회
	@Override
	public int countPayAgreeMember(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.countPayAgreeMember", map);
	}
	//문서 상태 및 레벨 초기화
	@Override
	public int updateAdStatusAndLevel(SqlSession session, HashMap<String, Object> map, String string) {
		// TODO Auto-generated method stub
		map.put("status", string);
		return session.update("Approval.updateAdStatusAndLevel", map);
	}

	@Override
	public String selectPayAgreeApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectPayAgreeApprovalYN", map);
	}
	
	//합의
	@Override
	public String selectAgreeApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectAgreeApprovalYN", map);
	}
	//신청자 조회
	@Override
	public String selectApplyApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectApplyApprovalYN", map);
	}
	//처리완료 유무 조회
	@Override
	public String selectProcessApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectProcessApprovalYN", map);
	}

	
	
//	//수신, 회람추가
//	@Override
//	public int updateDcm(SqlSession session, int eid, String adNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	//작성하기 폼 이동
	@Override
	public ArrayList<HashMap<String, Object>> selectFormList(SqlSession session) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectFormList");
	}
	//작성폼 불러오기
	@Override
	public HashMap<String, Object> selectWriteForm(int afNo, SqlSession session) {
		// TODO Auto-generated method stub
		return (HashMap)session.selectOne("Approval.selectWriteForm", afNo);
	}
	//결재선을 위한 사원 불러오기
	@Override
	public ArrayList<HashMap<String, Object>> selectEmp(SqlSession session) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectEmp");
	}
	//결재선 부서 불러오기
	@Override
	public ArrayList<HashMap<String, Object>> selectDept(SqlSession session) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectDept");
	}
	
	//결재선 하위 부서 불러오기
	@Override
	public ArrayList<HashMap<String, Object>> selectDept(SqlSession session, String deptCode) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectUnderDept", deptCode);
	}
	//결재선 하위 부서 사원 불러오기
	@Override
	public ArrayList<HashMap<String, Object>> selectEmp(SqlSession session, String deptCode) {
		ArrayList<HashMap<String, Object>> list = (ArrayList)session.selectList("Approval.selectUnderEmp", deptCode);
		System.out.println("list : " + list);
		return list;
	}

//	//문서양식 불러오기
//	@Override
//	public AppForm selectDcmForm(SqlSession session, int afNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//결재선 불러오기
//	@Override
//	public ArrayList<SignLine> selectApprovalLine(SqlSession session, int eid) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//참조자 설정
//	@Override
//	public ArrayList<Employee> selectReferenceEmp(SqlSession session, String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//문서 임시저장
//	@Override
//	public int saveApprovalDcm(SqlSession session, AppDocument aDcm) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	//결재문서 저장
//	@Override
//	public int insertApprovalDcm(SqlSession session, AppDocument aDcm) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	//결재라인 저장
//	@Override
//	public int insertApprovalList(SqlSession session, AppDocument aDcm, int[] eid) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int updateGrade(SqlSession session, Map<String, String> grade) {
		// TODO Auto-generated method stub
		int result = 0;
		
		int result1 = session.update("Approval.updateAgrade", grade.get("aGrade"));
		int result2 = session.update("Approval.updateBgrade", grade.get("bGrade"));
		
		result = result1 + result2;
		
		return result;
	}
	
	//자동완성
	@Override
	public List<HashMap<String, Object>> autocompleteCircle(String value, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("Approval.selectName", value);
	}

	@Override
	public int writeApproval(AppDocument appDocument, SqlSession session) {
		
		return session.insert("Approval.writeApproval", appDocument);
	}
	
	@Override
	public int saveApprovalDcm(AppDocument appDocument, SqlSession session) {
		
		return session.insert("Approval.saveApprovalDcm", appDocument);
	}

	@Override
	public int insertCircleList(Map<String, Object> appDcm, SqlSession session) {
		
		String[] circle = (String[])appDcm.get("circle");
		
		appDcm.put("kind", "cc");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < circle.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", circle[i]);
			map.put("alRoll", "회람자");
			map.put("alLevel", 1);
			map.put("status", "회람대기");
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == circle.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertApprovalList(Map<String, Object> appDcm, SqlSession session) {
		
		String[] approval = (String[])appDcm.get("approval");
		
		appDcm.put("kind", "app");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < approval.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", approval[i]);
			map.put("alRoll", "결재자");
			map.put("alLevel", i + 1);
			map.put("status", "대기");
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == approval.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertReferenceList(Map<String, Object> appDcm, SqlSession session) {

		String[] ref = (String[])appDcm.get("reference");
		
		appDcm.put("kind", "ref");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < ref.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", ref[i]);
			map.put("alRoll", "참조자");
			map.put("alLevel", 1);
			map.put("status", "참조");
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == ref.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertPayAgreeList(Map<String, Object> appDcm, SqlSession session) {
		// TODO Auto-generated method stub
		String[] payAgree = (String[])appDcm.get("payAgree");
		
		appDcm.put("kind", "pa");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < payAgree.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", payAgree[i]);
			map.put("alRoll", "재무합의자");
			map.put("alLevel", i + 1);
			map.put("status", "재무합의대기");
			
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == payAgree.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertApplyList(Map<String, Object> appDcm, SqlSession session) {
		String[] apply = (String[])appDcm.get("apply");
		
		appDcm.put("kind", "app");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < apply.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", apply[i]);
			map.put("alRoll", "신청자");
			map.put("alLevel", 1);
			map.put("status", "대기");
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == apply.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertProcessList(Map<String, Object> appDcm, SqlSession session) {
		String[] process = (String[])appDcm.get("process");
		System.out.println("DAO : " + process);
		appDcm.put("kind", "pro");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < process.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", process[i]);
			map.put("alRoll", "처리자");
			map.put("alLevel", 1);
			map.put("status", "처리대기");
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == process.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertSendList(Map<String, Object> appDcm, SqlSession session) {
		String[] send = (String[])appDcm.get("send");
		
		appDcm.put("kind", "send");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < send.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", send[i]);
			map.put("alRoll", "수신자");
			map.put("alLevel", 1);
			map.put("status", "수신대기");
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == send.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int insertAgreeList(Map<String, Object> appDcm, SqlSession session) {
		String[] agree = (String[])appDcm.get("agree");
		
		appDcm.put("kind", "agree");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < agree.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", agree[i]);
			map.put("alRoll", "합의자");
			map.put("alLevel", 1);
			map.put("status", "합의대기");
			
			
			result1 = session.insert("Approval.insertApprovalList", map);
		}
		
		if(result1 == agree.length) {
			result = 1;
		}
		
		return result;
	}
	
	@Override
	public int updateReferenceList(Map<String, Object> appDcm, SqlSession session) {
		String[] ref = (String[])appDcm.get("reference");
		
		appDcm.put("kind", "ref");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < ref.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", ref[i]);
			map.put("alRoll", "참조자");
			map.put("alLevel", 1);
			map.put("status", "참조");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == ref.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateProcessList(Map<String, Object> appDcm, SqlSession session) {
		String[] process = (String[])appDcm.get("process");
		System.out.println("DAO : " + process);
		appDcm.put("kind", "pro");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < process.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", process[i]);
			map.put("alRoll", "처리자");
			map.put("alLevel", 1);
			map.put("status", "처리대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == process.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateApplyList(Map<String, Object> appDcm, SqlSession session) {
		String[] apply = (String[])appDcm.get("apply");
		
		appDcm.put("kind", "app");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < apply.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", apply[i]);
			map.put("alRoll", "신청자");
			map.put("alLevel", 1);
			map.put("status", "대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == apply.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateApprovalList(Map<String, Object> appDcm, SqlSession session) {
		String[] approval = (String[])appDcm.get("approval");
		
		appDcm.put("kind", "app");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < approval.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", approval[i]);
			map.put("alRoll", "결재자");
			map.put("alLevel", i + 1);
			map.put("status", "대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			System.out.println(map);
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == approval.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updatePayAgreeList(Map<String, Object> appDcm, SqlSession session) {
		String[] payAgree = (String[])appDcm.get("payAgree");
		
		appDcm.put("kind", "pa");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < payAgree.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", payAgree[i]);
			map.put("alRoll", "재무합의자");
			map.put("alLevel", i + 1);
			map.put("status", "재무합의대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == payAgree.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateAgreeList(Map<String, Object> appDcm, SqlSession session) {
		String[] agree = (String[])appDcm.get("agree");
		
		appDcm.put("kind", "agree");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < agree.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", agree[i]);
			map.put("alRoll", "합의자");
			map.put("alLevel", 1);
			map.put("status", "합의대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == agree.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateCircleList(Map<String, Object> appDcm, SqlSession session) {
		String[] circle = (String[])appDcm.get("circle");
		
		appDcm.put("kind", "cc");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < circle.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", circle[i]);
			map.put("alRoll", "회람자");
			map.put("alLevel", 1);
			map.put("status", "회람대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == circle.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int updateSendList(Map<String, Object> appDcm, SqlSession session) {
		String[] send = (String[])appDcm.get("send");
		
		appDcm.put("kind", "send");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < send.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", send[i]);
			map.put("alRoll", "수신자");
			map.put("alLevel", 1);
			map.put("status", "수신대기");
			map.put("adNo", ((AppDocument)appDcm.get("ad")).getAdNo());
			
			result1 = session.insert("Approval.updateApprovalList", map);
		}
		
		if(result1 == send.length) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public String selectCircleEmp(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectCircleEmp", map);
	}
	
	@Override
	public String selectSendEmp(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectSendEmp", map);
	}

	@Override
	public String selectEmpJobCode(Employee e, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectJobCode", e.getEmpNo());
	}
	//완료 결재문서
	@Override
	public int selectFinApprovaldDcm(SqlSession session, String jobCode) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectFinApprovalDcm", jobCode);
	}

	@Override
	public ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi, String jobCode, SqlSession session) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showFinApprovalDcm", jobCode, rowBounds);
	}
	// 완료 기안한 문서
	@Override
	public int selectWriteDcm(SqlSession session, Employee e) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectWriteDcm", e.getEmpNo());
	}

	@Override
	public ArrayList<HashMap<String, Object>> showWriteDcm(SqlSession session, PageInfo pi) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)session.selectList("Approval.showWriteDcm", pi, rowBounds);
	}

	@Override
	public int deleteDcm(String[] adNoArr, SqlSession session) {
		
		int result = 0;
		
		for(int i = 0; i < adNoArr.length; i++) {
			String adNo = adNoArr[i];
			result += session.update("Approval.deleteDcm", adNo);
		}
		
		return result;
	}

	@Override
	public int deleteAppList(String[] adNoArr, SqlSession session) {
		
		int result = 0;
		
		for(int i = 0; i < adNoArr.length; i++) {
			String adNo = adNoArr[i];
			result += session.delete("Approval.deleteAppList", adNo);
		}
				
		return result;
	}

	@Override
	public int permanentlyDeleteDcm(String[] adNoArr, SqlSession session) {
		int result = 0;
		
		for(int i = 0; i < adNoArr.length; i++) {
			String adNo = adNoArr[i];
			result += session.delete("Approval.permanentlyDeleteDcm", adNo);
		}
				
		return result;
	}

	@Override
	public int recoveryDcm(SqlSession session, String[] adNoArr) {
		
		int result = 0;
		
		for(int i = 0; i < adNoArr.length; i++) {
			String adNo = adNoArr[i];
			result += session.update("Approval.recoveryDcm", adNo);
		}
		
		return result;
	}

	@Override
	public ArrayList<Employee> showApprovalManager(SqlSession session) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectApprovalManager");
	}

	@Override
	public int writeReply(HashMap<String, Object> map, SqlSession session) {
		// TODO Auto-generated method stub
		return session.insert("Approval.insertReply", map);
	}

	@Override
	public ArrayList<HashMap<String, Object>> selectAdReply(SqlSession session, String adNo) {
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectAdReply", adNo);
	}

	@Override
	public int updateReply(HashMap<String, Object> map, SqlSession session) {
		// TODO Auto-generated method stub
		return session.update("Approval.updateReply", map);
	}

	@Override
	public int deleteReply(HashMap<String, Object> map, SqlSession session) {
		// TODO Auto-generated method stub
		return session.update("Approval.deleteReply", map);
	}

	@Override
	public int uploadFile(HashMap<String, Object> file, SqlSession session) {
		// TODO Auto-generated method stub
		return session.insert("Approval.uploadFile", file);
	}

	@Override
	public Attachment downloadFile(int adNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.downloadFile", adNo);
	}

	@Override
	public int readAppDcm(SqlSession session, String adNo, int empNo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adNo", adNo);
		map.put("empNo", empNo);
		
		return session.update("Approval.updateReadDcm", map);
	}

	@Override
	public int cancleAppDcm(String adNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.update("Approval.saveDcm", adNo);
	}

	@Override
	public int deleteAppList(String adNo, SqlSession session) {
		// TODO Auto-generated method stub
		return session.delete("Approval.deleteAppList", adNo);
	}

	@Override
	public int updateApprovalDcm(AppDocument appDocument, SqlSession session) {
		// TODO Auto-generated method stub
		return session.update("Approval.updateApprovalDcm", appDocument);
	}

	











	






	








	







	











	

}
