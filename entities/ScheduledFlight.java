package com.flight_management.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flightschedule_table")
public class ScheduledFlight {
	
	
	@OneToOne
	@JoinColumn(name="flight")
	private Flight flight;
	
	@Column(name="availableSeats")
	private int availableSeats;
	
	@OneToOne
	@JoinColumn(name="schedule")
	private Schedule schedule;
	
	
	
	public ScheduledFlight() {
		super();
	}

	public ScheduledFlight( Flight flight, int availableSeats, Schedule schedule) {
		super();
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	

	@Override
	public String toString() {
		return "ScheduledFlight [ flight=" + flight + ", availableSeats="
				+ availableSeats + ", schedule=" + schedule + "]";
	}
	
	
}

