package com.capg.flightmanagement.exceptions;

public class AirportAlreadyExistException extends RuntimeException{
	public AirportAlreadyExistException(String msg) {
		super(msg);
	}

}
