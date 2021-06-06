package com.medmota.banque.metier;

public interface IOperationMetier {
	
	public boolean verser(String cdCpte, double montant, Long cdEmpl);
	public boolean retrait(String cdCpte, double montant, Long cdEmpl);
	public boolean virement(String cdCpte1, String cdCpte2, double montant, Long cdEmpl);

}
