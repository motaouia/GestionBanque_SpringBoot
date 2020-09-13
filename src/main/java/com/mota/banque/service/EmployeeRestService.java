package com.mota.banque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mota.banque.entities.Employee;
import com.mota.banque.metier.EmployeeMetier;

@RestController
public class EmployeeRestService {
	
	@Autowired
	private EmployeeMetier employeeMetier;
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeMetier.addEmployee(employee);
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> listAllEmployees() {
		return employeeMetier.listAllEmployees();
	}
	
	

}
