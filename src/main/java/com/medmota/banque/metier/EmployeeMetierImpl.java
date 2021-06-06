package com.medmota.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medmota.banque.dao.IEmployeeRepository;
import com.medmota.banque.models.Employee;

@Service
public class EmployeeMetierImpl implements IEmployeeMetier {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listAllEmployee() {
		return employeeRepository.findAll();
	}

}
