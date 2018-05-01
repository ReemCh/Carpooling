package com.essat.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essat.dao.AnnonceRepository;
import com.essat.entities.Annonce;

@Service
public class AnnonceMetierImpl implements AnnonceMetier {
	
	@Autowired
	private AnnonceRepository annonceRepository;

	@Override
	public List<Annonce> getAllAnnonces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annonce getAnnonceById(Long id) {
		
		
		
		return null;
	}

	@Override
	public void deleteAnnonce(Long id) {
		annonceRepository.delete(id);
		
	}

	@Override
	public void updateAnnonce(Annonce a, Long id) {
		// TODO Auto-generated method stub
		
	}

}
