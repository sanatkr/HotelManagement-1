package com.example.HotelManagement.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HotelEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	private String address;
	private String city;
	private int postalCode;
	private float rating;
	
	
	@Column(name = "available")
	private boolean isAvailable;
	
}
