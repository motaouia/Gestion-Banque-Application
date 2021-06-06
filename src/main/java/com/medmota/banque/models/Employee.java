package com.medmota.banque.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nameEmployee;
	
	@ManyToOne
	@JoinColumn(name = "XID_EMPLOYEE_SUP")
	private Employee employeeSup;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Compte> comptes;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Operation> operations;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "TAB_GRPS_EMPLS", joinColumns = { @JoinColumn(name = "ID_EMPLOYEE") }, inverseJoinColumns = {
			@JoinColumn(name = "XID_GROUPE") })
	private List<Groupe> groupes;

	public Employee() {
		super();
	}

	public Employee(String nameEmployee, Employee employeeSup) {
		super();
		this.nameEmployee = nameEmployee;
		this.employeeSup = employeeSup;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	@JsonIgnore
	public Employee getEmployeeSup() {
		return employeeSup;
	}

	@JsonSetter
	public void setEmployeeSup(Employee employeeSup) {
		this.employeeSup = employeeSup;
	}

	@JsonIgnore
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@JsonIgnore
	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@JsonIgnore
	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nameEmployee=" + nameEmployee + ", employeeSup=" + employeeSup + ", comptes="
				+ comptes + ", operations=" + operations + ", groupes=" + groupes + "]";
	}

}