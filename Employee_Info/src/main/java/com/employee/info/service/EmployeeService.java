package com.employee.info.service;

import java.security.Key;

import javax.crypto.Cipher;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.employee.info.dao.EmployeeDao;
import com.employee.info.entity.Employee;

@Service
public class EmployeeService {

	

	@Autowired
	private EmployeeDao employeeDao;

	public java.util.List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	public Employee getEmployee(int id) {
		try {
			return employeeDao.findById(id).get();

		} catch (NotFound e) {
			// TODO: handle exception
			return null;

		}

	}

	public Employee addEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	
}
