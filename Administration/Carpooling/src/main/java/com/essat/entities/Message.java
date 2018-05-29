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
public class Message implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessage;
	private String contenu;
	private Date dateMessage;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	@JsonIgnore
	private Utilisateur utilisateur;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String contenu, Date dateMessage) {
		super();
		this.contenu = contenu;
		this.dateMessage = dateMessage;
	}
   
	public long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
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
