package com.transport.TransportCompany.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.TransportCompany.persistence.entities.Employee;
import com.transport.TransportCompany.persistence.repositiories.EmployeesRepository;

@Service
public class EmployeesService implements IService<Employee>{

	@Autowired
	private EmployeesRepository employeesRepo;

	@Override
	public List<Employee> GetAll() {
		return employeesRepo.findAll();
	}

	@Override
	public Employee GetById(Long id) {
		Optional<Employee> res = employeesRepo.findById(id);
		if (res.isPresent())
			return res.get();
		return null;
	}

	public Employee Create(Employee employee) {
		return employeesRepo.save(employee);
	}

	public void Delete(Employee employee) {
		employeesRepo.delete(employee);
	}
}
