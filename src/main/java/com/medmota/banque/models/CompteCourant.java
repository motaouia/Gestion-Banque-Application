package com.medmota.banque.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CC")
public class CompteCourant extends Compte implements Serializable {

	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String codeCompte, Date dateCreation, double soldecompte, double decouvert) {
		super(codeCompte, dateCreation, soldecompte);
		this.decouvert = decouvert;
	}

	
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}