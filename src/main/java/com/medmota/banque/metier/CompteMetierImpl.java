package com.medmota.banque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medmota.banque.dao.ICompteRepository;
import com.medmota.banque.models.Compte;

@Service
public class CompteMetierImpl implements ICompteMetier {

	@Autowired
	private ICompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte compte) {
		compte.setDateCreation(new Date());
		return compteRepository.save(compte);
	}

	@Override
	public List<Compte> listAllComptes() {
		return compteRepository.findAll();
	}

	@Override
	public Compte getCompteById(String codeCompte) {
		return compteRepository.findById(codeCompte).get();
	}

}
