package com.transport.TransportCompany.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.TransportCompany.persistence.entities.Vehicle;
import com.transport.TransportCompany.persistence.repositiories.VehiclesRepository;

@Service
public class VehiclesService implements IService<Vehicle>{

	@Autowired
	private VehiclesRepository vehiclesRepo;

	@Override
	public List<Vehicle> GetAll() {
		return vehiclesRepo.findAll();
	}

	@Override
	public Vehicle GetById(Long id) {
		Optional<Vehicle> res = vehiclesRepo.findById(id);
		if (res.isPresent())
			return res.get();
		return null;
	}

	public Vehicle Create(Vehicle vehicle) {
		return vehiclesRepo.save(vehicle);
	}

	public void Delete(Vehicle vehicle) {
		vehiclesRepo.delete(vehicle);
	}
}
