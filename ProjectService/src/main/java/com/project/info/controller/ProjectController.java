package com.project.info.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.info.entity.Project;
import com.project.info.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/")
	public List<String> getAllProjectsNames() {

		return projectService.getAllProjectsNames();

	}

	@GetMapping("/projects")
	public ResponseEntity<List<Project>> getAllProjects() {

		return projectService.getAllProjects();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Project> getProject(@PathVariable int id) {

		return projectService.getProject(id);

	}

	@PostMapping("/")
	public ResponseEntity<Project> addProject(@org.springframework.web.bind.annotation.RequestBody Project project) {

		return projectService.addProject(project);

	}

	@PatchMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable int id,
			@org.springframework.web.bind.annotation.RequestBody Map<Object, Object> field) {

		return projectService.updateProject(id, field);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable int id) {

		return projectService.deleteById(id);

	}

	@GetMapping("/projManager/{id}")
	public ResponseEntity<String> getProjectManagerName(@PathVariable int id) {

		return projectService.getProjectManagerName(id);

	}

	@GetMapping("/dae/{id}")
	public ResponseEntity<String> getDAEName(@PathVariable int id) {

		return projectService.getProjectManagerName(id);

	}

	@GetMapping("/w/{id}")
	public ResponseEntity<String> getRespWName(@PathVariable int id) {

		return projectService.getRespWName(id);
	}

}
