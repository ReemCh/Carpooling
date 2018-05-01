package com.essat.metier;

import java.util.List;

import com.essat.entities.Annonce;


public interface AnnonceMetier {
	public List<Annonce> getAllAnnonces();
    public Annonce getAnnonceById(Long id);
    public void deleteAnnonce(Long id);
	public void updateAnnonce(Annonce a,Long id);

}
