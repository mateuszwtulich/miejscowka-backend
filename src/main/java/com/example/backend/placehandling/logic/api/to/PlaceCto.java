package com.example.backend.placehandling.logic.api.to;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationEntityTransportObject;
import com.example.backend.occupancyhandling.dataaccess.api.entity.OccupancyEntity;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.example.backend.placehandling.dataaccess.api.entity.CategoryEntity;
import com.example.backend.placehandling.dataaccess.api.entity.OpeningHoursEntity;
import com.example.backend.placehandling.dataaccess.api.entity.PlaceImageEntity;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlaceCto extends AbstractApplicationEntityTransportObject {

    @NotNull
    private String name;

    @NotNull
    private int capacity;

    private String description;

    private String street;

    private String buildingNumber;

    private String apartmentNumber;

    @NotNull
    private String categoryName;

    private OccupancyTo lastOccupancyTo;

    private Boolean isFavourite;

    private String imageUrl;

    private OpeningHoursTo openingHoursTo;


    public PlaceCto() {
    }

    public PlaceCto(Long id, String name, int capacity, String description, String street, String buildingNumber, String apartmentNumber, String categoryName, OccupancyTo lastOccupancyTo, Boolean isFavourite, String imageUrl, OpeningHoursTo openingHoursTo) {
        super(id);
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.categoryName = categoryName;
        this.lastOccupancyTo = lastOccupancyTo;
        this.isFavourite = isFavourite;
        this.imageUrl = imageUrl;
        this.openingHoursTo = openingHoursTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public OccupancyTo getLastOccupancyTo() {
        return lastOccupancyTo;
    }

    public void setLastOccupancyTo(OccupancyTo lastOccupancyTo) {
        this.lastOccupancyTo = lastOccupancyTo;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OpeningHoursTo getOpeningHoursTo() {
        return openingHoursTo;
    }

    public void setOpeningHoursTo(OpeningHoursTo openingHoursTo) {
        this.openingHoursTo = openingHoursTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlaceCto placeCto = (PlaceCto) o;
        return Objects.equals(name, placeCto.name) &&
                Objects.equals(capacity, placeCto.capacity) &&
                Objects.equals(description, placeCto.description) &&
                Objects.equals(street, placeCto.street) &&
                Objects.equals(buildingNumber, placeCto.buildingNumber) &&
                Objects.equals(apartmentNumber, placeCto.apartmentNumber) &&
                Objects.equals(categoryName, placeCto.categoryName) &&
                Objects.equals(lastOccupancyTo, placeCto.lastOccupancyTo) &&
                Objects.equals(isFavourite, placeCto.isFavourite) &&
                Objects.equals(imageUrl, placeCto.imageUrl) &&
                Objects.equals(openingHoursTo, placeCto.openingHoursTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, capacity, description, street, buildingNumber, apartmentNumber, categoryName, lastOccupancyTo, isFavourite, imageUrl, openingHoursTo);
    }
}
