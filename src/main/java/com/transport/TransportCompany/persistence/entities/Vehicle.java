package com.transport.TransportCompany.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotEmpty(message = "Model cannot be empty")
	@Max(value = 50, message = "Model cannot exceed 50 characters")
    @Column(name = "model", nullable = false)
    private String model;

	@NotNull(message = "Capacity cannot be null")
	@Positive(message = "Capacity must be positive")
    @Column(name = "capacity", nullable = false)
    private short capacity;
	
	@NotNull(message = "Max load amount cannot be null")
	@Positive(message = "Max load amount must be positive")
    @Column(name = "max_load_kg", nullable = false)
    private int maxLoadKG;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "FK_vehicle_type")
    private VehicleType vehicleType;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "FK_Company", nullable = false)
    private Company company;
}