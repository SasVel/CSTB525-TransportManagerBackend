package com.transport.TransportCompany.persistence.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.TransportCompany.persistence.entities.Vehicle;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicle, Long>{

}
