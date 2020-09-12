package com.mota.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte implements Serializable {
	
	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
	}

	public CompteCourant(Double soldeCompte, Date dateCreation, double decouvert) {
		super(soldeCompte, dateCreation);
		this.decouvert = decouvert;
	}
	
	

}
