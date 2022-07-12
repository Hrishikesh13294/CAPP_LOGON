package com.employee.info.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.info.entity.Employee;
import com.employee.info.entity.EmployeePublic;
import com.employee.info.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<List<EmployeePublic>> getAllEmployees() {
		List<EmployeePublic> lstOfEmployeePublics = employeeService.getAllEmployee().stream()
				.map(t -> new EmployeePublic(t.getId(), t.getTokenNo(), t.getName(), t.getEmail(), t.getDepartment()))
				.collect(Collectors.toList());
		try {
			return new ResponseEntity<List<EmployeePublic>>(lstOfEmployeePublics, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeePublic> getEmployee(@PathVariable int id) {
		try {
			Employee employee = employeeService.getEmployee(id);
			return new ResponseEntity<EmployeePublic>(new EmployeePublic(employee.getId(), employee.getTokenNo(),
					employee.getName(), employee.getEmail(), employee.getDepartment()), HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<EmployeePublic> addEmployee(@RequestBody Employee employee) {

		try {
			employeeService.addEmployee(employee);
			return new ResponseEntity<EmployeePublic>(new EmployeePublic(employee.getId(), employee.getTokenNo(),
					employee.getName(), employee.getEmail(), employee.getDepartment()), HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

}
