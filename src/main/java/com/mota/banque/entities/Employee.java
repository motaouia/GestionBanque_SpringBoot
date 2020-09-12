package com.mota.banque.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmployee;
	private String nameEmployee;
	
	@ManyToMany
	@JoinTable(name = "EMP_GRP")
	private List<Groupe> groupes;
	
	
	@ManyToOne
	@JoinColumn(name = "code_emp_sup")
	private Employee emplyeSup;
	
	/*@OneToMany
	@JoinColumn(name = "employee")
	private List<Operation> operations;*/

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	/*
	
	
*/
	/*public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}*/

	public Long getIdEmployee() {
		return idEmployee;
	}
	
	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

}
