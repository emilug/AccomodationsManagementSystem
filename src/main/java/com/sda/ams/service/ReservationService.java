package com.sda.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sda.ams.model.Reservation;
import com.sda.ams.repository.ReservationRepository;

public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> getAllReservations() {
		//return reservationRepository.loadReservations("./reservation.txt");
		return reservationRepository.findAll();
	}

	public Optional<Reservation> get(Integer id) {
		return reservationRepository.findById(id);
	}

	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	public void delete(Integer id) {
		Optional<Reservation> optionalReservation = get(id);
		if (optionalReservation.isPresent()) {
			reservationRepository.delete(optionalReservation.get());
		}
	}
}
