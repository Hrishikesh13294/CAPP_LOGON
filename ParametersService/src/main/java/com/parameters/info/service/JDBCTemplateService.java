package com.parameters.info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.parameters.info.controller.ParametersPojo;

@Service
public class JDBCTemplateService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void CreateTable(String ProjectName, ParametersPojo params) {
		
		StringBuilder sqlBuilder = new StringBuilder();
		if(params.getDoubleParams().isPresent())
			for (String string : params.getDoubleParams().get()) {
				sqlBuilder.append(string + " DECIMAL,");
			}
			
			if(params.getIntParams().isPresent())
				for (String string : params.getIntParams().get()) {
					sqlBuilder.append(string + " INTEGER,");
				}
			if(params.getBooleanParams().isPresent())
				for (String string : params.getBooleanParams().get()) {
					sqlBuilder.append(string + " BIT,");
				}
			String sql = "CREATE TABLE "+ProjectName.toString()+" ( ID INTEGER, STANDARDCODE VARCHAR(255), " +sqlBuilder.toString() +" PRIMARY KEY(ID))"; 
			System.out.println(sql);
			jdbcTemplate.execute(sql);
	}
	
	
	

}
