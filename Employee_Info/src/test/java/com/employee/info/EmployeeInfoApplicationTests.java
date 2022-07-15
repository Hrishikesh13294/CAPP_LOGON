package com.employee.info;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.info.entity.Employee;
import com.employee.info.service.EmployeeService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@DataJpaTest
class EmployeeInfoApplicationTests {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	public Employee dummyEmp() throws Exception {
		return new Employee(1, 10102, "Hrishikesh Kulkarni", "kulkarni_hrishikesh@yahoo.com", "CDRG", "vf191", "test");
	}

	@Test
	public void getEmp() throws Exception {
		dummyEmp();
		Employee addEmployee = employeeService.addEmployee(dummyEmp());
		
		assertEquals(addEmployee.getTokenNo(), 10102);
	
	}
	
	
	@Test
	public void test2() throws Exception {
		
		dummyEmp();
		employeeService.deleteEmployee(dummyEmp().getId());
		
		assertNull(dummyEmp());
		
	}
	
	
	
	
	
	
	
	

}
