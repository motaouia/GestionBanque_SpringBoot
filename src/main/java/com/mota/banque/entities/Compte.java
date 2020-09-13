package com.mota.banque.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING , length = 250)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(name = "CC", value = CompteCourant.class),
	@Type(name = "CE", value = CompteEpargne.class)
})
public abstract class Compte implements Serializable {
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompt;
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
	public Long getIdCompte() {
		return idCompt;
	}
	public void setIdCompte(Long idCompte) {
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
	@JsonIgnore
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
}