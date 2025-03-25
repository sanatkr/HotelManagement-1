package com.example.HotelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.Entity.HotelEntity;
import com.example.HotelManagement.dto.HotelDTO;
import com.example.HotelManagement.dto.UpdateHotelAddressDTO;
import com.example.HotelManagement.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping("/createHotel")
	public HotelEntity createHotel(@RequestBody HotelDTO hotelDTO)
	{
		return hotelService.saveHotel(hotelDTO);
		 
	}
	
	@GetMapping("/getAllHotels")
	public List<HotelEntity> getAllHotels()
	{
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/getHotel/{id}")
	public HotelEntity getHotelById(@PathVariable Long id)
	{
		return hotelService.getHotelById(id);
	}
	
	
	@PutMapping("/updateHotel/{id}")
	public HotelEntity updateHotel(@RequestBody HotelDTO hotelDTO,@PathVariable Long id)
	{
		return hotelService.updateHotel(hotelDTO,id);
	}
	
	@DeleteMapping("/deleteHotel/{id}")
	public void deleteHotel(@PathVariable Long id)
	{
		 hotelService.deleteHotel(id);
	}
	
	@PutMapping("/updateHotelAddress/{id}")
	public HotelEntity updateHotelAddress(@RequestBody UpdateHotelAddressDTO hotelDTO,@PathVariable Long id)
	{
		return hotelService.updateHotelAddress(hotelDTO,id);
	}

}
