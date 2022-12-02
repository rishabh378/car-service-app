package com.learning.models;

import com.learning.enums.InventoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    private InventoryRequest inventoryRequest;
    private CarRequest carRequest;
    private AccessoryRequest accessoryRequest;

    @Data
    @Builder
    public static class InventoryRequest {
        private long id;
        private String location;
        private InventoryType type;
    }
    @Data
    @Builder
    public static class CarRequest {
        private long id;
        private String name;
        private String brand;
        private int modelNo;
        private long inventoryId;
    }
    @Data
    @Builder
    public static class AccessoryRequest {
        private long id;
        private String name;
        private double price;
        private long carId;
    }
}
