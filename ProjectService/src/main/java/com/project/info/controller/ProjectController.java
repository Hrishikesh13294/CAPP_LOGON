package com.project.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.info.service.ProjectRepo;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/")
	public String getDAEName(){
		
		com.employee.info.entity.Employee obj = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/1", com.employee.info.entity.Employee.class);
		
		return "the employee name is "+obj.getName();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@RequestMapping(value = "/addOrUpdate", method = { RequestMethod.POST, RequestMethod.PUT })
//	public ResponseEntity<Project> addProject(@RequestBody Project project) {
//		Project proj = projectRepo.saveAndFlush(project);
//		return new ResponseEntity<Project>(proj, HttpStatus.OK);
//
//	}
//
//	@RequestMapping(value = "/{id}", method = { RequestMethod.GET, RequestMethod.HEAD, RequestMethod.PATCH })
//	public ResponseEntity<Project> getProject(@PathVariable int id, @RequestBody(required = false) Map<Object, Object> field) {
//
//		Optional<Project> projct = projectRepo.findById(id);
//
//		if (projct.isPresent() && RequestMethod.PATCH==null) {
//
//			field.forEach((key, value) -> {
//				Field findRequiredField = ReflectionUtils.findRequiredField(Project.class, (String) key);
//				findRequiredField.setAccessible(true);
//				ReflectionUtils.setField(findRequiredField, projct.get(), value);
//
//			});
//
//			Project saveAndFlush = projectRepo.saveAndFlush(projct.get());
//
//			return new ResponseEntity<Project>(saveAndFlush,HttpStatus.OK);
//
//		} else {
//			return new ResponseEntity<Project>(projectRepo.findById(id).get(), HttpStatus.OK);
//		}
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	

}
