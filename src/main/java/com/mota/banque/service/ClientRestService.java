package com.mota.banque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mota.banque.entities.Client;
import com.mota.banque.metier.ClientMetier;

@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;
	
	
	@RequestMapping(value = "/clients", method =RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}
	
	@RequestMapping(value = "/clients", method =RequestMethod.GET)
	public List<Client> listAllClients() {
		return clientMetier.listAllClients();
	}
	
	

}
