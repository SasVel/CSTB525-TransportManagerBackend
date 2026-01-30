package com.transport.TransportCompany.persistence.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(name = "origin_address", nullable = false)
    private String originAddress;

    @Column(name = "destination_address", nullable = false)
    private String destinationAddress;

    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @Column(name = "arrival_date", nullable = false)
    private Date arrivalDate;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "cargo_amount", nullable = false)
    private double cargoAmount;
}