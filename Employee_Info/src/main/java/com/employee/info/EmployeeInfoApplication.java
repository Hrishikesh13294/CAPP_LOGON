package com.employee.info;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.employee.info.entity.Employee;
import com.employee.info.entity.PasswordEncryptDecrypt;
import com.employee.info.service.EmployeeService;

@SpringBootApplication
public class EmployeeInfoApplication {
	
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeInfoApplication.class, args);
	}
	
	@PostConstruct
	public void dummyEmpl() throws Exception {
		Employee emp = new Employee(1, 10102, "Hrishikesh Kulkarni", "kulkarni_hrishikesh@yahoo.com", "CDRG", "vf191", "test");
		employeeService.addEmployee(emp);
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
