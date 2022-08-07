package br.com.donna.parking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donna.parking.controller.dto.ParkingDTO;
import br.com.donna.parking.controller.mapper.ParkingMapper;
import br.com.donna.parking.model.Parking;
import br.com.donna.parking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	private final ParkingService parkingService;
	private final ParkingMapper parkingMapper;
		
	public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
		this.parkingService = parkingService;
		this.parkingMapper = parkingMapper;
		
	}




	@GetMapping
	public List<ParkingDTO> findAll(){
		List<Parking> parkingList =  parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return result;
	}
}
