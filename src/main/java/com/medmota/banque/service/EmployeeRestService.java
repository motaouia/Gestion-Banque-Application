package com.medmota.banque.service;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medmota.banque.metier.IEmployeeMetier;
import com.medmota.banque.models.Employee;

@RestController
public class EmployeeRestService {
	

	@Autowired
	private IEmployeeMetier employeeMetier;

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getNameEmployee());
		return employeeMetier.saveEmployee(employee);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> listAllEmployees() {
		return employeeMetier.listAllEmployee();
	}
}
