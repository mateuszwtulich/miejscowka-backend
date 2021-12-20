package com.example.backend.placehandling.logic.api.to;

import com.sun.istack.NotNull;

import java.util.Objects;

public class PlaceTo {

    @NotNull
    private String name;

    @NotNull
    private Integer capacity;

    private String description;

    private String street;

    private String buildingNumber;

    private String apartmentNumber;

    @NotNull
    private Long categoryId;

    private String imageName;

    private String base64Image;

    private OpeningHoursTo openingHoursTo;

    public PlaceTo(String name, Integer capacity, String description, String street, String buildingNumber, String apartmentNumber, Long categoryId, String imageName, String base64Image, OpeningHoursTo openingHoursTo) {
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.categoryId = categoryId;
        this.imageName = imageName;
        this.base64Image = base64Image;
        this.openingHoursTo = openingHoursTo;
    }

    public PlaceTo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
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
        PlaceTo placeTo = (PlaceTo) o;
        return Objects.equals(name, placeTo.name) &&
            Objects.equals(capacity, placeTo.capacity) &&
            Objects.equals(description, placeTo.description) &&
            Objects.equals(street, placeTo.street) &&
            Objects.equals(buildingNumber, placeTo.buildingNumber) &&
            Objects.equals(apartmentNumber, placeTo.apartmentNumber) &&
            Objects.equals(categoryId, placeTo.categoryId) &&
            Objects.equals(imageName, placeTo.imageName) &&
            Objects.equals(base64Image, placeTo.base64Image) &&
            Objects.equals(openingHoursTo, placeTo.openingHoursTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, description, street, buildingNumber, apartmentNumber, categoryId, imageName, base64Image, openingHoursTo);
    }
}
