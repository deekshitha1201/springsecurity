package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Employee;
import com.example.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empser;
	@PostMapping("/datastored")
	public ResponseEntity<Employee> savedata(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(empser.addrecord(employee),HttpStatus.CREATED);
	}

}
