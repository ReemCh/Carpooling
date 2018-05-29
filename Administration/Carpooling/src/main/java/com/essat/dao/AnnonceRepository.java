package com.essat.dao;

import java.sql.*;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.essat.entities.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query("select p from Annonce p where p.utilisateur.idUtilisateur=:id")
	public Page<Annonce> listAnnonces(@Param("id")Long id,Pageable peageable);
	
	@Query("select p from Annonce p")
	public Page<Annonce> listAnnonces1(Pageable peageable);

	
	@Query("select r from Reservation p , Annonce r where p.annonce.idAnnonce=r.idAnnonce and p.utilisateur.idUtilisateur=:id ")
	public List<Annonce> getAnnoncesByIdRes(@Param("id") Long id,Pageable peageable);
	
	@Query("SELECT COUNT(c) FROM Annonce c where MONTH(c.dateTrajet)=:m")
	public int getNbAnnonces(@Param("m") int m);
	
	@Query("select p from Annonce p where p.dateTrajet >=:debut and p.dateTrajet <=:fin")
	public List<Annonce> rechAnnonces(@Param("debut")Date debut,@Param("fin") Date fin);
}
