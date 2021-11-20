package com.example.backend.occupancyhandling.logic.api.to;

import com.sun.istack.NotNull;

import java.util.Objects;

public class OccupancyTo {

    @NotNull
    private int numberOfPeople;

    private int percentageOccupancy;

    public OccupancyTo() {
    }

    public OccupancyTo(int number_of_people, int percentageOccupancy) {
        this.numberOfPeople = number_of_people;
        this.percentageOccupancy = percentageOccupancy;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getPercentageOccupancy() {
        return percentageOccupancy;
    }

    public void setPercentageOccupancy(int percentageOccupancy) {
        this.percentageOccupancy = percentageOccupancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccupancyTo that = (OccupancyTo) o;
        return numberOfPeople == that.numberOfPeople &&
                percentageOccupancy == that.percentageOccupancy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPeople, percentageOccupancy);
    }
}
