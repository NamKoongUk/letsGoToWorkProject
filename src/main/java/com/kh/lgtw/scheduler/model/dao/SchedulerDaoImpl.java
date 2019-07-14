package com.kh.lgtw.scheduler.model.dao;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.scheduler.model.vo.Schedule;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

@Repository
public class SchedulerDaoImpl implements SchedulerDao{

	@Override
	public int insertMemberScheduler(SqlSession sqlSession, Scheduler sc) {
		
		return sqlSession.insert("Scheduler.insertMemberScheduler", sc);
	}

	@Override
	public ArrayList<Scheduler> selectSchedulerList(SqlSession sqlSession, int empNo) {
		ArrayList list = null;
		
		list = (ArrayList)sqlSession.selectList("Scheduler.selectSchedulerList", empNo);
//		System.out.println("Dao 조회 후 : " + list);
		
		return list;
	}

	@Override
	public int insertSchedule(SqlSession sqlSession, Schedule schedule) {
//		System.out.println(schedule);
		String status = sqlSession.selectOne("Scheduler.selectScrStatus", schedule);
		
		schedule.setStatus(status);
		
		return sqlSession.insert("Scheduler.insertSchedule", schedule);
	}

	@Override
	public HashMap<String, ArrayList<Object>> allSelectSchedule(SqlSession sqlSession, int empNo) {
		HashMap<String, ArrayList<Object>> allList = new HashMap<String, ArrayList<Object>>();
		
		
		ArrayList<Object> empScList = (ArrayList)sqlSession.selectList("Scheduler.selectEmpSc", empNo);
		System.out.println("개인캘린더 목록 : " + empScList);
		ArrayList<Object> gpScList = (ArrayList)sqlSession.selectList("Scheduler.selectGpSc", empNo);
		System.out.println("공유캘린더 목록 : " + gpScList);
		ArrayList<Object> scList = (ArrayList)sqlSession.selectList("Scheduler.selectSc", empNo);
		System.out.println("일정 목록 : " + scList);
		
		
		allList.put("empScList", empScList);
		allList.put("gpScList", gpScList);
		allList.put("scList", scList);
		
		return allList;
	}

	@Override
	public Schedule selectScheduleDetail(SqlSession sqlSession, Schedule schedule) {

		return sqlSession.selectOne("Scheduler.selectScheduleDetail", schedule);
	}

	@Override
	public int deleteSchedule(SqlSession sqlSession, Schedule schedule) {

		return sqlSession.delete("Scheduler.deleteSchedule", schedule);
	}

	@Override
	public int updateSchedule(SqlSession sqlSession, Schedule schedule) {
		
		if(schedule.getStartTime() == null && !(schedule.getStartDate() == null)) {
			System.out.println("풀캘린더 드랍 업데이트");
			return sqlSession.update("Scheduler.dropEventUpdate", schedule);
		}else if(schedule.getStartDate() == null){
			System.out.println("풀캘린더 드래그 업데이트");
			return sqlSession.update("Scheduler.dragEventUpdate", schedule);
		}else {
			return sqlSession.update("Scheduler.updateSchedule", schedule);
		}
		
	}

	@Override
	public int updateEmpScheduler(SqlSession sqlSession, Scheduler scheduler) {
		
		return sqlSession.update("Scheduler.updateEmpScheduler", scheduler);
	}

	@Override
	public int deleteEmpScheduler(SqlSession sqlSession, Scheduler scheduler) {
		int result = -1;
		int result1 = sqlSession.delete("Scheduler.deleteScheduler1", scheduler);
		System.out.println(result1);
		
		if(result1 >= 0) {
			return sqlSession.delete("Scheduler.deleteScheduler2", scheduler);
		}else {
			return result;
		}
		
		
	}

	@Override
	public int changeStatusN(SqlSession sqlSession, Scheduler scheduler) {
		int result = -1;
		int result1 = sqlSession.update("Scheduler.updateScStatusN", scheduler);
		System.out.println(result1);
		
		if(result1 >= 0) {
			return sqlSession.update("Scheduler.updateScrStatusN", scheduler);
		}else {
			return result;			
		}
		
	}

	@Override
	public int changeStatusY(SqlSession sqlSession, Scheduler scheduler) {
		int result = -1;
		int result1 = sqlSession.update("Scheduler.updateScStatusY", scheduler);
		System.out.println(result1);
		
		if(result1 >= 0) {
			return sqlSession.update("Scheduler.updateScrStatusY", scheduler);
		}else {
			return result;			
		}
	}

	@Override
	public int insertGroupScheduler(SqlSession sqlSession, Scheduler scheduler, List<String> setEmpList,
			List<String> readEmpList) {
		int result = -1;
		int result2 = 0;
		int result3 = 0;
		
		int result1 = sqlSession.insert("Scheduler.insertGscr", scheduler);
		if(result1 > 0) {
			for(int i = 0; i < setEmpList.size(); i++) {
				result2 += sqlSession.insert("Scheduler.insertGscrSetter", Integer.parseInt(setEmpList.get(i)));	
			}
			for(int i = 0; i < readEmpList.size(); i++) {
				result3 += sqlSession.insert("Scheduler.insertGscrReader", Integer.parseInt(readEmpList.get(i)));	
			}
			
			if(result2 == setEmpList.size() && result3 == readEmpList.size()) {
				result = 1;
				return result;
			}else {
				return result;
			}
		}else {
			return result;			
		}
		
		
	}

	@Override
	public int changeGscrStatusN(SqlSession sqlSession, Scheduler scheduler) {
		
		return sqlSession.update("Scheduler.updateGscrStatusN", scheduler);
	}

	@Override
	public int changeGscrStatusY(SqlSession sqlSession, Scheduler scheduler) {
		
		return sqlSession.update("Scheduler.updateGscrStatusY", scheduler);
	}

	@Override
	public HashMap<String, ArrayList<Object>> selectGMList(SqlSession sqlSession, int no) {
		HashMap<String, ArrayList<Object>> allGmList = new HashMap<String, ArrayList<Object>>();
		
		ArrayList<Object> setter = (ArrayList) sqlSession.selectList("Scheduler.selectSetter", no);
		System.out.println(setter);
		ArrayList<Object> reader = (ArrayList) sqlSession.selectList("Scheduler.selectReader", no);
		System.out.println(reader);
		
		allGmList.put("setter", setter);
		allGmList.put("reader", reader);
		
		return allGmList;
	}

	@Override
	public int updateGroupScheduler(SqlSession sqlSession, Scheduler scheduler, List<String> setEmpList,
			List<String> readEmpList) {
		int result = -1;
		int result2 = 0;
		int result3 = 0;
		
		int result1 = sqlSession.delete("Scheduler.deleteGMList", scheduler);
		if(result1 > 0) {
			for(int i = 0; i < setEmpList.size(); i++) {
				scheduler.setCreateEmpNo(Integer.parseInt(setEmpList.get(i)));
				result2 += sqlSession.insert("Scheduler.updateGscrSetter", scheduler);	
			}
			for(int i = 0; i < readEmpList.size(); i++) {
				scheduler.setCreateEmpNo(Integer.parseInt(readEmpList.get(i)));
				result3 += sqlSession.insert("Scheduler.updateGscrReader", scheduler);	
			}
			
			if(result2 == setEmpList.size() && result3 == readEmpList.size()) {
				result = 1;
				return result;
			}else {
				return result;
			}
		}else {
			return result;			
		}
		
	}

	@Override
	public int deleteGroupScheduler(SqlSession sqlSession, String schedulerNo) {
		Scheduler scheduler = new Scheduler();
		scheduler.setSchedulerNo(Integer.parseInt(schedulerNo));
		int result = 0;
		
		int result1 = sqlSession.delete("Scheduler.deleteGscList", Integer.parseInt(schedulerNo));
		
		int result2 = sqlSession.delete("Scheduler.deleteGMList", scheduler);
		
		if(result1 >= 0 && result2 >= 0) {
			return sqlSession.delete("Scheduler.deleteScheduler2", scheduler);
		}else {
			return result;
		}
		
	}

	

	

}





































