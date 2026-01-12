package com.TrueFare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TrueFare.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//In interfaces 	methods have no body, only signature
	Optional<User> findByEmail(String email);
}
