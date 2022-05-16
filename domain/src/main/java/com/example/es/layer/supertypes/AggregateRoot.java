package com.example.es.layer.supertypes;

import com.example.es.layer.values.EntityId;

public abstract class AggregateRoot {
    /**
     * TODO domain events options:
     * 1. wewnetrzna kolekcja zdarzeń
     * 2. zwracanie zdarzeń (+)
     * 3. publisher
     */

    // TODO Entity superclass
    private final EntityId id;

    protected AggregateRoot(EntityId id) {
        this.id = id;
    }

    EntityId getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (getClass() != object.getClass()) {
            return false;
        }
        var other = (AggregateRoot) object;
        return other.id.toString().equals(id.toString());
    }

}
