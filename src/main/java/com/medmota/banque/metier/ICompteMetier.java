package com.medmota.banque.metier;

import java.util.List;

import com.medmota.banque.models.Compte;

public interface ICompteMetier {
	
	public Compte saveCompte(Compte compte);
	public Compte getCompteById(String codeCompte);
	public List<Compte> listAllComptes();
}
