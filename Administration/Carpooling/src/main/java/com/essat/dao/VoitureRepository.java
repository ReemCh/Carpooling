package com.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.essat.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
	
	@Query("select p from Voiture p where p.utilisateur.idUtilisateur=:id")
	List<Voiture> voitures(@Param("id")Long id);

}
