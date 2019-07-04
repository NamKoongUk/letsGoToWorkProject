package com.kh.lgtw.scheduler.model.dao;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.lgtw.scheduler.model.vo.Schedule;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

public interface SchedulerDao {

	int insertMemberScheduler(SqlSession sqlSession, Scheduler sc);

	ArrayList<Scheduler> selectSchedulerList(SqlSession sqlSession, int empNo);

	int insertSchedule(SqlSession sqlSession, Schedule schedule);

	HashMap<String, ArrayList<Object>> allSelectSchedule(SqlSession sqlSession, int empNo);

	Schedule selectScheduleDetail(SqlSession sqlSession, Schedule schedule);

	int deleteSchedule(SqlSession sqlSession, Schedule schedule);

	int updateSchedule(SqlSession sqlSession, Schedule schedule);

	int updateEmpScheduler(SqlSession sqlSession, Scheduler scheduler);

	int deleteEmpScheduler(SqlSession sqlSession, Scheduler scheduler);

	int changeStatusN(SqlSession sqlSession, Scheduler scheduler);

	int changeStatusY(SqlSession sqlSession, Scheduler scheduler);

	int insertGroupScheduler(SqlSession sqlSession, Scheduler scheduler, List<String> setEmpList,
			List<String> readEmpList);

	int changeGscrStatusN(SqlSession sqlSession, Scheduler scheduler);

	int changeGscrStatusY(SqlSession sqlSession, Scheduler scheduler);

	HashMap<String, ArrayList<Object>> selectGMList(SqlSession sqlSession, int no);

	int updateGroupScheduler(SqlSession sqlSession, Scheduler scheduler, List<String> setEmpList,
			List<String> readEmpList);

	int deleteGroupScheduler(SqlSession sqlSession, String schedulerNo);

	

	

}
