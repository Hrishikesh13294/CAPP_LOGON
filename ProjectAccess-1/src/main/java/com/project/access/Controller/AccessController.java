package com.project.access.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.access.Entity.AccessEntity;

@RestController
@RequestMapping("/access")
public class AccessController {
	@Autowired
	private com.project.access.Service.Repository repository;
	
	@GetMapping("/")
	public java.util.List<AccessEntity> getall(){
		return repository.findAll();
	}
	
	

}
