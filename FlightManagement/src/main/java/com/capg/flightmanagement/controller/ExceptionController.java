package com.capg.flightmanagement.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.flightmanagement.dto.ExceptionResponse;
import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.exceptions.ScheduleNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	private static final Logger Log = LoggerFactory.getLogger(AirportController.class);
	
	/**
	 * Handling AirportNotFoundException,ScheduleNotFound
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = {AirportNotFoundException.class,ScheduleNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleNotFoundException(Exception ex, HttpServletRequest request) {
		Log.error("Not Found Exception",ex);
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	
	/**
	 * Handling Exceptions
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleOtherException(Exception ex, HttpServletRequest request) {
		Log.error("Not Found Exception",ex);
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	

}
