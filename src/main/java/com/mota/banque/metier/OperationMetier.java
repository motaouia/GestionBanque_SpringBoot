package com.mota.banque.metier;

public interface OperationMetier {
	
	public boolean verser(Long codeCpte, double montant, Long codeEmp);
	public boolean retrait(Long codeCpte, double montant, Long codeEmp);
	public boolean virement(Long codeCpte1, Long codeCpte2,double montant, Long codeEmp);

}