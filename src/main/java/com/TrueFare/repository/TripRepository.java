package com.TrueFare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrueFare.model.Route;
import com.TrueFare.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
