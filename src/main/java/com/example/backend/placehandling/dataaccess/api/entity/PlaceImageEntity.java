package com.example.backend.placehandling.dataaccess.api.entity;


import com.example.backend.general.dataaccess.api.entity.AbstractApplicationPersistenceEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "PLACE_IMAGE")
public class PlaceImageEntity extends AbstractApplicationPersistenceEntity {


    public PlaceImageEntity() {
    }

    public PlaceImageEntity(PlaceEntity place, String name) {
        this.place = place;
        this.name = name;
    }

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PLACE_ID", nullable = false, referencedColumnName = "id")
    private PlaceEntity place;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "BASE64", columnDefinition = "BYTEA")
    private byte[] base64;

    public byte[] getBase64() {
        return base64;
    }

    public void setBase64(byte[] base64) {
        this.base64 = base64;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String url) {
        this.name = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlaceImageEntity that = (PlaceImageEntity) o;
        return Objects.equals(place, that.place) &&
            Objects.equals(name, that.name) &&
            Arrays.equals(base64, that.base64);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), place, name);
        result = 31 * result + Arrays.hashCode(base64);
        return result;
    }
}
