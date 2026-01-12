package com.TrueFare.service;

import com.TrueFare.model.Bus;

public interface BusService {
//	Abstract Method
	public abstract Bus getBusById(Long Id);
}

//We create a service interface to define a clear
//contract for business logic, enabling loose coupling, 
//easy testing, and flexible implementations.**
