package com.project.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.info.entity.Project;
import com.project.info.service.ProjectRepo;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@RequestMapping("/addOrUpdate")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		Project proj = projectRepo.saveAndFlush(project);
		return new ResponseEntity<Project>(proj, HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
