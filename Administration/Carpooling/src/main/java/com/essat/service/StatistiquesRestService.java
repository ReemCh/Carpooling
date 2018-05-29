package com.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.essat.dao.StatistiquesRepository;
import com.essat.entities.Statistiques;

@RestController
public class StatistiquesRestService  {
	
	@Autowired
	private StatistiquesRepository statistiquesRepository;
	
	@RequestMapping(value="/statistiques",method=RequestMethod.GET)
	public Statistiques getStat() {
		
		return statistiquesRepository.getStat();
	}

}
