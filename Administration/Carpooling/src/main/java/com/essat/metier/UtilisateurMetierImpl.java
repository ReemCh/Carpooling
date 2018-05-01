package com.essat.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essat.dao.UtilisateurRepository;
import com.essat.entities.Utilisateur;

@Service
public class UtilisateurMetierImpl implements UtilisateurMetier {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur getUtilisateurById(Long id) {
		Utilisateur u=utilisateurRepository.findOne(id);
		if(u == null) throw new RuntimeException("Utilisateur inexistant !");
		return u;
	}

	@Override
	public void deleteUtilisateur(Long id) {
		 utilisateurRepository.delete(id);
		
	}

	@Override
	public void updateUtilisateur(Utilisateur u, Long id) {
		u.setIdUtilisateur(id);
		utilisateurRepository.saveAndFlush(u);
		
		
	}

}
