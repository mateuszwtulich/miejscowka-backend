package com.example.backend.placehandling.logic.api.to;

import com.sun.istack.NotNull;

import java.util.Objects;

public class CategoryTo {


    @NotNull
    private String name;

    @NotNull
    private String description;

    public CategoryTo() {
    }

    public CategoryTo(String name, String description) {
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
        CategoryTo that = (CategoryTo) o;
        return name.equals(that.name) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}


