package com.example.es.layer.values;

import lombok.NonNull;

import java.io.Serializable;
import java.util.UUID;

public class EntityId implements Serializable {
    @NonNull
    private final UUID value;

    public EntityId(UUID aggregateId) {
        this.value = aggregateId;
    }

    public static EntityId generate() {
        return new EntityId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
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
        return object.toString().equals(toString());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
