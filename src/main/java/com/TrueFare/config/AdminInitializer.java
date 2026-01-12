package com.TrueFare.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.TrueFare.model.Role;
import com.TrueFare.model.User;
import com.TrueFare.repository.UserRepository;

@Configuration
public class AdminInitializer {
	@Bean
	CommandLineRunner createAdmin(UserRepository userrepository) {
		return args ->{
//			Check if admin already exists
			if(userrepository.findByEmail("ajay18@truefare.com").isEmpty()) {
				User admin=new User();
				admin.setEmail("ajay18@truefare.com");
				admin.setPassword("Admin@123#");
				admin.setRole(Role.ADMIN);
				
				userrepository.save(admin);
				System.out.println("Admin created Succesfully :)");
			}
		};

	}
}

