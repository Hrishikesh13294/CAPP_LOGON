package com.parameters.info;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parameters.info.entity.parameter;
import com.parameters.info.service.Repo;

@SpringBootApplication
public class ParametersServiceApplication {
	@Autowired
	Repo repo;
	public static void main(String[] args) {
		SpringApplication.run(ParametersServiceApplication.class, args);

	}

	@PostConstruct
	public void postconstruct() {
		repo.save(new parameter(1,"TR-C4-V13VBN-00050",72.5,17.5,70,0));
	}

}
