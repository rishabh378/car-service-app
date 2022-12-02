package com.learning.service;

import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final InventoryService inventoryService;


    public Optional<Car> findById(long id) {
        return carRepository.findAll().stream().filter(car -> car.getId() == id).findFirst();
    }

    public Optional<Optional<Inventory>> findInventoryByCarId(long id) {
        Optional<Car> optionalCar = findById(id);
//        if (optionalCar.isPresent()) {
//           return  inventoryService.findById(optionalCar.get().getInventoryId());
//        }
//        return Optional.empty();
        optionalCar.get().getInventoryId();
        Optional<Inventory> optionalInventory = inventoryService.findById(123);
        return Optional.ofNullable(optionalInventory);

    }

}
