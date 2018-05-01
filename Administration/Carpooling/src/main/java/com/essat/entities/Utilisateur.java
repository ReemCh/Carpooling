package com.essat.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private int cin;
	//private Date dateDeNaissance;
	//private String email;
	private String username;
	private String upassword;
	/*private Long telephone;
	private String photo;*/
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Voiture> voiture;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Annonce> annonce;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Message> message;
	
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)
	private Collection<Reservation> reservation;
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(String nom, String prenom, int cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
	}
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUpassword() {
		return upassword;
	}


	public void setUpassword(String password) {
		this.upassword = password;
	}


	public Long getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getCin() {
		return cin;
	}


	public void setCin(int cin) {
		this.cin = cin;
	}

	//@JsonIgnore
	public Collection<Voiture> getVoiture() {
		return voiture;
	}


	public void setVoiture(Collection<Voiture> voiture) {
		this.voiture = voiture;
	}

	@JsonIgnore
	public Collection<Annonce> getAnnonce() {
		return annonce;
	}

	@JsonSetter
	public void setAnnonce(Collection<Annonce> annonce) {
		this.annonce = annonce;
	}

	@JsonIgnore
	public Collection<Message> getMessage() {
		return message;
	}

	@JsonSetter
	public void setMessage(Collection<Message> message) {
		this.message = message;
	}

	//@JsonIgnore
	public Collection<Reservation> getReservation() {
		return reservation;
	}

	@JsonSetter
	public void setReservation(Collection<Reservation> reservation) {
		this.reservation = reservation;
	} 
	
	
	

}
