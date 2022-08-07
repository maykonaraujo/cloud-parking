package br.com.donna.parking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.donna.parking.model.Parking;

@Service
public class ParkingService {
	private static Map<String, Parking> parkingMap = new HashMap();
	
	static {
		var id = getUUID();
		Parking parking = new Parking(id, "NSL-3361", "PA", "HONDA FIT", "PRETO");
		parkingMap.put(id, parking);
		
	}
	
	public List<Parking> findAll(){
		return parkingMap.values().stream().collect(Collectors.toList());
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
