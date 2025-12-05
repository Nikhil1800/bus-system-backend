package com.TrueFare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.TrueFare.dto.LoginRequest;
import com.TrueFare.dto.SignupRequest;
import com.TrueFare.model.User;
import com.TrueFare.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String signup(SignupRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());

		// Encrypt password before saving
		String encryptedPassword = passwordEncoder.encode(request.getPassword());
		user.setPassword(encryptedPassword);

		userRepository.save(user);
		return "User Regerstered.";
	}

//	REVIEW ----------->>>>>>
	public String login(LoginRequest request) {
		// Get user by email
		User user = userRepository.findByEmail(request.getEmail());

		// If no user found
		if (user == null) {
			return "User not found";
		}

		//  Compare raw password with encrypted password
		boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
		if (!isPasswordMatch) {
			return "Invalid password";
		}

		return "Login successful";
	}

}
