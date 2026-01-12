package com.TrueFare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrueFare.model.Route;
import com.TrueFare.repository.RouteRepository;

@RestController
@RequestMapping("/admin/route")
public class RouteController {
	private final RouteRepository routerepository;

	RouteController(RouteRepository routerepository) {
		this.routerepository = routerepository;
	}

//	Add Route

	@PostMapping("/add")
	public String addRoute(@RequestBody Route route) {

		routerepository.save(route);
		return "Route added succesfully";
	}

//	View Route 
	@GetMapping("/list")
	public List<Route> getRoute() {
		return routerepository.findAll();

	}
}
