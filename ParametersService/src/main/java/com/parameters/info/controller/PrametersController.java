package com.parameters.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parameters.info.service.JDBCTemplateService;

@RestController
public class PrametersController {

	
	@Autowired
	private JDBCTemplateService jdbcTemplateService;
	
	
	@PostMapping(value = "/{name}")
	public ResponseEntity<HttpStatus>createTable(@PathVariable String name
			,@RequestBody ParametersPojo params){
			jdbcTemplateService.CreateTable(name, params);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	
	
	

}
