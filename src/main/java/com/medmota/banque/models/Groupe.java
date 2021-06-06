package com.medmota.banque.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPES")
public class Groupe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameGroupe;
	@ManyToMany(mappedBy = "groupes")
	private List<Employee> employees;

	public Groupe() {
		super();
	}

	public Groupe(String nameGroupe) {
		super();
		this.nameGroupe = nameGroupe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameGroupe() {
		return nameGroupe;
	}

	public void setNameGroupe(String nameGroupe) {
		this.nameGroupe = nameGroupe;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nameGroupe=" + nameGroupe + ", employees=" + employees + "]";
	}

}
