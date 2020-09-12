package com.mota.banque.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGroup;
	private String nomGroup;
	@ManyToMany(mappedBy = "groupes")
	private List<Employee> employees;
	
	public Groupe() {
		super();
	}
	public Groupe(String nomGroup) {
		super();
		this.nomGroup = nomGroup;
	}
	public Long getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}
	public String getNomGroup() {
		return nomGroup;
	}
	public void setNomGroup(String nomGroup) {
		this.nomGroup = nomGroup;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	
}