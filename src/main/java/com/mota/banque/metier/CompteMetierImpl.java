package com.mota.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mota.banque.dao.CompteRepository;
import com.mota.banque.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public Compte saveCompte(Compte compte) {
		return compteRepository.save(compte);
	}

	@Override
	public Compte getCompteById(Long codeCompte) {
		return compteRepository.getOne(codeCompte);
	}

}