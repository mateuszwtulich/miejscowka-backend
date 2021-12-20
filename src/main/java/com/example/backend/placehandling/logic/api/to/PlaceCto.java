package com.example.backend.placehandling.logic.api.to;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationEntityTransportObject;
import com.example.backend.occupancyhandling.logic.api.to.OccupancyTo;
import com.sun.istack.NotNull;

import java.util.Objects;

public class PlaceCto extends AbstractApplicationEntityTransportObject {

  @NotNull
  private String name;

  @NotNull
  private String capacity;

  private String description;

  private String street;

  private String buildingNumber;

  private String apartmentNumber;

  @NotNull
  private String categoryName;

  private OccupancyTo lastOccupancyTo;

  private Boolean isFavourite;

  private String imageName;

  private String imageBase64;

  private OpeningHoursTo openingHoursTo;


  public PlaceCto() {
  }

  public PlaceCto(Long id, String name, String capacity, String description, String street, String buildingNumber, String apartmentNumber, String categoryName, OccupancyTo lastOccupancyTo, Boolean isFavourite, String imageName, String imageBase64, OpeningHoursTo openingHoursTo) {
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
    this.imageName = imageName;
    this.imageBase64 = imageBase64;
    this.openingHoursTo = openingHoursTo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCapacity() {
    return capacity;
  }

  public void setCapacity(String capacity) {
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

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public String getImageBase64() {
    return imageBase64;
  }

  public void setImageBase64(String imageBase64) {
    this.imageBase64 = imageBase64;
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
    return capacity == placeCto.capacity &&
        Objects.equals(name, placeCto.name) &&
        Objects.equals(description, placeCto.description) &&
        Objects.equals(street, placeCto.street) &&
        Objects.equals(buildingNumber, placeCto.buildingNumber) &&
        Objects.equals(apartmentNumber, placeCto.apartmentNumber) &&
        Objects.equals(categoryName, placeCto.categoryName) &&
        Objects.equals(lastOccupancyTo, placeCto.lastOccupancyTo) &&
        Objects.equals(isFavourite, placeCto.isFavourite) &&
        Objects.equals(imageName, placeCto.imageName) &&
        Objects.equals(imageBase64, placeCto.imageBase64) &&
        Objects.equals(openingHoursTo, placeCto.openingHoursTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, capacity, description, street, buildingNumber, apartmentNumber, categoryName, lastOccupancyTo, isFavourite, imageName, imageBase64, openingHoursTo);
  }
}
