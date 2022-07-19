package com.project.info;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.project.info.entity.Project;
import com.project.info.service.ProjectDao;

@SpringBootApplication
public class ProjectServiceApplication1 {
	
	@Autowired
	public ProjectDao projectRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication1.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@PostConstruct
	public void init() {
		projectRepo.save(new Project(1, "M267", 1010, 4789, 7893, 1478));
	}


}
