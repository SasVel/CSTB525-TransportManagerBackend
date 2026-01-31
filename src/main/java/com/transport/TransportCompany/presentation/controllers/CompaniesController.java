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
import com.transport.TransportCompany.business.services.EmployeesService;
import com.transport.TransportCompany.business.services.TransportInquiriesService;
import com.transport.TransportCompany.business.services.VehiclesService;
import com.transport.TransportCompany.persistence.entities.Company;
import com.transport.TransportCompany.persistence.entities.Employee;
import com.transport.TransportCompany.persistence.entities.TransportInquiry;
import com.transport.TransportCompany.persistence.entities.Vehicle;

@RestController
public class CompaniesController {
	private final String baseMapping = "/companies";
	@Autowired
	private CompaniesService companiesService;

	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private VehiclesService vehiclesService;

	@Autowired
	private TransportInquiriesService inquiriesService;

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

	@PostMapping(baseMapping + "/{id}" + "/employees")
	public List<Employee> PostEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)
	{
		Company company = companiesService.GetById(id);
		employee.setCompany(company); 
		employeesService.Create(employee);
		return companiesService.GetEmployees(id);
	}

	@GetMapping(baseMapping + "/{id}" + "/vehicles")
	public List<Vehicle> GetVehicles(@PathVariable("id") Long id)
	{
		return companiesService.GetVehicles(id);
	}

	@PostMapping(baseMapping + "/{id}" + "/vehicles")
	public Vehicle PostVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle)
	{
		Company company = companiesService.GetById(id);
		vehicle.setCompany(company); 
		vehiclesService.Create(vehicle);
		return vehicle;
	}

	@GetMapping(baseMapping + "/{id}" + "/inquiries")
	public List<TransportInquiry> GetInquiries(@PathVariable("id") Long id)
	{
		return companiesService.GetInquiries(id);
	}

	@PostMapping(baseMapping + "/{id}" + "/inquiries")
	public TransportInquiry PostInquiry(@PathVariable("id") Long id, @RequestBody TransportInquiry inquiry)
	{
		Company company = companiesService.GetById(id);
		//inquiry.setCompany(company); 
		inquiriesService.Create(inquiry);
		return inquiry;
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
