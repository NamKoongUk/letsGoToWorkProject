package com.kh.lgtw.scheduler.model.service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.lgtw.scheduler.model.vo.Schedule;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

public interface SchedulerService {
	int insertMemberScheduler(Scheduler sc);

  HashMap<String, ArrayList<Object>> allSelectSchedule(int empNo);

	int updateMemberScheduler();

	int deleteMemberScheduler();

	int insertGroupScheduler();

	int updateGroupScheduler();

	int deleteGroupScheduler();

	int insertSchedule(Schedule schedule);

	Schedule selectScheduleDetail();

	int updateSchedule();

	int deleteSchedule();
  
	ArrayList<Scheduler> selectSchedulerList(int empNo);

}
