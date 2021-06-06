package com.medmota.banque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medmota.banque.dao.ICompteRepository;
import com.medmota.banque.dao.IEmployeeRepository;
import com.medmota.banque.dao.IOperationRepository;
import com.medmota.banque.models.Compte;
import com.medmota.banque.models.Operation;
import com.medmota.banque.models.Retrait;
import com.medmota.banque.models.Versement;

@Service
public class OperationMetierImpl implements IOperationMetier {

	@Autowired
	private IOperationRepository operationRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	@Transactional
	public boolean verser(String cdCpte, double montant, Long cdEmpl) {
		
		Compte cp = compteRepository.findById(cdCpte).get();
		cp.setSoldecompte(cp.getSoldecompte() + montant);
		
		Operation op = new Versement();
		op.setDateOperation(new Date());
		op.setMontant(montant);
		op.setEmployee(employeeRepository.findById(cdEmpl).get());
		op.setCompte(cp);
		
		operationRepository.save(op);
		compteRepository.save(cp);
		
		return true;
	}

	@Override
	@Transactional
	public boolean retrait(String cdCpte, double montant, Long cdEmpl) {
		Compte cp = compteRepository.findById(cdCpte).get();
		if(montant <= cp.getSoldecompte()) {
			cp.setSoldecompte(cp.getSoldecompte() - montant);
			
			Operation op = new Retrait();
			op.setDateOperation(new Date());
			op.setMontant(montant);
			op.setEmployee(employeeRepository.findById(cdEmpl).get());
			op.setCompte(cp);
			
			operationRepository.save(op);
			compteRepository.save(cp);
			return true;
		}
		else {
			throw new RuntimeException("Désolé, Solde insuffisant!!");
		}
	}

	@Override
	@Transactional
	public boolean virement(String cdCpte1, String cdCpte2, double montant, Long cdEmpl) {
		this.retrait(cdCpte1, montant, cdEmpl);
		this.verser(cdCpte2, montant, cdEmpl);
		return true;
	}

}
