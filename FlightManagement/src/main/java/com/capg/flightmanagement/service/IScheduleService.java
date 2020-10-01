package com.capg.flightmanagement.service;

import java.util.List;

import com.capg.flightmanagement.models.Schedule;

public interface IScheduleService {

	Schedule addSchedule(Schedule schedule);
	Schedule fetchScheduleById(String scheduleId);
	List<Schedule> fetchAllSchedules();
	Schedule removeSchedule(String scheduleId);
	Schedule updateSchedule(Schedule schedule);
}
