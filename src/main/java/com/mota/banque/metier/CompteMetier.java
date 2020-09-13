package com.mota.banque.metier;

import java.util.List;

import com.mota.banque.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte compte);
	public Compte getCompteById(Long codeCompte);

}
