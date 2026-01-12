package com.TrueFare.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.TrueFare.model.Bus;
import com.TrueFare.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService {

	private final BusRepository busRepository;

	BusServiceImpl(BusRepository busrepository) {
		this.busRepository = busrepository;
	}

	@Override
	public Bus getBusById(Long id) {

		Optional<Bus> optionalBus = busRepository.findById(id);

		if (optionalBus.isPresent()) {
			return optionalBus.get();
		} else {
			throw new RuntimeException("Bus not found with id: " + id);
		}
	}

}
