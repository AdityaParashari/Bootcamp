package com.cg.flightmgmt.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.model.Flight;

@Repository
public interface IFlightDao extends JpaRepository<Flight, BigInteger>{

}
