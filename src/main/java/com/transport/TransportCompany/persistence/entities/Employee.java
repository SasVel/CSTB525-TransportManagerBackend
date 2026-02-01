package com.transport.TransportCompany.persistence.entities;

import java.math.BigDecimal;

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
import jakarta.validation.constraints.Pattern;
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
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")
    @Column(name = "name", nullable = false)
    private String name;

	@NotNull(message = "Salary cannot be null")
	@Positive(message = "Salary must be positive")
	@Digits(integer = 10, fraction = 2, message = "Salary must be a valid monetary amount")
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "FK_Company", nullable = false)
    private Company company;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "FK_Vehicle", nullable = true)
    private Vehicle vehicle;
}