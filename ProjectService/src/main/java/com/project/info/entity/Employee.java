package com.project.info.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.context.annotation.Bean;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Employee {

	private int id;

	private long tokenNo;
	private String name;
	private String email;
	private String department;
	private String username;
	private String password;

	public Employee(int id, long tokenNo, String name,
			@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE) String email,
			String department, String username, String password) throws Exception {
		super();
		this.id = id;
		this.tokenNo = tokenNo;
		this.name = name;
		this.email = email;
		this.department = department;
		this.username = username;
		this.password = password;
	}

	public Employee(int id, long tokenNo, String name,
			@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE) String email,
			String department) throws Exception {
		super();
		this.id = id;
		this.tokenNo = tokenNo;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	@Bean
	public Employee publicEmployee() throws Exception {
		return new Employee(this.getId(), this.getTokenNo(), this.getName(), this.getEmail(), this.getDepartment());
	}

}
