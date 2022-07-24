package com.parameters.info.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrametersController {

	
	@Autowired
	private JdbcTemplate service;
	
	
	@RequestMapping("/{name}")
	public ResponseEntity<HttpStatus>createTable(@PathVariable String name){
		Optional<List<String>> str = Optional.of(new ArrayList<String>(Arrays.asList("PREIP","DDC","DCON","ALDS")));
		Optional<List<String>> str1 = Optional.of(new ArrayList<String>());
		Optional<List<String>> str2 = Optional.of(new ArrayList<String>());
		StringBuilder sqlBuilder = new StringBuilder();
		if(str.isPresent())
		for (String string : str.get()) {
			sqlBuilder.append(string + " DECIMAL,");
		}
		
		if(str1.isPresent())
			for (String string : str1.get()) {
				sqlBuilder.append(string + " INTEGER,");
			}
		if(str2.isPresent())
			for (String string : str2.get()) {
				sqlBuilder.append(string + " BIT,");
			}
		String sql = "CREATE TABLE "+name.toString()+" ( ID INTEGER, STANDARDCODE VARCHAR(255), " +sqlBuilder.toString() +" PRIMARY KEY(ID))"; 
		service.execute(sql);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
