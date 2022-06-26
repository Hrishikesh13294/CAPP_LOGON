package com.employee.info.controller;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.info.entity.Employee;
import com.employee.info.service.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/addOrUpdate", method = { RequestMethod.POST, RequestMethod.PUT })
	public String addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "added successfully";
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET, RequestMethod.HEAD, RequestMethod.PATCH })
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id, @RequestBody Map<Object, Object> field) {

		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent() && RequestMethod.PATCH != null) {

			field.forEach((key, Value) -> {
				Field findRequiredField = ReflectionUtils.findRequiredField(Employee.class, (String) key);
				findRequiredField.setAccessible(true);
				ReflectionUtils.setField(findRequiredField, emp.get(), Value);

			});
			Employee saveAndFlush = employeeRepository.saveAndFlush(emp.get());
			return new ResponseEntity<>(saveAndFlush, HttpStatus.OK);

		} else

			return new ResponseEntity<>(employeeRepository.findById(id).orElse(null), HttpStatus.OK);
	}

}
