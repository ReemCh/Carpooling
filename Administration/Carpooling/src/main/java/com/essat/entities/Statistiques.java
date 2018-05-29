package com.essat.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Statistiques implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int NbInscrits;
	private int NbReservation;
	private int NbAnnonces;
	private int NbMessages;
	
	private int nbRecherche;
	public Statistiques() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getNbRecherche() {
		return nbRecherche;
	}



	public void setNbRecherche(int nbRecherche) {
		this.nbRecherche = nbRecherche;
	}



	public Statistiques( int nbInscrits, int nbReservation, int nbAnnonces, int nbMessages, int nbRecherche) {
		super();
		
		NbInscrits = nbInscrits;
		NbReservation = nbReservation;
		NbAnnonces = nbAnnonces;
		NbMessages = nbMessages;
		this.nbRecherche = nbRecherche;
	}

	public int getNbInscrits() {
		return NbInscrits;
	}
	public void setNbInscrits(int nbInscrits) {
		NbInscrits = nbInscrits;
	}
	public int getNbReservation() {
		return NbReservation;
	}
	public void setNbReservation(int nbReservation) {
		NbReservation = nbReservation;
	}
	public int getNbAnnonces() {
		return NbAnnonces;
	}
	public void setNbAnnonces(int nbAnnonces) {
		NbAnnonces = nbAnnonces;
	}
	public int getNbMessages() {
		return NbMessages;
	}
	public void setNbMessages(int nbMessages) {
		NbMessages = nbMessages;
	}
	
	

}
