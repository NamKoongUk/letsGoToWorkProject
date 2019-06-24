package com.kh.lgtw.scheduler.model.dao;

import java.sql.Array;
import java.util.ArrayList;
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

	

}
