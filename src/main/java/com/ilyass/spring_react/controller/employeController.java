package com.ilyass.spring_react.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ilyass.spring_react.dto.employeDto;
import com.ilyass.spring_react.service.employeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class employeController {
	private employeService employeeService;
	
 public employeController(employeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

@PostMapping
 public ResponseEntity<employeDto> createEmployee (@RequestBody employeDto emp){
	 return new ResponseEntity<employeDto>(employeeService.createEmploye(emp),HttpStatus.CREATED);
 }
 @GetMapping("{id}")
 public ResponseEntity<employeDto> getEmployeeById(@PathVariable("id") int empId){
 	return new ResponseEntity<employeDto>(employeeService.getEmployeeById(empId), HttpStatus.OK);
 }
 @GetMapping
 public List<employeDto> getAllEmployees(){
	 return employeeService.getAllEmployees();
 }
 @PutMapping("/{id}")
 public ResponseEntity<employeDto> updateEmployee(@PathVariable("id") int empId ,@RequestBody employeDto emp ) {
	 return new ResponseEntity<employeDto>(employeeService.updateEmployee(empId, emp),HttpStatus.OK);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteEmployee(@PathVariable("id") int empId){
	 employeeService.deleteEmployee(empId);
	 return new ResponseEntity<String>("DELETED SUCCEFULY",HttpStatus.OK);
 }
}
