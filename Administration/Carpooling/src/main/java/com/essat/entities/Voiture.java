package com.essat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Voiture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	private String matricule;
	private String marque;
	private String modele;
	private int nombrePlaces;
	//private String imageVoiture;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Voiture(String matricule, String marque, String modele, int nombrePlaces) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.modele = modele;
		this.nombrePlaces = nombrePlaces;
		//this.imageVoiture = imageVoiture;
	}



	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	/*public String getImageVoiture() {
		return imageVoiture;
	}

	public void setImageVoiture(String imageVoiture) {
		this.imageVoiture = imageVoiture;
	}*/
	@JsonIgnore
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	@JsonSetter
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	

}
