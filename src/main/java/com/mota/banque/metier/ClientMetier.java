package com.mota.banque.metier;

import java.util.List;

import com.mota.banque.entities.Client;

public interface ClientMetier {
	
	public Client saveClient(Client client);
	public List<Client> listAllClients();

}
