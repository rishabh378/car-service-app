package com.learning.controller;

import com.learning.constants.ExceptionMessage;
import com.learning.entities.Car;
import com.learning.entities.Inventory;
import com.learning.exceptions.CarNotFoundException;
import com.learning.exceptions.InventoryNotFoundException;
import com.learning.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    public Car getCar(@PathVariable long id)
    {
        return carService.findById(id)
                .orElseThrow(() -> new CarNotFoundException(ExceptionMessage.CAR_NOT_FOUND + id));
    }

    @GetMapping("/inventory-car/{id}")
    public Inventory getInventoryByCarId(@PathVariable long id) {
        return carService.findInventoryByCarId(id)
                .orElseThrow(() -> new InventoryNotFoundException(ExceptionMessage.INVENTORY_NOT_FOUND + id));
    }

}
