package com.example.es.shipment;

import com.example.es.shipment.commands.ArriveCommand;
import com.example.es.shipment.commands.DispatchCommand;
import com.example.es.shipment.commands.ShipmentCommand;
import com.example.es.shipment.events.ArrivedEvent;
import com.example.es.shipment.events.DispatchedEvent;
import com.example.es.shipment.events.ShipmentEvent;
import io.vavr.Predicates;

import java.util.ArrayList;
import java.util.UUID;

import static io.vavr.API.*;

//TODO add AggregateRoot annotation
public class Shipment {

    private final UUID shipmentId;
    private final StopState currentState;
    private final ArrayList<Stop> stops;

    private Shipment(UUID shipmentId, StopState currentStop, ArrayList<Stop> stops) {
        this.shipmentId = shipmentId;
        this.currentState = currentStop;
        this.stops = stops;
    }

    public Shipment() {
        this.shipmentId = UUID.randomUUID();
        this.currentState = null;
        this.stops = new ArrayList<>();
    }

    private DispatchedEvent dispatch(DispatchCommand command) {
        if (hasBeenDispatched()) {
            // TODO rule: shipment can be only dispatched once
        }

        var stops = command.getStops();
        var stopsCount = stops.size();

        if (stopsCount < 2) {
            // TODO rule: there has to be at least 2 stops
        }

        var firstStop = stops.get(0);
        var lastStop = stops.get(stopsCount - 1);

        if (!firstStop.isPickup()) {
            // TODO rule: first stop must be of pickup type
        }

        if (!lastStop.isDelivery()) {
            // TODO rule: last stop must be of delivery type
        }
        return new DispatchedEvent(command.getShipmentId(), stops);
    }

    private ArrivedEvent arrive(ArriveCommand command) {
//        if (isComplete()) {
//            // TODO rule: can not be complete
//        }

        if (!currentState.getStopId().equals(command.getStopId())) {
            // TODO rule: continuity needs to be preserved!
        }

//        if (!currentStop.isInTransit()) {
//            // TODO rule: shipment has already arrived (maybe better to check if it's arrived??)
//        }
        return new ArrivedEvent(command.getShipmentId(), command.getStopId());
    }

    private void pickup() {
        // TODO rule: shipment ca not be completed
        // TODO rule: same stop id
        // TODO rule: stop must be of pickup type
        // TODO rule: shipment must be in arrived state

        // first stop departed -> second stop in transit
        // delivery stop arrived

        // can not be the last stop

    }

    // change route (re-route from current stop)

    private void deliver() {
//last stop departed
    }

    public ShipmentEvent handle(ShipmentCommand command) {
        return Match(command).of(
                Case($(Predicates.instanceOf(DispatchCommand.class)), this::dispatch),
                Case($(Predicates.instanceOf(ArriveCommand.class)), this::arrive)
        );
    }

    public Shipment apply(ShipmentEvent event) {
        // if + instanceof
        // visitor pattern

        // pattern matching
        return Match(event).of(
                Case($(Predicates.instanceOf(DispatchedEvent.class)), this::applyDispatched),
                Case($(Predicates.instanceOf(ArrivedEvent.class)), this::applyArrived)
        );
    }

    private Shipment applyDispatched(DispatchedEvent event) {
        var stops = event.getStops();
        var firstStop = stops.get(0);
        return new Shipment(event.getShipmentId(), StopState.inTransit(firstStop.getId()), stops);
    }

    private Shipment applyArrived(ArrivedEvent event) {
//        currentStop.arrive();
        return new Shipment(shipmentId, StopState.arrived(event.getStopId()), stops); // from shipment
    }

    private Stop getLastStop() {
        return stops.get(stops.size() - 1);
    }

    private boolean hasBeenDispatched() {
        return this.currentState != null;
    }

//    private boolean isComplete() {
//        return getLastStop().isComplete();
//    }

// TODO model stops!
}
