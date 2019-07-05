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
import com.kh.lgtw.employee.model.vo.Employee;

@Repository
public class ApprovalDaoImpl implements ApprovalDao{

	@Override
	public SignForm selectSignForm(SqlSession session, SignForm sf) {
		
		return session.selectOne("Approval.selectSignForm",sf);
	}
	
//	//진행중인 전체문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showAllPrograssDocument(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
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

//	//완료문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showFinishDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
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
//	//완료문서 - 전체보기
//	@Override
//	public ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
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
//	//완료문서-반려문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//완료문서-임시저장문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//------------------------관리자설정-----------------------------
//	//전자결재 관리자
//	@Override
//	public ArrayList<Employee> showAppManager(SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//관리자 추가
//	@Override
//	public int insertApprovalMng(SqlSession session, int eid) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
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
//	//전체문서목록
//	@Override
//	public ArrayList<HashMap<String, Object>> showAllDcm(SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//삭제문서 전체
//	@Override
//	public ArrayList<HashMap<String, Object>> showDeleteDcm(SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
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
	//합의결재
	@Override
	public int updateAgree(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
	//합의
	@Override
	public String selectAgreeApprovalYN(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectAgreeApprovalYN", map);
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
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("Approval.selectUnderEmp", deptCode);
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
			map.put("status", "신청대기");
			
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
		
		appDcm.put("kind", "pro");
		
		int result = 0;
		int result1 = 0;
		
		for(int i = 0; i < process.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("alEmpno", process[i]);
			map.put("alRoll", "처리자");
			map.put("alLevel", 1);
			map.put("status", "처리대기");
			
			result1 = session.insert("Approval.insertApprovalList", appDcm);
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
	public String selectCircleEmp(SqlSession session, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("Approval.selectCircleEmp", map);
	}



	








	







	











	

}
