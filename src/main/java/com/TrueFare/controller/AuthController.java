package com.TrueFare.controller;

import com.TrueFare.dto.LoginRequest;
import com.TrueFare.dto.SignupRequest;
import com.TrueFare.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

	@Autowired
	private AuthService authservice;

	@PostMapping("/signup")
	public String signup(@RequestBody SignupRequest request) {
		return authservice.signup(request);
	}

	// LOGIN API
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return authservice.login(request);
	}

}
