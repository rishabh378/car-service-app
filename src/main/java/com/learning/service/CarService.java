package com.learning.service;

import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final InventoryService inventoryService;


    public Optional<Car> findById(long id) {
        //return carRepository.findAll().stream().filter(car -> car.getId() == id).findFirst();
        return carRepository.findById(id);
    }

    public Optional<Inventory> findInventoryByCarId(long id) {

        return Optional.ofNullable(inventoryService.
                        findById(findById(id).orElse(null).
                        getInventoryId()).orElse(null));
    }

    public void carMethod() {
        Map<Long, Car> carMap = carRepository.findAll().stream().
                filter(car -> car.getId() < 10).
                collect(Collectors.toMap(car -> car.getId(), car ->  car ));
        System.out.println(carMap);
    }
}
