package com.employee.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice.This;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@Transactional
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long tokenNo;
	private String name;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE)
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
		this.password = PasswordEncryptDecrypt.encrypt(password);
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
