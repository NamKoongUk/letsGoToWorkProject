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

	int updateEmpScheduler(Scheduler scheduler);

	int deleteEmpScheduler(Scheduler scheduler);

	int insertGroupScheduler(Scheduler scr, List<String> setEmpList, List<String> readEmpList);

	int updateGroupScheduler();

	int deleteGroupScheduler();

	int insertSchedule(Schedule schedule);

	Schedule selectScheduleDetail(Schedule schedule);

	int updateSchedule(Schedule schedule);
  
	ArrayList<Scheduler> selectSchedulerList(int empNo);

	int deleteSchedule(Schedule schedule);

	int changeStatusN(Scheduler scheduler);

	int changeStatusY(Scheduler scheduler);


}
