package com.example.backend.occupancyhandling.api.entity;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationPersistenceEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "OCCUMPANCY")
@IdClass(OccupancyId.class)
public class Occupancy {

    @Id
    @NotNull
    private LocalDateTime timeId;

    @Id
    @NotNull
    private Long placeId;

    @NotNull
    @JoinColumn(name = "PLACE", nullable = false)
    @ManyToOne
    private Place place;

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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
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
        Occupancy occupancy = (Occupancy) o;
        return number_of_people == occupancy.number_of_people && percentage_occupancy == occupancy.percentage_occupancy && timeId.equals(occupancy.timeId) && placeId.equals(occupancy.placeId) && place.equals(occupancy.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeId, placeId, place, number_of_people, percentage_occupancy);
    }

    //    @NotNull
//    @Column(name = "NAME", nullable = false, unique = true)
//    private String name;
//
//    @NotNull
//    @Column(name = "FINAL_DATE", nullable = false)
//    private LocalDate finalDate;
//
//    @NotNull
//    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinColumn(name = "USER_ID", nullable = false, referencedColumnName = "id")
}
