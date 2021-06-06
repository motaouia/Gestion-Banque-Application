package com.medmota.banque.metier;

import java.util.List;

import com.medmota.banque.models.Employee;

public interface IEmployeeMetier {

	public Employee saveEmployee(Employee employee);
	public List<Employee> listAllEmployee();
}
