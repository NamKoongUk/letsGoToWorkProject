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
//	//결재 대기문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//처리예정 문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//처리중인문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//완료문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showFinishDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//수신대기문서 조회
//	@Override
//	public ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//회람대기문 이동
//	@Override
//	public ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
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
//	//완료문서-회람/참조 문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi, SqlSession session) {
//		// TODO Auto-generated method stub
//		return null;
//	}
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
//	//문서 상세보기
//	@Override
//	public HashMap<String, Object> showDetailDcm(SqlSession session, String adNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	//문서결재
//	@Override
//	public int approvalDcm(SqlSession session, int eid, String adNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	//회람 or 수신 확인
//	@Override
//	public int confirmDcm(SqlSession session, int eid, String adNo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
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








	

}
