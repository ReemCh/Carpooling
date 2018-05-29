package com.essat.service;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.essat.dao.AnnonceRepository;
import com.essat.entities.Annonce;
import com.essat.metier.AnnonceMetier;

@RestController
public class AnnonceRestService {
	
	@Autowired
	private AnnonceMetier AnnonceMetier;
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	@RequestMapping(value="/annonces",method=RequestMethod.GET)
	public Page<Annonce> lesAnnonces(Long id,@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam (name="size",defaultValue="4")int size) {
		
		return annonceRepository.listAnnonces(id, new PageRequest(page, size));
	}
	
	@RequestMapping(value="/tousAnnonces",method=RequestMethod.GET)
	public Page<Annonce> lesAnnonces(@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam (name="size",defaultValue="4")int size) {
		
		return annonceRepository.listAnnonces1(new PageRequest(page, size));
	}

	
	
	@RequestMapping(value="/annoncesRes",method=RequestMethod.GET)
	public List<Annonce> annoncesByIsReservation(Long id,@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam (name="size",defaultValue="4")int size){
		
		return annonceRepository.getAnnoncesByIdRes(id,new PageRequest(page, size));
	}
	
	@RequestMapping(value="/annoncesMois",method=RequestMethod.GET)
	public int getAnnoncesParM(int m) {
		return annonceRepository.getNbAnnonces(m);
	}
	
	
	@RequestMapping(value="/rechAnnonces",method=RequestMethod.GET)
	public List<Annonce> RechAnnonces(Date debut,Date fin){
		return annonceRepository.rechAnnonces(debut, fin);
	}
	
	
}
