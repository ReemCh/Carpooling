package com.essat.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.essat.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query("select p from Reservation p where p.utilisateur.idUtilisateur=:id")
	public Page<Reservation> listeReservations(@Param("id")Long id,Pageable pageable);

}
