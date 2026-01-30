package com.transport.TransportCompany.persistence.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.TransportCompany.persistence.entities.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long>{

}
