package com.learning;

import com.learning.repositories.AccessoryRepository;
import com.learning.repositories.CarRepository;
import com.learning.repositories.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CarServiceAppApplication implements CommandLineRunner {

	@Autowired
	private AccessoryRepository accesoryRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarServiceAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	private void saveAccessoryData() {
//		List<Accessory> accesoryList = findAllAccessories();
//		accesoryRepository.saveAll(accesoryList);
//		log.info("Accessory data store");


	}

	private void saveCarData() {
//		carRepository.saveAll(findAllCars());
//		log.info("Car Data Store");
	}

	private void saveInventoryData() {
//		inventoryRepository.saveAll(findAllInventories());
//		log.info("Inventory Data Store");
	}

}
