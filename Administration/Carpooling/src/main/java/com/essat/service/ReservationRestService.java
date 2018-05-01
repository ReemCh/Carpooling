package com.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.essat.dao.ReservationRepository;
import com.essat.entities.Annonce;
import com.essat.entities.Reservation;
import com.essat.metier.ReservationMetier;

@RestController
public class ReservationRestService  {
	
	@Autowired
	private ReservationMetier reservationMetier;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@RequestMapping(value="/reservations",method=RequestMethod.GET)
	public Page<Reservation> lesAnnonces(Long id,@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam (name="size",defaultValue="4")int size) {
		
		return reservationRepository.listeReservations(id, new PageRequest(page, size));
	}
	
	

}
