package com.example.es.shipment;

import java.util.UUID;

public class Stop {
    private final UUID id;
    private final StopType type;

    public Stop(UUID id, StopType type) {
        this.id = id;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public StopType getType() {
        return type;
    }

//    public ShipmentStatus getStatus() {
//        return status;
//    }
//
//    public void arrive() {
//        status = ShipmentStatus.IN_TRANSIT;
//    }
//
//    public boolean isComplete() {
//        return status.equals(ShipmentStatus.DEPARTED);
//    }

    public boolean isPickup() {
        return type.equals(StopType.PICKUP);
    }

    public boolean isDelivery() {
        return type.equals(StopType.DELIVERY);
    }

//    public boolean isInTransit() {
//        return status.equals(ShipmentStatus.IN_TRANSIT);
//    }
}
