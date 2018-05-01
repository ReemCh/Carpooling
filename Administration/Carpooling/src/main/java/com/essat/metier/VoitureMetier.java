package com.essat.metier;

import java.util.List;

import com.essat.entities.Voiture;

public interface VoitureMetier {
	public List<Voiture> getAllVoitures();
	public Voiture getVoitureById(Long id);
	public Voiture getVoitureByIdUser(Long idUSer);

}
