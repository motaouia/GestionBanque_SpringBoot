package com.mota.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable {
	
	private double tauxInteret;

	public CompteEpargne() {
		super();
	}

	

	public CompteEpargne(Double soldeCompte, Date dateCreation, double tauxInteret) {
		super(soldeCompte, dateCreation);
		this.tauxInteret = tauxInteret;
	}



	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
	

}
