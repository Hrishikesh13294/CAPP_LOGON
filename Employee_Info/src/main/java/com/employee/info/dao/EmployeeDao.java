package com.employee.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.info.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	
	
	

}
