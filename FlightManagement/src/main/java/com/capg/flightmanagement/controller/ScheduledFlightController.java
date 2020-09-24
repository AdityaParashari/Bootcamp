package com.capgemini.flightmanagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Airport;
import com.capgemini.flightmanagement.entity.ScheduledFlight;
import com.capgemini.flightmanagement.exception.FlightScheduleNotFoundException;
import com.capgemini.flightmanagement.service.IAirportService;
import com.capgemini.flightmanagement.service.IScheduledFlightService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/flightSchedule")
public class ScheduledFlightController {
	
	
	@Autowired
	private IScheduledFlightService flightScheduleServive;
		
	@Autowired
	private IAirportService airportService;

	@PostMapping(path="/add")
	public String add(@RequestBody ScheduledFlight flightSchedule)throws FlightScheduleNotFoundException
	{
		if(flightSchedule.getScheduleFlightId()==0||flightSchedule.getFlight().getFlightNumber()==null||flightSchedule.getSchedule().getArrivalTime()==null||flightSchedule.getSchedule().getDepartureTime()==null||flightSchedule.getSchedule().getSourceAirport()==null||flightSchedule.getSchedule().getDestinationAirport()==null ) {
			throw new FlightScheduleNotFoundException();
		}
		
		String validate=flightScheduleServive.validateScheduledFlight(flightSchedule);
		
		if("valid data".equals(validate)) {
			
			
			flightScheduleServive.scheduleFlight(flightSchedule);
			validate="Added successfully";
		}
		
		
		return validate;
		
	}
	
	@GetMapping("/viewByAirport")
	public List<ScheduledFlight> getFlightOnDate(@RequestParam("source")String source,@RequestParam("destination") String destination,@RequestParam("date")String Date)throws FlightScheduleNotFoundException{
		
		if(source==null||destination==null||Date==null) {
			throw new FlightScheduleNotFoundException();
		}
		
		Airport airport1=airportService.viewAirport(source).get();
		Airport airport2=airportService.viewAirport(destination).get();
		LocalDate date=LocalDate.parse(Date);
		
		if(date.compareTo(LocalDate.now())<1) {
			throw new FlightScheduleNotFoundException();
		}
		
		List<ScheduledFlight> FlightScheduleList=flightScheduleServive.viewScheduledFlights(airport1,airport2,date);
		
		if(FlightScheduleList.isEmpty()) {
			throw new FlightScheduleNotFoundException();
		}
		
		return FlightScheduleList;
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) throws FlightScheduleNotFoundException {
		
		Optional<ScheduledFlight> flightScheduleOpt=flightScheduleServive.viewScheduledFlights(id);
		
		if(!flightScheduleOpt.isPresent()) {
			throw new FlightScheduleNotFoundException();
		}
		
		
		
		flightScheduleServive.deleteScheduledFlight(id);
		
		return "Deleted succesfully";
	}
	
	@PostMapping("/update")
	public String update(@RequestBody ScheduledFlight flightSchedule) {
		
		flightScheduleServive.modifyScheduledFlight(flightSchedule);
		
		return "updated";
		
	}
	@GetMapping("/viewById")
	public ScheduledFlight getFlightScheduleById(@RequestParam("id")int id) throws FlightScheduleNotFoundException{
		
		Optional<ScheduledFlight> flightScheduleOpt=flightScheduleServive.viewScheduledFlights(id);
		
		if(!flightScheduleOpt.isPresent()) {
			throw new FlightScheduleNotFoundException();
		}
		
		ScheduledFlight flightSchedule=flightScheduleOpt.get();
		
		return flightSchedule;
	}
	
	@GetMapping("/viewAll")
	public List<ScheduledFlight> viewAll(){
		List<ScheduledFlight> flightScheduleList=flightScheduleServive.viewScheduledFlights();
		return flightScheduleList;
	}
	
}

