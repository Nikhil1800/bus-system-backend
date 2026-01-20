package com.TrueFare.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TrueFare.model.Trip;
import com.TrueFare.repository.TripRepository;

@Controller
@RequestMapping("/trips")
public class TripSearchController {
	private final TripRepository triprepository;

	public TripSearchController(TripRepository triprepository) {
		this.triprepository = triprepository;
	}

	@GetMapping("/search")
	public List<Trip> searchTrips(@RequestParam String from, @RequestParam String to, @RequestParam String date)

	{
		return triprepository.findByRouteSourceAndRouteDestinationAndJourneyDate(to, date, LocalDate.parse(date));

	}

}
