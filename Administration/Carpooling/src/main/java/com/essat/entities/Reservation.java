package com.essat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	private Date dateReservation;
	
	@ManyToOne
	@JoinColumn(name="IdAnnonce")
	@JsonIgnore
	private Annonce annonce;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	@JsonIgnore
	private Utilisateur utilisateur;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date dateReservation) {
		super();
		this.dateReservation = dateReservation;
	}

	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
    @JsonIgnore
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
    @JsonSetter
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
}
