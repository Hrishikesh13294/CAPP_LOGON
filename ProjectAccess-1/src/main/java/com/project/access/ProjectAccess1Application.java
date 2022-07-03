package com.project.access;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.access.Entity.AccessEntity;
import com.project.access.Enumeration.Access;
import com.project.access.Service.Repository;

@SpringBootApplication
public class ProjectAccess1Application {
	@Autowired
	Repository repository;
	public static void main(String[] args) {
		SpringApplication.run(ProjectAccess1Application.class, args);
	}
	
	
	@PostConstruct
	public void postconstruct() {
		AccessEntity accessEntity = new AccessEntity(10102,Access.DESIGNER);
		repository.save(accessEntity);
		System.out.println(accessEntity.getAccess());
	}

}
