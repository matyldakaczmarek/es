package com.example.es.shipment;

import java.util.UUID;

public class StopState {
    private final UUID stopId;
    private final StopStatus status;

    public StopState(UUID stopId, StopStatus status) {
        this.stopId = stopId;
        this.status = status;
    }

    public static StopState inTransit(UUID stopId) {
        return new StopState(stopId, StopStatus.IN_TRANSIT);
    }

    public static StopState arrived(UUID stopId) {
        return new StopState(stopId, StopStatus.ARRIVED);
    }

    public UUID getStopId() {
        return stopId;
    }

    public StopStatus getStatus() {
        return status;
    }

    // TODO refactor to state pattern with previous and next and so on
}
