package com.mota.banque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mota.banque.metier.OperationMetier;

@RestController
public class OperationServiceRest {
	
	@Autowired
	private OperationMetier operationMetier;
	
	@RequestMapping(value = "/versement", method = RequestMethod.PUT)
	//Put == update comte
	public boolean verser(
			@RequestParam Long codeCpte, 
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return operationMetier.verser(codeCpte, montant, codeEmp);
	}
	
	@RequestMapping(value = "/retrait", method = RequestMethod.PUT)
	public boolean retrait(
			@RequestParam Long codeCpte, 
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return operationMetier.retrait(codeCpte, montant, codeEmp);
	}
	
	@RequestMapping(value = "/virement", method = RequestMethod.PUT)
	public boolean virement(
			@RequestParam Long codeCpte1, 
			@RequestParam Long codeCpte2, 
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return operationMetier.virement(codeCpte1, codeCpte2, montant, codeEmp);
	}

}
