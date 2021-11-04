package com.example.backend.occupancyhandling.dataaccess.api.entity;

import com.example.backend.placehandling.dataaccess.api.entity.PlaceEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "OCCUPANCY")
@IdClass(OccupancyId.class)
public class OccupancyEntity {

    @Id
    @NotNull
    private LocalDateTime timeId;

    @Id
    @NotNull
    private Long placeId;

    @NotNull
    @JoinColumn(name = "PLACE", nullable = false)
    @ManyToOne
    private PlaceEntity place;

    @NotNull
    @Column(name = "NUMBER_OF_PEOPLE", nullable = false)
    private int number_of_people;

    @Column(name = "PERCENTAGE")
    private int percentage_occupancy;

    public LocalDateTime getTime() {
        return timeId;
    }

    public void setTime(LocalDateTime time) {
        this.timeId = time;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }

    public int getPercentage_occupancy() {
        return percentage_occupancy;
    }

    public void setPercentage_occupancy(int percentage_occupancy) {
        this.percentage_occupancy = percentage_occupancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccupancyEntity occupancy = (OccupancyEntity) o;
        return number_of_people == occupancy.number_of_people && percentage_occupancy == occupancy.percentage_occupancy && timeId.equals(occupancy.timeId) && placeId.equals(occupancy.placeId) && place.equals(occupancy.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeId, placeId, place, number_of_people, percentage_occupancy);
    }

}
