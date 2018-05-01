package com.essat.metier;

import java.util.List;

import com.essat.entities.Utilisateur;

public interface UtilisateurMetier {
	
	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur getUtilisateurById(Long id);
	public void deleteUtilisateur(Long id);
	public void updateUtilisateur(Utilisateur u,Long id);
	

}
