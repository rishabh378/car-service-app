package com.learning.service;

import com.learning.entities.Accessory;
import com.learning.entities.Car;
import com.learning.repositories.AccessoryRepository;
import com.learning.repositories.CarRepository;
import models.Accessory;
import models.Car;
import repository.AccessoryRepository;
import repository.CarRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AccessoryService {

    private final AccessoryRepository accessoryRepository;
    private CarService carService;

    public AccessoryService(AccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    public Optional<Accessory> findById(long id) {
        List<Accessory> allAccessories = accessoryRepository.findAll();
        Optional<Accessory> optionalAccessory = allAccessories.stream().filter(accessory -> accessory.getId() == id).findFirst();
        return optionalAccessory;
    }

    public Optional<Car> findCarByAccessoryId(long id) {
        Optional<Accessory> optionalAccessory = findById(id);
        if(optionalAccessory.isPresent()) {
            Accessory accessory = optionalAccessory.get();
            long carId = accessory.getCarId();
            CarService carService = getInstance();
            return carService.findById(carId);
        }
        return Optional.empty();
    }

    private CarService getInstance() {
        if(Objects.isNull(carService)) {
           carService = new CarService(new CarRepository());
        }
        return carService;
    }
}
