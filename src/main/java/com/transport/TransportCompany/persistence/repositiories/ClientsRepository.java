package com.transport.TransportCompany.persistence.repositiories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.TransportCompany.persistence.entities.Client;

public interface ClientsRepository extends JpaRepository<Client, BigInteger>{

}
