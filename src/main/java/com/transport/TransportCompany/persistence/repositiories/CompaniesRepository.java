package com.transport.TransportCompany.persistence.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.TransportCompany.persistence.entities.Company;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Long>{

}
