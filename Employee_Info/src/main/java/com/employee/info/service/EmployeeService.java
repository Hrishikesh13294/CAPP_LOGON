package com.employee.info.service;

import java.security.Key;

import javax.crypto.Cipher;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.employee.info.dao.EmployeeDao;
import com.employee.info.entity.Employee;
import com.employee.info.entity.PasswordEncryptDecrypt;

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
	
	
	public Employee getEmployeeByTokenNo(long tokenNo) {
		try {
			return employeeDao.findByTokenNo(tokenNo);

		} catch (NotFound e) {
			// TODO: handle exception
			return null;

		}

	}

	public Employee addEmployee(Employee employee) throws Exception {
		
		Employee emp = new Employee();
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setTokenNo(employee.getTokenNo());
		emp.setUsername(employee.getUsername());
		emp.setDepartment(employee.getDepartment());
		emp.setPassword(PasswordEncryptDecrypt.encrypt(employee.getPassword()));
		emp.setEmail(employee.getEmail());
		
		return employeeDao.save(emp);
	}
	
	public void deleteEmployee(int id) {
		employeeDao.deleteById(id);
	}
	
	public Employee saveAndFlush(Employee emp) {
		return employeeDao.saveAndFlush(emp);
	}

	
}
