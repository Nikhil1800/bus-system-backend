package com.TrueFare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrueFare.model.Bus;
import com.TrueFare.model.Role;
import com.TrueFare.model.User;
import com.TrueFare.repository.BusRepository;
import com.TrueFare.service.BusService;

//This class will add the bus data. and only Admin can do this.
@RestController
@RequestMapping("/admin/bus")
public class BusController {
	private final BusRepository busrepository;

	public BusController(BusRepository busrepository) {
		this.busrepository = busrepository;
	}

//	@PostMapping("/add")
//	public String addBus(@RequestBody Bus bus, User loggedInUser) {
//
//		if (loggedInUser.getRole() != Role.ADMIN) {
//			throw new RuntimeException("Access Denied :only Admin can access this");
//		}
//		busrepository.save(bus);
//		return "Bus added Succesfully";
//	}

	@PostMapping("/add")
	public String addBus(@RequestBody Bus bus) {

		busrepository.save(bus);
		return "Bus added Succesfully";
	}

//	Get Bus List (Only Admin)
	@GetMapping("/list")
	public List<Bus> getAllBus() {
		return busrepository.findAll();
	}

//	Get Bus List with Id (Only admin)
	@GetMapping("/{id}")
	public Bus getById(@PathVariable Long id) {
		return busrepository.findById(id).orElseThrow(() -> new RuntimeException("Bus not found"));
	}
}
