package com.example.HotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelManagement.Entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity,Long>{
	

}
