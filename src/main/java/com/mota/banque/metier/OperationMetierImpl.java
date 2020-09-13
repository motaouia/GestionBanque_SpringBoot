package com.mota.banque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mota.banque.dao.CompteRepository;
import com.mota.banque.dao.EmployeeRepository;
import com.mota.banque.dao.OperationRepository;
import com.mota.banque.entities.Compte;
import com.mota.banque.entities.Employee;
import com.mota.banque.entities.Retrait;
import com.mota.banque.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public boolean verser(Long codeCpte, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(codeCpte);
		Employee emp = employeeRepository.getOne(codeEmp);
		if(cp != null && emp != null) {
			cp.setSoldeCompte(cp.getSoldeCompte() + montant);
			Versement vers = new Versement(new Date(), montant);
			vers.setEmployee(emp);
			vers.setCompte(cp);
			compteRepository.save(cp);
			operationRepository.save(vers);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean retrait(Long codeCpte, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(codeCpte);
		Employee emp = employeeRepository.getOne(codeEmp);
		if(cp != null && montant >= cp.getSoldeCompte() && emp != null) {
			cp.setSoldeCompte(cp.getSoldeCompte() - montant);
			Retrait vers = new Retrait(new Date(), montant);
			vers.setEmployee(emp);
			vers.setCompte(cp);
			operationRepository.save(vers);
			return true;
		}else if(montant < cp.getSoldeCompte()){
			throw new RuntimeException("Solde insuffisant");
		}else {
			return false;
		}
	}

	@Override
	public boolean virement(Long codeCpte1, Long codeCpte2, double montant, Long codeEmp) {
		this.retrait(codeCpte1, montant, codeEmp);
		this.verser(codeCpte2, montant, codeEmp);
		return true;
	}

}
