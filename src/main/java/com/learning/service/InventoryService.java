package com.learning.service;

import com.learning.entities.Inventory;
import com.learning.repositories.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository; // immutable object

    public Optional<Inventory> findById(long id) {
        return inventoryRepository.findAll().stream().filter(inventory -> inventory.getId() == id).findFirst();
    }
}
