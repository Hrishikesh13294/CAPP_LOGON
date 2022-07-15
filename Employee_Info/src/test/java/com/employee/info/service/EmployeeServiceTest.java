package com.employee.info.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.info.entity.Employee;
import com.employee.info.service.EmployeeService;
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@DataJpaTest
class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	void test() throws Exception {
		Employee employee = new Employee(1, 10102L, "Hrishikesh Kulkarni", "kulkarni_hrishikesh@yahoo.com", "CDRG", "vf191", "test");
	
		Employee addEmployee = employeeService.addEmployee(employee);
		
		assertEquals(addEmployee.getTokenNo(), 10102L);
	
	
	}

}
