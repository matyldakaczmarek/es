package com.example.es.shipment.commands;

import com.example.es.shipment.Stop;

import java.util.ArrayList;
import java.util.UUID;

public class DispatchCommand implements ShipmentCommand {
    private final UUID shipmentId;
    private final ArrayList<Stop> stops;

    public DispatchCommand(UUID shipmentId, ArrayList<Stop> stops) {
        this.shipmentId = shipmentId;
        this.stops = stops;
    }

    @Override
    public UUID getShipmentId() {
        return shipmentId;
    }

    public ArrayList<Stop> getStops() {
        return stops;
    }
}
