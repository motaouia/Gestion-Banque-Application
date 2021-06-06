package com.medmota.banque.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "CC", value = CompteCourant.class), @Type(name = "CE", value = CompteEpargne.class) })
public abstract class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String codeCompte;

	private Date dateCreation;
	private double soldecompte;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XID_CLIENT")
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XID_EMPLOYEE")
	private Employee employee;

	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private List<Operation> operations;

	public Compte() {
		super();
	}

	public Compte(String codeCompte, Date dateCreation, double soldecompte) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.soldecompte = soldecompte;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}

	@JsonSetter
	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}

	@JsonSetter
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSoldecompte() {
		return soldecompte;
	}

	public void setSoldecompte(double soldecompte) {
		this.soldecompte = soldecompte;
	}

	@Override
	public String toString() {
		return "Compte [codeCompte=" + codeCompte + ", dateCreation=" + dateCreation + ", soldecompte=" + soldecompte
				+ ", client=" + client + ", operations=" + operations + "]";
	}

}
