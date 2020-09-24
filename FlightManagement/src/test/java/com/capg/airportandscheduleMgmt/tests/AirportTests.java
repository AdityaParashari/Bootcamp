package com.capg.airportandscheduleMgmt.tests;


import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.service.AirportServiceImpl;
import com.capg.flightmanagement.service.IAirportService;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(AirportServiceImpl.class)
class AirportTests {
	
	@Autowired
	IAirportService airportService;

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void fetchAirport_1() {

	}
	
	@Test
	public void fetchAirport_2() {
		Executable executable = () -> airportService.fetchAirportById("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
	
	@Test
	public void deleteAirport_1() {
		
	}
	
	@Test public void deleteAirport_2() {
		Executable executable = () -> airportService.removeAirport("S46");
		Assertions.assertThrows(AirportNotFoundException.class, executable);
	}
}
