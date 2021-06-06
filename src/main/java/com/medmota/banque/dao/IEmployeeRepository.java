package com.medmota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medmota.banque.models.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

}
