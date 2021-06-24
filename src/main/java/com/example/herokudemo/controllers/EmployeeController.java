package com.example.herokudemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.herokudemo.models.Employee;
import com.example.herokudemo.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
}
