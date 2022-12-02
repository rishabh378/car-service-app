package com.learning.models;

import com.learning.enums.InventoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private InventoryResponse inventoryResponse;
    private CarResponse carResponse;
    private AccessoryResponse accessoryResponse;
    @Data
    @Builder
    public static class InventoryResponse {
        private long id;
        private String location;
        private InventoryType type;
    }
    @Data
    @Builder
    public static class CarResponse {
        private long id;
        private String name;
        private String brand;
        private int modelNo;
        private long inventoryId;
    }
    @Data
    @Builder
    public static class AccessoryResponse {
        private long id;
        private String name;
        private double price;
        private long carId;
    }
}
