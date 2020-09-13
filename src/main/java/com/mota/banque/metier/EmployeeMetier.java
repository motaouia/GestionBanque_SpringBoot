package com.mota.banque.metier;

import java.util.List;

import com.mota.banque.entities.Employee;

public interface EmployeeMetier {
	
	public Employee addEmployee(Employee employee);
	public List<Employee> listAllEmployees();

}
