package com.capg.airportandschedulemgmt.exceptions;

public class AirportNotFoundException extends RuntimeException{
	public AirportNotFoundException(String msg) {
		super(msg);
	}
}
