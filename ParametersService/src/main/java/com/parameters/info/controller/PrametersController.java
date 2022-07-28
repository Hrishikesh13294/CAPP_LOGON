package com.parameters.info.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parameters.info.service.JDBCTemplateService;

@RestController
public class PrametersController {

	
	@Autowired
	private JDBCTemplateService jdbcTemplateService;
	
	
	@PostMapping(value = "/{name}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces  = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<HttpStatus>createTable(@PathVariable String name
			,@RequestBody ParametersPojo params){
			jdbcTemplateService.CreateTable(name, params);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/test1")
	public ParametersPojo test1(@RequestBody ParametersPojo t1) {
		t1.getIntParams().get().forEach(x->System.out.println(x));
		return t1;
		
	}
	@GetMapping(value = "/get")
	public ParametersPojo test2() {
		Optional<List<String>> asList =Optional.of(Arrays.asList("DDC","TRE")) ;
		Optional<List<String>> asList1 =Optional.of(Arrays.asList("DDC1","TRE1")) ;
		Optional<List<String>> asList2 =Optional.of(Arrays.asList("DDC2","TRE2")) ;
		return new ParametersPojo(asList, asList1, asList2);
		
	}
	
	
	
	

}
