package com.TrueFare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrueFare.model.Trip;
import com.TrueFare.repository.TripRepository;

@RestController
@RequestMapping("/admin/trip")
public class TripController {
	TripRepository triprepository;

	TripController(TripRepository triprepository) {
		this.triprepository = triprepository;
	}

//	add Trip Details (only by Admin)

	@PostMapping("/add")
	public String addTrip(@RequestBody Trip trip) {
		triprepository.save(trip);
		return "Trip Added Succesfully";
	}

//	add Trip Details (only by Admin)
	@GetMapping("/get")
	public List<Trip> getTrip() {
		return triprepository.findAll();
	}

}

//Admin should Able to add and view trips