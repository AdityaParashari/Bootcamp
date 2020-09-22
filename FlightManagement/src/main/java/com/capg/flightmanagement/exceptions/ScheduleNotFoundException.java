package com.capg.airportandschedulemgmt.exceptions;

public class ScheduleNotFoundException extends RuntimeException{
	public ScheduleNotFoundException(String msg) {
		super(msg);
	}
}
