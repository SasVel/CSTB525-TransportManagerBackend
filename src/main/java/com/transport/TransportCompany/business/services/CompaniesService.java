package com.transport.TransportCompany.business.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.TransportCompany.persistence.entities.Company;
import com.transport.TransportCompany.persistence.entities.Employee;
import com.transport.TransportCompany.persistence.entities.TransportInquiry;
import com.transport.TransportCompany.persistence.entities.Vehicle;
import com.transport.TransportCompany.persistence.repositiories.CompaniesRepository;
import com.transport.TransportCompany.persistence.repositiories.EmployeesRepository;
import com.transport.TransportCompany.persistence.repositiories.TransportInquiriesRepository;
import com.transport.TransportCompany.persistence.repositiories.VehiclesRepository;

@Service
public class CompaniesService implements IService<Company>{

	@Autowired
	private CompaniesRepository companiesRepo;

	@Autowired
	private EmployeesRepository employeesRepo;

	@Autowired
	private VehiclesRepository vehiclesRepo;

	@Autowired
	private TransportInquiriesRepository inquiriesRepo;

	@Override
	public List<Company> GetAll() {
		return companiesRepo.findAll();
	}

	@Override
	public Company GetById(Long id) {
		Optional<Company> res = companiesRepo.findById(id);
		if (res.isPresent())
			return res.get();
		return null;
	}

	public void Create(Company company)
	{
		companiesRepo.save(company);
	}

	public void Delete(Company company)
	{
		companiesRepo.delete(company);
	}

	public List<Employee> GetEmployees(Long companyId) {
		return employeesRepo.findAll()
			.stream()
			.filter(e -> Objects.equals(e.getCompany().getId(), companyId))
			.collect(Collectors.toList());
	}

	public List<Vehicle> GetVehicles(Long companyId) {
		return vehiclesRepo.findAll()
			.stream()
			.filter(e -> Objects.equals(e.getCompany().getId(), companyId))
			.collect(Collectors.toList());
	}
	public List<TransportInquiry> GetInquiries(Long companyId) {
		return inquiriesRepo.findAll()
			.stream()
			.filter(e -> Objects.equals(e.getCompany().getId(), companyId))
			.collect(Collectors.toList());
	}
}
