package com.example.es.shipment.events;

import java.util.UUID;

public class ArrivedEvent implements ShipmentEvent {

    private final UUID shipmentId;
    private final UUID stopId;
    // TODO dates?

    public ArrivedEvent(UUID shipmentId, UUID stopId) {
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
