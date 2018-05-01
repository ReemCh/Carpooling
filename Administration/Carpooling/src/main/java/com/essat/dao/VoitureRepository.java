package com.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essat.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
