package com.essat.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.essat.entities.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query("select p from Annonce p where p.utilisateur.idUtilisateur=:id")
	public Page<Annonce> listAnnonces(@Param("id")Long id,Pageable peageable);

}
