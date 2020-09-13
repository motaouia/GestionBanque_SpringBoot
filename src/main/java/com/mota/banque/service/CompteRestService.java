package com.mota.banque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mota.banque.entities.Compte;
import com.mota.banque.metier.CompteMetier;

@RestController
public class CompteRestService {
	
	@Autowired
	private CompteMetier compteMetier;
	
	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}
	
	@RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
	public Compte getCompteById(@PathVariable Long codeCompte) {
		return compteMetier.getCompteById(codeCompte);
	}

}