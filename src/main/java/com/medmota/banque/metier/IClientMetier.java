package com.medmota.banque.metier;

import java.util.List;

import com.medmota.banque.models.Client;

public interface IClientMetier {

	public Client saveClient(Client client);
	public List<Client> listAllClients();
}
