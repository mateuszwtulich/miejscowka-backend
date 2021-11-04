package com.example.backend.placehandling.logic.api.to;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationEntityTransportObject;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

public class CategoryEto extends AbstractApplicationEntityTransportObject {

    @NotNull
    private String name;

    @NotNull
    private String description;

    public CategoryEto() {
    }

    public CategoryEto(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CategoryEto that = (CategoryEto) o;
        return name.equals(that.name) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description);
    }
}
