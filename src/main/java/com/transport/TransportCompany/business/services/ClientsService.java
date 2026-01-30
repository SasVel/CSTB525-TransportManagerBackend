package com.transport.TransportCompany.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.TransportCompany.persistence.entities.Client;
import com.transport.TransportCompany.persistence.repositiories.ClientsRepository;

@Service
public class ClientsService implements IService<Client>{

	@Autowired
	private ClientsRepository clientsRepo;

	@Override
	public List<Client> GetAll() {
		return clientsRepo.findAll();
	}

	@Override
	public Client GetById(Long id) {
		Optional<Client> res = clientsRepo.findById(id);
		if (res.isPresent())
			return res.get();
		return null;
	}

}
