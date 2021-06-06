package com.medmota.banque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medmota.banque.metier.ICompteMetier;
import com.medmota.banque.models.Compte;

@RestController
public class CompteRestService {

	@Autowired
	private ICompteMetier compteMetier;

	/* Example of Request SaveCompte: Post, 
	 * { "codeCompte":"CC047", "type":"CC", "soldecompte": 5800.90, "decouvert":
	 * 6000, "client": { "codeClient": 2 }, "employee": { "id":12 } }
	 */
	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}

	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte> listAllComptes() {
		return compteMetier.listAllComptes();
	}

	@RequestMapping(value = "/comptes/{id}", method = RequestMethod.GET)
	public Compte getCompteById(@PathVariable(name = "id") String code) {
		return compteMetier.getCompteById(code);
	}
}
