package com.essat.metier;

import java.util.List;

import com.essat.entities.Reservation;



public interface ReservationMetier {
	public List<Reservation> getAllReservations();
	//public List<Reservation> getAllReservationsByIdUser(Long id);
    public Reservation getReservationById(Long id);
    public void deleteReservation(Long id);
	public void updateAnnonce(Reservation a,Long id);
}
