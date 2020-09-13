package com.mota.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mota.banque.dao.EmployeeRepository;
import com.mota.banque.entities.Employee;


@Service
public class EmployeeMetierImpl implements EmployeeMetier {
	
	@Autowired
	private EmployeeRepository employeeRepositopry;
	
	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepositopry.save(employee);
		return employee;
	}

	@Override
	public List<Employee> listAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepositopry.findAll();
	}
	
	

}
