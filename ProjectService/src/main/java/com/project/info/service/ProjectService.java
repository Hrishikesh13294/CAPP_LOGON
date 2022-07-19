package com.project.info.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.info.entity.Employee;
import com.project.info.entity.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao dao;
	
	@Autowired
	private RestTemplate restTemplate;

	public List<String> getAllProjectsNames() {

		List<String> lstProjName = new ArrayList<>();
		try {
			List<String> collect = dao.findAll().stream().map(x -> x.getProjectName()).collect(Collectors.toList());
			return lstProjName = collect;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lstProjName;

	}

	public ResponseEntity<List<Project>> getAllProjects() {

		try {
			List<Project> findAll = dao.findAll();
			return new ResponseEntity<List<Project>>(findAll, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
		}

	}
	
	public ResponseEntity<Project> getProject(int id) {

		try {
			Project project = dao.findById(id).get();
			return new ResponseEntity<Project>(project, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}

	}

	public ResponseEntity<Project> addProject(Project project) {

		try {
			Project save = dao.save(project);
			return new ResponseEntity<Project>(save, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
		}

	}

	public ResponseEntity<Project> updateProject(int id, Map<Object, Object> field) {

		
		try {
			Project optionalProject = dao.findById(id).get();
			field.forEach((key, Value) -> {
				Field findRequiredField = ReflectionUtils.findRequiredField(Project.class, (String) key);
				findRequiredField.setAccessible(true);
				ReflectionUtils.setField(findRequiredField, optionalProject, Value);
				dao.flush();

			});
			
			return new ResponseEntity<Project>(optionalProject,HttpStatus.ACCEPTED);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}

	}
	
	public ResponseEntity<HttpStatus> deleteById(int id){
		
		try {
			dao.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	public ResponseEntity<String> getProjectManagerName(int id){
		
		try {
			Project project = dao.findById(id).get();
			int TokenNo = project.getProjectManager();
			
			ResponseEntity<Employee> employeeObj = restTemplate.getForEntity("http://EMPLOYEE-SERVICE/employee/token/"+TokenNo, Employee.class);
			
			return new ResponseEntity<String>(employeeObj.getBody().getName().toString(), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		
	}
	
	public ResponseEntity<String> getDAEName(int id){
		
		try {
			Project project = dao.findById(id).get();
			int TokenNo = project.getRespDAE();
			
			ResponseEntity<Employee> employeeObj = restTemplate.getForEntity("http://EMPLOYEE-SERVICE/employee/token/"+TokenNo, Employee.class);
			
			return new ResponseEntity<String>(employeeObj.getBody().getName().toString(), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	
}
	public ResponseEntity<String> getRespWName(int id){
		
		try {
			Project project = dao.findById(id).get();
			int TokenNo = project.getRespW();
			
			ResponseEntity<Employee> employeeObj = restTemplate.getForEntity("http://EMPLOYEE-SERVICE/employee/token/"+TokenNo, Employee.class);
			
			return new ResponseEntity<String>(employeeObj.getBody().getName().toString(), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	
}

}
