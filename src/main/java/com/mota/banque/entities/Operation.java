package com.mota.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Operation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperation;
	private Date dateOperation;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name ="CODE_CPTE")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name ="CODE_EMPLOYEE")
	private Employee employee;
	
	public Operation() {
	}
	public Operation(Date dateOperation, double montant) {
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	
	public Long getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Compte getCompte() {
		return compte;
	}
	
	
	

}
