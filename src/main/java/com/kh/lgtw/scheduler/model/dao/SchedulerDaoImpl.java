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
		System.out.println("Dao 조회 후 : " + list);
		
		return list;
	}

	@Override
	public int insertSchedule(SqlSession sqlSession, Schedule schedule) {
		System.out.println(schedule);
		return sqlSession.insert("Scheduler.insertSchedule", schedule);
	}

	@Override
	public HashMap<String, ArrayList<Object>> allSelectSchedule(SqlSession sqlSession, int empNo) {
		HashMap<String, ArrayList<Object>> allList = new HashMap<String, ArrayList<Object>>();
		
		Scheduler scr = new Scheduler();
		Schedule sc = new Schedule();
		
//		scr.setCreateEmpNo(empNo);
//		sc.setWriter(empNo);
		
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
		System.out.println("다오 진입 : " + schedule);
		return sqlSession.selectOne("Scheduler.selectScheduleDetail", schedule);
	}

	

	

}





































