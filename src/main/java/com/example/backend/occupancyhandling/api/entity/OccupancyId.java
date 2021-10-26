package com.example.backend.occupancyhandling.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class OccupancyId implements Serializable {
    private Long placeId;
    private LocalDateTime timeId;

    public OccupancyId(Long palceId, LocalDateTime timeId) {
        this.placeId = palceId;
        this.timeId = timeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccupancyId that = (OccupancyId) o;
        return placeId.equals(that.placeId) && timeId.equals(that.timeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, timeId);
    }
}
