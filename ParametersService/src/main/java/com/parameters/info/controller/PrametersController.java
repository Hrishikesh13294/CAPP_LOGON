package com.parameters.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parameters.info.entity.parameter;
import com.parameters.info.service.Repo;

@RestController
@RequestMapping("/family")
public class PrametersController {
	@Autowired
	private Repo repo;

	@GetMapping("/{id}")
	public ResponseEntity<parameter> getArticle(@PathVariable int id) {
		parameter param = repo.findById(id).get();
		return new ResponseEntity<parameter>(param, HttpStatus.OK);

	}

}
