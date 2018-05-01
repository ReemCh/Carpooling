package com.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essat.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
