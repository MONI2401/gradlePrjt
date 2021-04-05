package com.cg.cars.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	
	@Column(name="Brand",nullable=false,length=50)
	private String brand;
	
	@Column(name="Model",nullable=false,length=50)
	private String model;
	
	@Column(name="Variant",nullable=false,length=50)
	private String variant;
	
	@Column(name="REG_YR",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registrationYear;
	
	@Column(name="REG_State",nullable = false)
	private String registrationState;

	
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name="userId",nullable=false)
	private List<Customer> customers;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public Date getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(Date registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getRegistrationState() {
		return registrationState;
	}

	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

	public Car() {
		super();
		
	}

	
	
	

}
