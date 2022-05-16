package com.example.es.shipment.commands;

import java.util.UUID;

public class ArriveCommand implements ShipmentCommand {
    private final UUID shipmentId;
    private final UUID stopId;

    public ArriveCommand(UUID shipmentId, UUID stopId) {
        this.shipmentId = shipmentId;
        this.stopId = stopId;
    }

    @Override
    public UUID getShipmentId() {
        return shipmentId;
    }

    public UUID getStopId() {
        return stopId;
    }
}
