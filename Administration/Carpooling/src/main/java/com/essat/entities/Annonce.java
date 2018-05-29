package com.essat.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Annonce implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnnonce;
	private Date dateTrajet;
	private String lieuDepart;
	private String lieuArrivee;
	private double prix;
	private boolean fumeur;
	private boolean bagages;
	private boolean animaux;
	private int nbPlaces;
	private String gender;
	
	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	@JsonIgnore
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="annonce")
	private Collection<Reservation> reservations;

	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public boolean isFumeur() {
		return fumeur;
	}



	public void setFumeur(boolean fumeur) {
		this.fumeur = fumeur;
	}



	public boolean isBagages() {
		return bagages;
	}



	public void setBagages(boolean bagages) {
		this.bagages = bagages;
	}



	public boolean isAnimaux() {
		return animaux;
	}



	public void setAnimaux(boolean animaux) {
		this.animaux = animaux;
	}



	public int getNbPlaces() {
		return nbPlaces;
	}



	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Annonce(Date dateTrajet, String lieuDepart, String lieuArrivee, double prix) {
		super();
		this.dateTrajet = dateTrajet;
		this.lieuDepart = lieuDepart;
		this.lieuArrivee = lieuArrivee;
		this.prix = prix;
		//this.fumeur = fumeur;
	}

	public Long getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public Date getDateTrajet() {
		return dateTrajet;
	}

	public void setDateTrajet(Date dateTrajet) {
		this.dateTrajet = dateTrajet;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArrivee() {
		return lieuArrivee;
	}

	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	@JsonIgnore
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	@JsonSetter
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	 @JsonIgnore
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	 @JsonSetter
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	
	
	
	

}
