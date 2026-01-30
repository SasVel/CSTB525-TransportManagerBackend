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

import com.transport.TransportCompany.business.services.EmployeesService;
import com.transport.TransportCompany.persistence.entities.Employee;

@RestController
public class EmployeesController{
	private final String baseMapping = "/employees";
	@Autowired
	private EmployeesService employeesService;

	@GetMapping(baseMapping)
	public List<Employee> GetEmployees()
	{
		return employeesService.GetAll();
	}

	@GetMapping("/employees/{id}")
	public Employee GetEmployeeById(@PathVariable("id") long id)
	{
		return employeesService.GetById(id);
	}

	@PostMapping(path = baseMapping,
   		consumes = MediaType.APPLICATION_JSON_VALUE,
   		produces = MediaType.APPLICATION_JSON_VALUE)
	public void CreateEmployee(@RequestBody Employee employee)
	{
		employeesService.Create(employee);
	}

	@DeleteMapping(path = baseMapping + "/{id}",
   		consumes = MediaType.APPLICATION_JSON_VALUE,
   		produces = MediaType.APPLICATION_JSON_VALUE)
	public void DeleteEmployee(@PathVariable("id") Long id)
	{
		Employee res = employeesService.GetById(id);
		employeesService.Delete(res);
	}
}
