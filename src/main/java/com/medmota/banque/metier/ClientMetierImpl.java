package com.medmota.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medmota.banque.dao.IClientRepository;
import com.medmota.banque.models.Client;

@Service
public class ClientMetierImpl implements IClientMetier {

	@Autowired
	private IClientRepository clientRepository;
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> listAllClients() {
		return clientRepository.findAll();
	}

}