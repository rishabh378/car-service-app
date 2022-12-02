package com.learning;

import com.learning.controller.CarController;
import com.learning.entities.Car;
import com.learning.exceptions.CarNotFoundException;
import com.learning.repositories.AccessoryRepository;
import com.learning.repositories.CarRepository;
import com.learning.repositories.InventoryRepository;
import com.learning.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CarServiceAppApplication implements CommandLineRunner {

	@Autowired
	private CarController carController;

	@Autowired
	private CarService carService;

	public static void main(String[] args) {
		SpringApplication.run(CarServiceAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		carService.carMethod();
		log.info("Execution Done");
	}

	private void testCases() {
		try {
			System.out.println(carController.getCar(15).getName().equalsIgnoreCase("thar") ? "Test Case Passed" : "Test Case Failed");
		}catch (CarNotFoundException exceptions){
			log.error(exceptions.getMessage(), exceptions);
		}catch (Exception exception){
			log.error(exception.getMessage(), exception);
		}

		try {
			System.out.println(carController.getCar(16).getName().equalsIgnoreCase("thar") ? "Test Case Passed" : "Test Case Failed");
		}catch (CarNotFoundException exceptions){
			log.error(exceptions.getMessage(), exceptions);
		}catch (Exception exception){
			log.error(exception.getMessage(), exception);
		}

		log.info("Execution Completes");
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
