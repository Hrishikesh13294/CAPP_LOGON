package com.employee.info.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.info.entity.Employee;
import com.employee.info.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> lstOfEmployeePublics = employeeService.getAllEmployee().stream().map(t -> {
			try {
				return t.publicEmployee();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return t;
		}).collect(Collectors.toList());
		try {
			return new ResponseEntity<List<Employee>>(lstOfEmployeePublics, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		try {
			Employee publicEmployee = employeeService.getEmployee(id).publicEmployee();
			return new ResponseEntity<Employee>(publicEmployee, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/token/{tokenNo}")
	public ResponseEntity<Employee> getEmployeeByTokenNo(@PathVariable long tokenNo) {
		try {
			Employee publicEmployee = employeeService.getEmployeeByTokenNo(tokenNo);//.publicEmployee();
			return new ResponseEntity<Employee>(publicEmployee, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		try {
			Employee addEmployee = employeeService.addEmployee(employee);
			return new ResponseEntity<Employee>(addEmployee.publicEmployee(), HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
		try {

			employeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Map<Object, Object> properties) throws NotFoundException{
		
		Optional<Employee> employee = Optional.of(employeeService.getEmployee(id));
		
		if(employee.isPresent()) {
			properties.forEach((key,Value)->{
			java.lang.reflect.Field reqField = org.springframework.data.util.ReflectionUtils.findRequiredField(Employee.class, (String)key);
			reqField.setAccessible(true);
			ReflectionUtils.setField(reqField, employee.get(), Value);
					
			}
					);
			return new ResponseEntity<>(employeeService.saveAndFlush(employee.get()), HttpStatus.OK);
			
			
			
		}
		
		else {
			throw new  NotFoundException();
		}
		
		
		
		
	}

}
