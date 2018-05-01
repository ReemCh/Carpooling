package com.essat.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essat.dao.ReservationRepository;
import com.essat.entities.Reservation;

@Service
public class ReservationMetierImpl implements ReservationMetier {
	
	@Autowired
	private ReservationRepository reservationRespository;

	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getReservationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservation(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAnnonce(Reservation a, Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
