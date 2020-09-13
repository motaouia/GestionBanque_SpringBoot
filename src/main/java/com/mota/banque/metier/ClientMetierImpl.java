package com.mota.banque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mota.banque.dao.ClientRepository;
import com.mota.banque.entities.Client;

@Service
public class ClientMetierImpl implements ClientMetier{
	
	@Autowired
	private ClientRepository clientRepo;
	@Override
	public Client saveClient(Client client) {
		clientRepo.save(client);
		return client;
	}

	@Override
	public List<Client> listAllClients() {
		List<Client> clients = clientRepo.findAll();
		return clients;
	}

}
