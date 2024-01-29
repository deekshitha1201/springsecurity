package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;

@Service
public class EmployeeserImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public Employee addrecord(Employee employee) {
		return emprepo.save(employee);
	}

}
