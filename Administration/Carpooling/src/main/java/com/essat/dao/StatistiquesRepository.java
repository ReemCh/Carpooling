package com.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.essat.entities.Statistiques;

public interface StatistiquesRepository extends JpaRepository<Statistiques,Long>{
	
	@Query("select p from Statistiques p")
	public Statistiques getStat();
	
	
	

}
