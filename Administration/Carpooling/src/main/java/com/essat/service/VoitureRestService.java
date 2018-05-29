package com.essat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.essat.dao.VoitureRepository;
import com.essat.entities.Voiture;

@RestController
public class VoitureRestService {

	@Autowired
	private VoitureRepository voitureRepository;
	
	@RequestMapping(value="/voitures",method=RequestMethod.GET)
	public List<Voiture> listVoitures(Long id){
		return voitureRepository.voitures(id);
	}
	
	
}
