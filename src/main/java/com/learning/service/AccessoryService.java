package com.learning.service;

import com.learning.entities.Accessory;
import com.learning.entities.Car;
import com.learning.repositories.AccessoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessoryService {

    private final AccessoryRepository accessoryRepository;
    private CarService carService;

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
            return carService.findById(carId);
        }
        return Optional.empty();
    }
}
