package com.mota.banque.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING , length = 250)
public abstract class Compte implements Serializable {
	@Id
	@Column(length=175) 
	private String idCompt;
	private Double soldeCompte;
	private Date dateCreation;
	
	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "CODE_EMPLOYEE")
	private Employee employee;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;
	
	public Compte() {
	}
	public Compte(Double soldeCompte, Date dateCreation) {
		this.soldeCompte = soldeCompte;
		this.dateCreation = dateCreation;
	}
	public String getIdCompte() {
		return idCompt;
	}
	public void setIdCompte(String idCompte) {
		this.idCompt = idCompte;
	}
	public Double getSoldeCompte() {
		return soldeCompte;
	}
	public void setSoldeCompte(Double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
}