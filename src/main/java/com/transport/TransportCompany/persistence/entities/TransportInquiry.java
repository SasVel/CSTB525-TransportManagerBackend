package com.transport.TransportCompany.persistence.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
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
@Table(name = "transport_inquiries")
public class TransportInquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotEmpty(message = "Origin address cannot be empty")
    @Column(name = "origin_address", nullable = false)
    private String originAddress;

	@NotEmpty(message = "Destination address cannot be empty")
    @Column(name = "destination_address", nullable = false)
    private String destinationAddress;

	@NotNull(message = "Departure date cannot be null")
    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

	@NotNull(message = "Arrival date cannot be null")
    @Column(name = "arrival_date", nullable = false)
    private Date arrivalDate;

	@NotNull(message = "Cost cannot be null")
	@Positive(message = "Cost must be positive")
    @Column(name = "cost", nullable = false)
    private double cost;

	@NotNull(message = "Cargo amount cannot be null")
    @Column(name = "cargo_amount", nullable = false)
    private double cargoAmount;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "FK_Company", nullable = false)
    private Company company;
}