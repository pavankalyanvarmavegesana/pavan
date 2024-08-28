package com.SpringMiniProject.SpringMiniProject.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PGPlace {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public double getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(double builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private double builtUpArea;

    @Column(nullable = false)
    private double rentAmount;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String locality;

    @Column(nullable = false)
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}


