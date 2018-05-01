package com.essat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.essat.dao.UtilisateurRepository;
import com.essat.entities.Utilisateur;
import com.essat.metier.UtilisateurMetier;

@RestController
public class UtilisateurRestService {
	
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	/*@RequestMapping(value="/utilisateurs",method=RequestMethod.GET)
	public List<Utilisateur> listeEmploye() {
		return utilisateurMetier.getAllUtilisateurs();
	}
	*/
	@RequestMapping(value="/utilisateurs",method=RequestMethod.GET)
	public Page<Utilisateur> users(@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam (name="size",defaultValue="2")int size){
		return utilisateurRepository.findAll(new PageRequest(page, size));
		
	}
	
	@RequestMapping(value="/utilisateurs/{id}",method=RequestMethod.GET)
	public Utilisateur getUser(@PathVariable Long id) {
		return utilisateurMetier.getUtilisateurById(id);
		
	}
	
	
	@RequestMapping(value="/utilisateurs/{id}",method=RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		utilisateurMetier.deleteUtilisateur(id);
		
	}
	
	@RequestMapping(value="/utilisateurs/{id}",method=RequestMethod.PUT)
	public void updateUtilisateur(@RequestBody Utilisateur u,@PathVariable ("id") Long id) {
		utilisateurMetier.updateUtilisateur(u, id);
	}
	
	@RequestMapping(value="/utilisateurs",method=RequestMethod.POST)
	public Utilisateur ajoutUtilisateur(@RequestBody Utilisateur u) {
		return utilisateurRepository.save(u);
	}

}
