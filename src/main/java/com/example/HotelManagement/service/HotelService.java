package com.example.HotelManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.HotelManagement.Entity.HotelEntity;
import com.example.HotelManagement.dto.HotelDTO;
import com.example.HotelManagement.dto.UpdateHotelAddressDTO;
import com.example.HotelManagement.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	public HotelEntity saveHotel(HotelDTO hotelDTO)
	{
		HotelEntity hotel = new HotelEntity();
		
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(hotelDTO.getCity());
		hotel.setPostalCode(hotelDTO.getPostalCode());
		hotel.setRating(hotelDTO.getRating());
		hotel.setAvailability(hotelDTO.getAvailable());
		
		hotelRepository.save(hotel);
		return hotel;
	}
	
	public List<HotelEntity> getAllHotels()
	{
		return hotelRepository.findAll();
	}
	
	public HotelEntity getHotelById(Long id)
	{
		
		Optional<HotelEntity> hotelBox = hotelRepository.findById(id);
		
		if(hotelBox.isPresent())
		{
			return hotelBox.get();
		}
		else
		{
			return null;
		}
	}
	
	public HotelEntity updateHotel(HotelDTO hotelDTO,Long id)
	{
		HotelEntity hotel = getHotelById(id);
		
		if(hotel!=null)
		{
			hotel.setName(hotelDTO.getName());
			hotel.setAddress(hotelDTO.getAddress());
			hotel.setCity(hotelDTO.getCity());
			hotel.setPostalCode(hotelDTO.getPostalCode());
			hotel.setRating(hotelDTO.getRating());
			hotel.setAvailability(hotelDTO.getAvailable());
			
			hotelRepository.save(hotel);
			return hotel;
		}
		else
		{
			return null;
		}
	}
	
	public void deleteHotel(Long id)
	{
		HotelEntity hotel = getHotelById(id);
		if(hotel!=null)
		{
			hotelRepository.deleteById(id);
		}
	}
	
	
	@PutMapping
	public HotelEntity updateHotelAddress(UpdateHotelAddressDTO hotelDTO,Long id)
	{
		HotelEntity hotel = getHotelById(id);
		if(hotel!=null)
		{
			
			hotel.setAddress(hotelDTO.getAddress());
			hotel.setCity(hotelDTO.getCity());
			hotel.setPostalCode(hotelDTO.getPostalCode());
			hotelRepository.save(hotel);
			return hotel;
		}
		else
		{
			return null;
		}
	}

}
