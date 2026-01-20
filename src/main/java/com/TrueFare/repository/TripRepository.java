package com.TrueFare.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrueFare.model.Route;
import com.TrueFare.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

//	Abstract Method 

	List<Trip> findByRouteSourceAndRouteDestinationAndJourneyDate(String source, String destination,
			LocalDate journetDate);

}
