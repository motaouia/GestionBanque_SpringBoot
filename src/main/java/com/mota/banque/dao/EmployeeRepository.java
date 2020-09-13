package com.mota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mota.banque.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
