package com.transport.TransportCompany.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.transport.TransportCompany.business.services.ClientsService;
import com.transport.TransportCompany.persistence.entities.Client;

@RestController
public class ClientsController {
	@Autowired
	private ClientsService clientsService;

	@GetMapping("/clients")
	public List<Client> GetClients()
	{
		return clientsService.GetAll();
	}

	@GetMapping("/clients/{id}")
	public Client GetClientById(@PathVariable("id") long id)
	{
		return clientsService.GetById(id);
	}

}
