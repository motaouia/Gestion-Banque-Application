package com.medmota.banque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medmota.banque.metier.IOperationMetier;

@RestController
public class OperationRestService {

	@Autowired
	private IOperationMetier operationMetier;

	@RequestMapping(value = "/verser", method = RequestMethod.PUT)
	public boolean verser(@RequestParam String cdCpte, @RequestParam double montant, @RequestParam Long cdEmpl) {
		return operationMetier.verser(cdCpte, montant, cdEmpl);
	}

	@RequestMapping(value = "/retrait", method = RequestMethod.POST)
	public boolean retrait(@RequestParam String cdCpte, @RequestParam double montant, @RequestParam Long cdEmpl) {
		return operationMetier.retrait(cdCpte, montant, cdEmpl);
	}

	@RequestMapping(value = "/virement", method = RequestMethod.POST)
	public boolean virement(@RequestParam String cdCpte1, @RequestParam String cdCpte2, @RequestParam double montant,
			Long cdEmpl) {
		return operationMetier.virement(cdCpte1, cdCpte2, montant, cdEmpl);
	}

}
