package com.transport.TransportCompany.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transport.TransportCompany.business.services.CompaniesService;
import com.transport.TransportCompany.persistence.entities.Company;
import com.transport.TransportCompany.persistence.entities.Employee;

@RestController
public class CompaniesController {
	private final String baseMapping = "/companies";
	@Autowired
	private CompaniesService companiesService;

	@GetMapping(baseMapping)
	public List<Company> GetCompanies()
	{
		return companiesService.GetAll();
	}

	@GetMapping(baseMapping + "/{id}")
	public Company GetCompanyById(@PathVariable("id") Long id)
	{
		return companiesService.GetById(id);
	}

	@GetMapping(baseMapping + "/{id}" + "/employees")
	public List<Employee> GetEmployees(@PathVariable("id") Long id)
	{
		return companiesService.GetEmployees(id);
	}

	@PostMapping(path = baseMapping,
   		consumes = MediaType.APPLICATION_JSON_VALUE,
   		produces = MediaType.APPLICATION_JSON_VALUE)
	public void CreateCompany(@RequestBody Company company)
	{
		companiesService.Create(company);
	}

	@DeleteMapping(path = baseMapping,
   		consumes = MediaType.APPLICATION_JSON_VALUE,
   		produces = MediaType.APPLICATION_JSON_VALUE)
	public void DeleteCompany(@RequestBody Company company)
	{
		companiesService.Delete(company);
	}
}
