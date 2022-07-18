package com.project.info.controller;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.info.entity.Employee;
import com.project.info.entity.Project;
import com.project.info.service.ProjectRepo;

import net.bytebuddy.utility.privilege.GetMethodAction;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/")
	public String getDAEName(){
		
		Employee obj = restTemplate.getForObject("http://EMPLOYEE-SERVICE/employee/1", Employee.class);
		
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
